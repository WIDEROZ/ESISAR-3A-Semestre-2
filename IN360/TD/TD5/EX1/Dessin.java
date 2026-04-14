package EX1;
import java.util.ArrayList;

public class Dessin{
    private ArrayList<Figure> dessin = new ArrayList<Figure>();

    public Dessin(){

    }

    public void ajouter(Figure figure){
        dessin.add(figure);
    }

    public void afficher(){
        for (Figure fig : dessin) {
            fig.afficher();
        }
    }

    public void deplace(int dx, int dy){
        for (Figure fig : dessin) {
            fig.deplace(dx, dy);
        }
    }
}