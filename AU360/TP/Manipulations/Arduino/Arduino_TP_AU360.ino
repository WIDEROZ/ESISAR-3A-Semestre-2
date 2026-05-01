/*
Programme Commande

Commande de la MicroEnceinte Climatique par :
   Correcteur de différents types
   
Période d'échantillonnage : Te = 10ms (modifiable, valeur min = 1ms)

Entrées analogiques : ADC0 et ADC1  (2 CAN 10 bits de 0..5V à 0..1023)
  ADC0 : entrée de mesure   : utiliser l'entrée E0/2
  ADC1 : entrée de consigne : utiliser l'entrée E1
Sortie PWM : Analog 6    (sortie PWM 0..255 à f = 980 Hz)
*/

#define interval_Te_us (10000)    // Te en micro secondes
#define conv_ADC2Volt (5./1024.)  // Convert DAC (0..1023) to Volt (0..4.995)
#define conv_Volt2PWM (256./5.)   // Convert Volt (0..5) to PWM (0..255)
#define ledPin        (13)        // Sortie numérique 13 pour mesure temps de calcul

// Variable globale mémorisée pour imposition Te
unsigned long endTime = interval_Te_us; // Instant du prochain calcul 

// Variables globales du programme de commande
float Commande  = 0.0;    // commande instant n.Te
float ConsF = 0.0;        // Consigne filtrée

// Initialisations
void setup() {
  pinMode(ledPin, OUTPUT);    // Configure la PIN "ledPin" en sortie
}

// Programme de calcul
void loop() {                // boucle sans fin

  unsigned int   analog_in0;  // mémoire pour stocker la valeur de l'entrée analogique 0
  unsigned int   analog_in1;  // mémoire pour stocker la valeur de l'entrée analogique 1
  int            analog_out6; // mémoire pour stocker la valeur de la sortie PWM 6
  unsigned int   iCommande;

  float f_cons;     // mémoire pour le stockage temporaire de la consigne 
  float f_mes ;     // mémoire pour le stockage temporaire de la mesure
  float erreur;     // mémoire temporaire à usage général
   
  if( endTime < micros() )  // test si Te temps écoulé
  {
    endTime = micros() + interval_Te_us ;   // réinitialise compteur de temps
    digitalWrite(ledPin,HIGH);              // mise à 1 sortie numérique 

 // Acquisition des entrées analogiques
    analog_in0 = analogRead(0);                 // Acquisition CAN 10 bits (0..1023)          
    f_mes = conv_ADC2Volt *2.0* (float)analog_in0;  // Conversion mesure entre 0 et 5V. 
                                                // * 2 car pont diviseur (entrée E0/2)
 
    analog_in1 = analogRead(1);                 // Acquisition CAN 10 bits (0..1023)
    f_cons = conv_ADC2Volt * (float)analog_in1; // Conversion consigne entre 0 et 5V

      ConsF = f_cons + 0.5*(ConsF - f_cons) ;
      erreur = ConsF - f_mes; 
      Commande = 5.0*erreur;
 

// Saturation de la commande entre 0 et 5
    Commande = min(Commande, 5.0);
    Commande = max(Commande, 0.0);

// Calcul et application de la valeur du PWM entre 0 et 255
    analog_out6 = (int)(conv_Volt2PWM * Commande);    // Conversion de 0..5 à 0..255
    analog_out6 = min(analog_out6, 255);
    analog_out6 = max(analog_out6, 0);
    analogWrite(6, analog_out6);  // Ecriture sur la sortie PWM d'une valeur entre 0 et 255

    digitalWrite(ledPin,LOW);     // mise à 0 sortie numérique
                                  // l'observation de cette sortie numérique à l'oscilloscope 
                                  // permet de mesurer le temps de calcul de la commande
  }
}

