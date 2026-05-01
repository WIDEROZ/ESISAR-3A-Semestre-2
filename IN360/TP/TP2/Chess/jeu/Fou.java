package jeu;

public class Fou extends Piece{
    Fou(String couleur){
		super(couleur);
	}


    @Override
	public boolean bouger(int positionD, int positionF){
        int colonne = Math.abs((positionF - positionD))/10;
        int ligne = Math.abs(positionF - positionD)-colonne;
        
        // Déplacement en valeur absolue car les movements sont symétriques
        
        if(ligne == colonne && ligne != 0){ // ligne == colonne : même nombre de cases en mouvement
            return true;
        }
        else{
            return false;
        }
    }
}
