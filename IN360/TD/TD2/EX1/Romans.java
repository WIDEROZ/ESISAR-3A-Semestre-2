package EX1;

public class Romans extends Livre {
    protected int prix_lit;// 0 : GONCOURT, 1 : MEDICIS, 2 : INTERALLIE

    public Romans(int id, String titre, int prix_lit){
        this.id = id;
        this.titre = titre;
        this.prix_lit = prix_lit;
    }

}