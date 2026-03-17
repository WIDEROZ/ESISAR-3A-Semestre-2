package EX3;

public class CD {
    private int tag_rfid;
    private String chanteur;
    private String compositeur;
    private String titre;
    private int nombreChansons;
    private String date_achat;
    private float prix;
    private boolean disponible;

    CD(int tag_rfid, String chanteur, String compositeur, String titre, int nombreChansons, String date_achat, float prix, boolean disponible){
        this.tag_rfid = tag_rfid;
        this.chanteur = chanteur;
        this.compositeur = compositeur;
        this.titre = titre;
        this.nombreChansons = nombreChansons;
        this.date_achat = date_achat;
        this.prix = prix;
        this.disponible = disponible;
    }


    /* Getters */
    public String getChanteur() {
        return chanteur;
    }
    public String getCompositeur() {
        return compositeur;
    }
    public String getDate_achat() {
        return date_achat;
    }
    public int getNombreChansons() {
        return nombreChansons;
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

    public void setChanteur(String chanteur) {
        this.chanteur = chanteur;
    }
    public void setCompositeur(String compositeur) {
        this.compositeur = compositeur;
    }
    public void setDate_achat(String date_achat) {
        this.date_achat = date_achat;
    }
    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
    public void setNombreChansons(int nombreChansons) {
        this.nombreChansons = nombreChansons;
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

    


}
