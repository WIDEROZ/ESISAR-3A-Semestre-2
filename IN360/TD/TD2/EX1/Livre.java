package EX1;

public class Livre extends Document {
    protected int nb_pages;
    protected String auteur;

    public Livre(int id, String titre, int nb_pages, String auteur){
        super(id, titre);

        this.nb_pages = nb_pages;
        this.auteur = auteur;
    }


}
