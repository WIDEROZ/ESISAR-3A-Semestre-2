package EX2;
import java.util.ArrayList;

import javax.swing.text.Segment;

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

    public void remplirAll(String nomCouleur){
        for(Figure fig : dessin){
            if(!(fig instanceof Droite || fig instanceof Segment)){
                fig.remplir(nomCouleur);
            }
        }
    }
}