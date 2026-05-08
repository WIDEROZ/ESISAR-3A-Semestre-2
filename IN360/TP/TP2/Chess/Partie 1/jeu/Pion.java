package jeu;

public class Pion extends Piece{
	
	Pion(String couleur){
		super(couleur);
		if (couleur.equals("WHITE")) {
			UNICODE = 0x2659;
		}
		else{
			UNICODE = 0x265F;
		}
		
	}

	@Override
	public boolean bouger(int positionD, int positionF){
		int ligne = positionD-(positionD/10)*10;
		if (couleur == "WHITE"){
			if(positionF - positionD == 1){
				return true;
			}
			else if(ligne == 2 && positionF - positionD == 2){
				return true;
			}
			// positionF-positionD : Déplacement dans le sens relatif au pion :
			// 1 : Droit
			// 2 : Droit deux cases si la pièce est À son premier emplacement
		}
		else if(couleur == "BLACK"){
			if(positionD - positionF == 1){
				return true;
			}
			else if(ligne == 7 && positionD - positionF == 2){
				return true;
			}
			// positionD-positionF : Déplacement dans le sens relatif au pion :
			// 1 : Droit
			// 2 : Droit deux cases si la pièce est à son emplacement de départ
		}
		return false;
	}

	
	@Override
	public boolean prend(int positionD, int positionF){
		
		if (couleur == "BLACK") {
			if (positionF-positionD == -9 || positionF-positionD == 11) {
				return true;
			}
			// positionF-positionD : Déplacement dans le sens relatif au pion :
			// -9 : Diagonale gauche
			// 11 : Diagonale droite
		}
		else if(couleur == "WHITE"){
			if (positionD-positionF== -9 || positionD-positionF == 11) {
				return true;
			}
			// positionD-positionF : Déplacement dans le sens relatif au pion :
			// -9 : Diagonale gauche
			// 11 : Diagonale droite
		}
		return false;
		
	}

	@Override
	public boolean pieces_entre(Plateau plateau, int positionD, int positionF){
		if (bouger(positionD, positionF) && (Math.abs(positionF - positionD) == 2)){ // Pour un déplacement de 2
			int colonne = positionD/10;
			int ligne = positionD-colonne*10 + (positionF - positionD)/2; // Case entre le départ et l'arivée
			
			if(plateau.isTherePiece(colonne*10+ligne)){
				return true;
			}
		}
		return false;
	}

}
