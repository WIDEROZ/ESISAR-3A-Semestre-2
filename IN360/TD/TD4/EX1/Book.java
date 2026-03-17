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


    public void printInfo(){
        System.out.println("Tag RFID : " + tag_rfid);
        System.out.println("Auteur : " + auteur);
        System.out.println("Titre : " + titre);
        System.out.println("date_achat : " + date_achat);
        System.out.println("Prix : " + prix);
    }

    public static void main(String[] args) {
        Book livre1 = new Book(1, "Georges Orwell", "1984", "17-03-2026", 39.99f);
        Book livre2 = new Book(2, "Baruch Spinoza", "Traité théologico-politique", "12-08-1712", 9.99f);
        

        livre1.printInfo();
        livre2.printInfo();
    }


}