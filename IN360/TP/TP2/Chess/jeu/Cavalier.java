package jeu;

public class Cavalier extends Piece{
    Cavalier(String couleur){
		super(couleur);
	}


    @Override
	public boolean bouger(int positionD, int positionF){
        if((positionF-positionD) == -12 || (positionF-positionD) == -8
        || (positionF-positionD) == 12 || (positionF-positionD) == 8){
            return true;
        }
        // Déplement en L : 
        // négatif : de droite à gauche
        // 12 : En haut à droite
        // 8 : En bas à droite
        // -12 : En bas à gauche
        // -8 : En haut à gauche

        return false;
    }
}
