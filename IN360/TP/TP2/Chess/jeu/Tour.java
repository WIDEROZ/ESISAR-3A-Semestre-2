package jeu;

public class Tour extends Piece{
    Tour(String couleur){
		super(couleur);
	}

    @Override
	public boolean bouger(int positionD, int positionF){
        int colonne = Math.abs((positionF - positionD))/10;
        int ligne = Math.abs(positionF - positionD)-colonne;

        if(ligne <= 7 && ligne >= 1 && colonne == 0){
            // Mouvements sur la colonne
            return true;
        }
        else if(colonne <= 7 && colonne >= 1 && ligne == 0){
            // Mouvements sur la ligne
            return true;
        }
        
        return false;
    }
}
