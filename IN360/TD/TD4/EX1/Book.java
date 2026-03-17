package EX1;

public class Book{
    private int tag_rfid;
    private String auteur;
    private String titre;
    private String date_achat;
    private float prix;

    Book(int tag_rfid, String auteur, String titre, String date_achat, float prix){
        this.tag_rfid = tag_rfid;
        this.auteur = auteur;
        this.titre = titre;
        this.date_achat = date_achat;
        this.prix = prix;
    }

    /* Getters */
    public String getAuteur() {
        return auteur;
    }
    public String getDate_achat() {
        return date_achat;
    }
    public float getPrix() {
        return prix;
    }
    public int getTag_rfid() {
        return tag_rfid;
    }
    public String getTitre() {
        return titre;
    }
    /* FIN Getters */

    /* Setters */
    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }
    public void setDate_achat(String date_achat) {
        this.date_achat = date_achat;
    }
    public void setPrix(float prix) {
        this.prix = prix;
    }
    public void setTag_rfid(int tag_rfid) {
        this.tag_rfid = tag_rfid;
    }
    public void setTitre(String titre) {
        this.titre = titre;
    }
    /* FIN Setters */


    public static void main(String[] args) {
        Book livre1 = ;
    }


}