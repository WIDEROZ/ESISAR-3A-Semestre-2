package jeu;

public class Reine extends Piece{
    Reine(String couleur){
		super(couleur);
	}

	@Override
	public boolean bouger(int positionD, int positionF){
		int colonne = Math.abs((positionF - positionD))/10;
        int ligne = Math.abs(positionF - positionD)-colonne;


		if((ligne <= 7 && ligne >= 1 && colonne == 0)
			 || (colonne <= 7 && colonne >= 1 && ligne == 0)){
			// Mouvements droits
			return true;
		}
		else if(ligne == colonne && ligne != 0){
			// Mouvements diagonaux
			return true;
		}
		else{
			return false;
		}
	}
}
