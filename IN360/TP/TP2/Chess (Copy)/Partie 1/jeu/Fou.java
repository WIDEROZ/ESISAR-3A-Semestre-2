package jeu;

public class Fou extends Piece{
    Fou(String couleur){
		super(couleur);
        if (couleur.equals("WHITE")) {
			UNICODE = 0x2657;
		}
		else{
			UNICODE = 0x265D;
		}
	}


    @Override
	public boolean bouger(int positionD, int positionF){
        int colone_D = positionD/10;
		int colone_F = positionF/10;
		int linge_D = positionD - colone_D*10;
		int linge_F = positionF - colone_F*10;

        int colonne = colone_F-colone_D;
        int ligne = linge_F-linge_D;
        
        if(Math.abs(colonne) == Math.abs(ligne) && ligne != 0){ // Diagonale
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

            if (colonne > 0) {
                if (ligne > 0) {
                    // Déplacement vers haut à droite
                    deplacement = 11;
                }
                else{
                    // Déplacement vers bas à droite
                    deplacement = 9;
                }
            }
            else{
                if (ligne > 0) {
                    // Déplacement vers haut à gauche
                    deplacement = -9;
                }
                else{
                    // Déplacement vers bas à gauche
                    deplacement = -11;
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
