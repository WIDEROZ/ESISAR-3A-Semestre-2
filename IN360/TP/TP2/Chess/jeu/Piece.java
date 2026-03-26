package jeu;

public abstract class Piece {
	/*
	Pièce de l'échequier
	Attributs :
	- private couleur 
	*/
	protected String couleur;
	
	Piece(String couleur){
		if(couleur != "WHITE" && couleur != "BLACK"){
			System.out.println("Mauvaise couleure, l'objet n'a pas été créé");
		}
		else{
			this.couleur = couleur;
		}
	}

	public String getCouleur(){
		return couleur;
	}

	public abstract boolean bouger(String positionD, String positionF);
	/*
		Entrer la position de départ et la case d'arrivée pour faire bouger la pièce
		Retourne false si ce n'est pas possible et true si la pièce à été bougée
	*/
	



}
