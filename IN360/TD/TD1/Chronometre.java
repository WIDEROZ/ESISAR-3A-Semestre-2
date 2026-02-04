import java.util.concurrent.TimeUnit;

public class Chronometre {
    private int heures;
    private int minutes;
    private int secondes;



    public Chronometre(){
        heures = 0;
        minutes = 0;
        secondes = 0;
    }

    /* Getters */

    public int getHeures(){
        return heures;
    }
    public int getMinutes(){
        return minutes;
    }
    public int getSecondes(){
        return secondes;
    }

    /* Setters */

    public void setHeures(int heure){
        if(heure >= 24 || heure < 0){
            System.out.println("Mauvais format pour l'heure");
        }
        else{
            heures = heure;
        }
    }
    public void setMinutes(int minute){
        if(minute >= 60 || minute < 0){
            System.out.println("Mauvais format pour les minutes");
        }
        else{
            minutes = minute;
        }
        
    }
    public void setSecondes(int seconde){
        if(seconde >= 60 || seconde < 0){
            System.out.println("Mauvais format pour les minutes");
        }
        else{
            secondes = seconde;
        }
    }

    /* Rebours */

    public void rebours(){
        if (secondes == 0) {
            if (minutes == 0) {
                if (heures == 0) {
                    heures=23;
                }
                else{
                    heures--;
                }
                minutes=59;
            }
            else{
                minutes --;
            }
            secondes = 59;
        }
        else{
            secondes--;
        }
    }


    /* Main */
    public static void main(String[] args) throws InterruptedException{
        Chronometre chrono = new Chronometre();

        String heure = "00";
        String minute = "00";
        String seconde = "00";

        chrono.setMinutes(40);

        int heures = chrono.getHeures();
        int minutes = chrono.getMinutes();
        int secondes = chrono.getSecondes();

        while (heures + minutes + secondes != 0){

            heure = String.format("%02d", heures);
            minute = String.format("%02d", minutes);
            seconde = String.format("%02d", secondes);


            System.out.println("Chrono : " + heure + ':' + minute + ':' + seconde);
            TimeUnit.SECONDS.sleep(1);

            chrono.rebours();
            heures = chrono.getHeures();
            minutes = chrono.getMinutes();
            secondes = chrono.getSecondes();
        }
        System.out.println("Fin du cours!");
    }


}


