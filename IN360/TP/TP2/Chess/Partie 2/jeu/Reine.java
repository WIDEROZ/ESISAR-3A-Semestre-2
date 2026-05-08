package jeu;

public class Reine extends Piece{
    Reine(String couleur){
		super(couleur);
		if (couleur.equals("WHITE")) {
			UNICODE = 0x2655;
		}
		else{
			UNICODE = 0x265B;
		}
	}

	@Override
	public boolean bouger(int positionD, int positionF){
		int colonne = Math.abs(positionF - positionD)/10;
        int ligne = Math.abs(positionF - positionD)-colonne*10;


		if((ligne <= 7 && ligne >= 1 && colonne == 0)
			 || (colonne <= 7 && colonne >= 1 && ligne == 0)){
			// Mouvements droits
			return true;
		}
		if((positionF-positionD) % 11 == 0){ // Diagonale Haut droite - Bas Gauche
            return true;
        }
        else if((positionF-positionD) % 9 == 0){ // Diagonale Bas droite - Haut gauche
            return true;
        }
		else{
			return false;
		}
	}

	@Override
    public boolean pieces_entre(Plateau plateau, int positionD, int positionF){
        if (bouger(positionD, positionF)) {
			int colone_D = positionD/10;
			int colone_F = positionF/10;
			int linge_D = positionD - colone_D*10;
			int linge_F = positionF - colone_F*10;

            int colonne = colone_F-colone_D;
            int ligne = linge_F-linge_D;
            int deplacement;

            if (Math.abs(colonne) == Math.abs(ligne) && ligne != 0) { // Mouvements diagonaux
				if (colonne > 0) {
					if (ligne > 0) {
						deplacement = 11; // Déplacement vers haut à droite
					}
					else{
						deplacement = 9; // Déplacement vers bas à droite
					}
				}
				else{
					if (ligne > 0) {
						deplacement = -9; // Déplacement vers haut à gauche
					}
					else{
						deplacement = -11; // Déplacement vers bas à gauche
					}
				}
			}
			else { // Mouvements droits
				if (ligne == 0) {
					if (colonne > 0){
						deplacement = 10; // On se déplace d'une case à droite
					}
					else{
						deplacement = -10; // On se déplace d'une case à gauche
					}
				}
				else{
					if (ligne > 0) {
						deplacement = 1; // On se déplace d'une case en haut
					}
					else{
						deplacement = -1; // On se déplace d'une case en bas
					}
				}
			}

            positionD += deplacement;
            while (positionD != positionF) {
                if (plateau.isTherePiece(positionD)){
                    return true;
                }
                positionD += deplacement;
            }
            
            
            return false;
        }
        else{
            return true;
        }
    }

}
