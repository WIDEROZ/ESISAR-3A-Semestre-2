package EX1;

public class Romans extends Livre {
    protected int prix_lit; // 0 : GONCOURT, 1 : MEDICIS, 2 : INTERALLIE

    public Romans(int id, String titre, int nb_pages, String auteur, int prix_lit){
        super(id, titre, nb_pages, auteur);

        this.prix_lit = prix_lit;
    }
    

}