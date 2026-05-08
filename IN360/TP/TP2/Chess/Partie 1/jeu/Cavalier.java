package jeu;

public class Cavalier extends Piece{
    Cavalier(String couleur){
		super(couleur);
        if (couleur.equals("WHITE")) {
			UNICODE = 0x2658;
		}
		else{
			UNICODE = 0x265E;
		}
	}


    @Override
	public boolean bouger(int positionD, int positionF){
        int deplacement = Math.abs(positionF-positionD);


        if(deplacement == 12 || deplacement == 21 || deplacement == 8 || deplacement == 19){
            return true;
        }
        return false;
    }

    @Override
    public boolean pieces_entre(Plateau plateau, int positionD, int positionF){
        // Le cavalier peut sauter par dessus les autres pièces donc il n'existe pas de pièces qui peuvent lui bloquer son mouvement
        return false;
    }
}
