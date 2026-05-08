w# 2 - Travail en séances de Travaux Pratiques

## 2.1 - Construction du simulateur numérique

En premier lieux on modélise l'enceinte climatique avec capteur et actionneur :
![[Pasted image 20260502071506.png]]
#### Consigne
On somme deux signaux rectangles pour obtenir la même consigne que sur le schéma donné en énoncé :
![[Pasted image 20260502063253.png]]

#### Actionneur
D'après l'équation donné dans la partie préparation :
$$T_{act}(t)=  30V_{act}(t) -50$$
![[Pasted image 20260502063429.png]]

#### Enceinte climatique
Sous forme de représentation d'état, on a :
$$H(p) = \frac{1}{1+\tau p}$$
Alors, 
$$(1+\tau p)T_{capt} = T_{act}$$
Donc, 
$$\frac{\partial T_{capt}}{\partial t} =\frac{1}{\tau} T_{act}-\frac{1}{\tau}T_{capt}$$
Alors en posant : 
$$X = T_{capt} \text{ puis } U=T_{act} \text{ et } Y = X$$
On a ainsi : 
$$X' = AX + BU \text{ et } Y = CX + DU$$
Avec : 
$$\boxed{\begin{cases}
A=-\frac{1}{\tau} = -2 \\
B = \frac{1}{\tau} = 2  \\
C = 1 \\
D=0
\end{cases}}$$
De plus d'après le travail en préparation la température à l'intérieur de l'enceinte est initialement à $9.95°C$ : 
![[Pasted image 20260502071106.png]]

#### Capteur
D'après l'équation mentionné en préparation : 
$$V_{c}(t) = \frac{1}{13} (T_{enc}(t)  + 5)$$
![[Pasted image 20260502071158.png]]

#### Sortie
##### Sans bruit
![[Pasted image 20260502071334.png]]

##### Avec bruit
![[Pasted image 20260502071441.png]]


## 2.2 - Validation théorique, sur simulateur et expérimentalement des commandes élaborées ^b2
### 2.2.1. Script MATLAB
#### Correcteur 3.1
![[Pasted image 20260502101632.png]]


#### Correcteur 3.2
![[Pasted image 20260502101457.png]]

#### Correcteur 4.1
![[Pasted image 20260502113312.png]]

#### Correcteur 4.2




### 2.2.2 - Simulink
#### a. Présentation des schémas-blocs
Voici le système final :
![[Pasted image 20260502102917.png]]
##### CNA
![[Pasted image 20260502103000.png]]
Nous avons aussi placé un CAN devant le préfiltre pour qu'il envoie bien des bits au calculateur. 

##### CAN
![[Pasted image 20260502103022.png]]

##### BOZ
Le BOZ après le CNA à été configuré pour s'activer à chaque période $T_{e}$.

##### FAR
On a modélisé le FAR par un retard pur d'une période. 

##### Calculateurs
![[Pasted image 20260502103141.png]]
On peut choisir ou non de mettre un retard pur de $10 \, \text{ms}$ (ce qui permet aussi de vérifier si les marges de retard sont assez grandes)

##### Pré-Filtres
![[Pasted image 20260502103510.png]]

#### Perturbations
Nous avons ajouté un bruit blanc de mesure et un une perturbation avant l'actionneur pour vérifier le temps de rejet d'une perturbation. 

#### b. Simulation
On exposera uniquement les systèmes avec un retard de $20 \, ms$ du au calculateur.

En jaune : La réponse.
En Bleu : La référence.
##### Correcteur $3.1$
![[Pasted image 20260502104608.png]]

##### Correcteur $3.2$
###### Sans préfiltre
![[Pasted image 20260502104515.png]]

###### Avec préfiltre
![[Pasted image 20260502104458.png]]

##### Correcteur 4.1
![[Pasted image 20260502104649.png]]

##### Correcteur 4.2
###### Sans préfiltre
![[Pasted image 20260502104726.png]]



###### Avec préfiltre
![[Pasted image 20260502104757.png]]


### 2.2.3 - Implantation sur Arduino
Pour le code, voir Annexe $2$.
Pour changer facilement de Correcteur nous avons défini une variable préprocesseur (dans le code, elle se nomme : "mode") le mode $1$ correspond au Correcteur $4.1$ et le mode $2$ au correcteur $4.2$.

Lors de l'implémentation, on nous a conseillé de garder le pré-filtre déjà présent sur le code Arduino : 
$$\text{ConsF = f\_cons + 0.5*(ConsF - f\_cons) }$$
Chaque division horizontale est égale à $0.5\, V$ et chaque division verticale à $1\, s$ :
#### Correcteur $4.1$
![[Pasted image 20260502110201.png]]
La perturbation a plus de mal à être rejeté par le système physique comparativement à la simulation. 

#### Correcteur $4.2$
##### Avec le pré-filtre déjà présent
![[Pasted image 20260502111617.png]]
Le comportement physique est similaire comparé à celui dans la simulation.

##### Avec notre pré-filtre
![[Pasted image 20260502111936.png]]
On a remarqué trop tard qu'il y avait un décalage dû à une erreur de frappe dans l'expression du pré-filtre.
