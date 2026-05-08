package jeu;

public abstract class Piece {
	/*
	 * Pièce de l'échequier
	 * Attributs :
	 * - protected String couleur
	 * - protected int UNICODE
	 * 
	 * Getters : 
	 * - public String getCouleur();
	 * - public String getUNICODE();
	 * 
	 * Méthodes :
	 * - public abstract boolean bouger(int positionD, int positionF);
	 * - public boolean prend(int positionD, int positionF)
	 * - public abstract boolean pieces_entre(Plateau plateau, int positionD, int positionF);
	 * 
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
	 * Indique dans quel cas se situe la pièce lors d'une tentative de mouvement :
	 * - Si avec le mouvement donné la pièce à le droit d'en prendre une autre alors la méthode renvoie : true
	 * - Dans l'autre cas elle renvoie : false
	 * (Méthode pensée pour le pion)
	 * 
	 * @param int positionD : position de départ
	 * @param int positionF : position d'arrivée
	 * @return boolean : true si la pièce peut prendre false si non
	*/
	public boolean prend(int positionD, int positionF){
		return bouger(positionD, positionF);
	}


	/*
	 * Vérifie qu'il n'y a pas de pièces entre la position de départ et d'arrivée si le mouvement est possible.
	 *
	 * Fonctionnement :
	 * On déplace la pièce case par case pour arriver une case avant la position finale
	 * et si l'on tombe sur une pièce pendant le trajet alors la méthode renvoie vrai.
	 *
	 * @param Piece[][] plateau : plateau d'echecs
	 * @param int positionD : Position de départ
	 * @param int positionF : Position finale
	 * @return boolean : true si il y a une pièce entre le départ et l'arrivée et false sinon.
	*/
	public abstract boolean pieces_entre(Plateau plateau, int positionD, int positionF);

}
