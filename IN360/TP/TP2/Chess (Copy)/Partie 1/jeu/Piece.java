package jeu;

public abstract class Piece {
	/*
	Pièce de l'échequier
	Attributs :
	- private couleur 
	*/
	protected String couleur;
	protected int UNICODE;
	

	Piece(String couleur){
		if(!couleur.equals("WHITE") && !couleur.equals("BLACK")){
			System.err.println("Mauvaise couleure, l'objet n'a pas été créé : " + couleur);
		}
		else{
			this.couleur = couleur;
		}

	}

	public String getCouleur(){
		return couleur;
	}

	public int getUNICODE() {
		return UNICODE;
	}

	/*
	 * Indique si la pièce est bougeable
	 * @param int positionD : position de départ
	 * @param int positionF : position d'arrivée
	 * @return false si ce n'est pas possible et true si la pièce peut être bougée
	*/
	public abstract boolean bouger(int positionD, int positionF);


	/*
	 * Indique si la pièce peut prendre suivant son déplacement
	 * @param int positionD : position de départ
	 * @param int positionF : position d'arrivée
	 * @return boolean : true si la pièce peut prendre false si non
	*/
	public boolean prend(int positionD, int positionF){
		return bouger(positionD, positionF);
	}

	/*
	 * Vérifie qu'il n'y a pas de pièces entre la position de départ et d'arrivée si le mouvement est possible
	 * @param Piece[][] plateau : plateau d'echecs
	 * @param int positionD : Position de départ
	 * @param int positionF : Position finale
	 * @return boolean : true si il y a une pièce entre le départ et l'arrivée et false sinon.
	*/
	public abstract boolean pieces_entre(Plateau plateau, int positionD, int positionF);

}
