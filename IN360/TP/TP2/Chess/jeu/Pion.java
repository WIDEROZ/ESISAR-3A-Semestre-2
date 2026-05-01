package jeu;

public class Pion extends Piece{
	
	Pion(String couleur){
		super(couleur);
	}

	@Override
	public boolean bouger(int positionD, int positionF){
		if (couleur == "BLACK"){
			if(positionF - positionD == 1 || positionF-positionD == 9 || positionF-positionD == 11){
				return true;
			}
			// positionF-positionD : Déplacement dans le sens relatif au pion :
			// 1 : Droit
			// 9 : Diagonale gauche
			// 11 : Diagonale droite
		}
		else if(couleur == "WHITE"){
			if(positionD - positionF == 1 || positionD-positionF == 9 || positionD-positionF == 11){
				return true;
			}
			// positionF-positionF : Déplacement dans le sens relatif au pion :
			// 1 : Droit
			// 9 : Diagonale gauche
			// 11 : Diagonale droite
		}
		return false;
	}

}
