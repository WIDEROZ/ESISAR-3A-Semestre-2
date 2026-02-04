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
            heures = heure;
        }
    }
    public void setMinutes(int minute){
        minutes = minute;
    }
    public void setSecondes(int seconde){
        secondes = seconde;
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
            secondes = 59;
        }
        else{
            secondes--;
        }
    }


    /* Main */
    public static void main(String[] args){
        int i = 0;
        while (i ) {
            
        }
    }


}
