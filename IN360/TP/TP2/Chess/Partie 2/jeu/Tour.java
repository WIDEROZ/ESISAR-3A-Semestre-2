package jeu;

public class Tour extends Piece{
    Tour(String couleur){
		super(couleur);
		if (couleur.equals("WHITE")) {
			UNICODE = 0x2656;
		}
		else{
			UNICODE = 0x265C;
		}
	}

    @Override
	public boolean bouger(int positionD, int positionF){
        int colonne = Math.abs((positionF - positionD))/10;
        int ligne = Math.abs(positionF - positionD)-colonne*10;

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

    @Override
    public boolean pieces_entre(Plateau plateau, int positionD, int positionF){
        if (bouger(positionD, positionF)) {
            int colonne = (positionF - positionD)/10;
            int ligne = (positionF - positionD) - colonne*10;
            int deplacement;

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