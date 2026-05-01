package jeu;

public class Roi extends Piece{
    Roi(String couleur){
		super(couleur);
	}

	@Override
	public boolean bouger(int positionD, int positionF){
		int colonne = Math.abs((positionF - positionD))/10;
        int ligne = Math.abs(positionF - positionD)-colonne;
		
		if(positionF - positionD == 0){
			return false;
		}
		else if(0<= ligne && ligne <= 1 && 0<= colonne && colonne <= 1){
			return true;
		}
		else{
			return false;
		}
	}

    
}
