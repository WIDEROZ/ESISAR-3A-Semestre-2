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
        heures = heure;
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
                
            }
            else{
                
            }
        }
        else{
            secondes--;
        }
    }


}
