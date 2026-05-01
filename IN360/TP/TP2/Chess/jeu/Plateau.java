package jeu;

public class Plateau {
	/*
	 * Classe Plateau :
	 * Représente le plateau de jeu par une liste
	 *
	 * On encode les cases de cette manière :
	 * - Lignes : chiffres des unités
	 * - Colonnes : Chiffre des dixaines
	 *  */
	public Piece[][] plateau = new Piece[8][8];
	public Chess plateau_graphique = new Chess();
	
	public Plateau() {
		
	}
	
	private boolean inTab(int index){
		/*
		 * Vérifie si l'indice donné en paramètre est bien dans le tableau
		 * Renvoie un booleans
		 * */
		int unites = index-((index/10)*10);
		if(11 <= index && index <= 88 && unites !=9 && unites != 0){
			return true;
		}
		else {
			return false;
		}
	}
	
	public void getCase(int index) {
		/*
		 * Print la case réelle suivant celle donné en entrée par l'index
		 * */
		int ligne  = index-((index/10)*10);
		int colone = index/10;
		char coloneLettre = (char)(colone + 64);
		if(inTab(index)) {
			System.out.println("La pièce est à la case : (" + coloneLettre + "," + ligne + ")");
		}
		else {
			System.out.println("L'index n'est pas dans le tableau");
		}
	}

	public Piece getPiece(int index){
		/* 
			Obtenir la piece à l'index donné en paramètre
		*/
		int ligne  = index-((index/10)*10)-1;
		int colone = index/10-1;
		return plateau[ligne][colone];
	}

	private int stringToIndex(String index){
		/*
			Convertit un string en un index encodé
			Renvoie l'index si l'opération est un succès et -1 sinon
		*/
		if (index.length() == 2){
			int dixaines = index.charAt(0) - 64;
			int unités = index.charAt(1) - 48;
			return dixaines*10 + unités;
		}
		else{
			return -1;
		}
		
	}

	
	
	public boolean isTherePiece(int index) {
		/*
		 * Vérifie si une pièce est sur la case du plateau par rapport à l'index donné
		 * Renvoie un boolean
		 * */
		int ligne  = index-((index/10)*10)-1;
		int colone = index/10-1;
		if(plateau[ligne][colone] != null) {
			return true;
		}
		return false;
	}

	public void add(Piece piece, String position){
		int index = stringToIndex(position);
		int ligne  = index-((index/10)*10)-1;
		int colone = index/10-1;

		if(!inTab(index)){
			System.out.println("Problème d'index la case n'est pas dans le tableau" + index);
		}
		else if(!isTherePiece(index)){
			plateau[ligne][colone] = piece;
		}
		else{
			System.out.println("Il y a déjà une pièce sur cette case impossible d'en placer une");
		}
	}

	public void initTableau(){
		add(new Pion("BLACK"), "A2");
		add(new Pion("BLACK"), "B2");
		add(new Pion("BLACK"), "C2");
		add(new Pion("BLACK"), "D2");
		add(new Pion("BLACK"), "E2");
		add(new Pion("BLACK"), "F2");
		add(new Pion("BLACK"), "G2");
		add(new Pion("BLACK"), "H2");

		add(new Tour("BLACK"), "A1");
		add(new Cavalier("BLACK"), "B1");
		add(new Fou("BLACK"), "C1");
		add(new Reine("BLACK"), "D1");
		add(new Roi("BLACK"), "E1");
		add(new Fou("BLACK"), "F1");
		add(new Cavalier("BLACK"), "G1");
		add(new Tour("BLACK"), "H1");



		add(new Tour("WHITE"), "A8");
		add(new Cavalier("WHITE"), "B8");
		add(new Fou("WHITE"), "C8");
		add(new Reine("WHITE"), "D8");
		add(new Roi("WHITE"), "E8");
		add(new Fou("WHITE"), "F8");
		add(new Cavalier("WHITE"), "G8");
		add(new Tour("WHITE"), "H8");

		add(new Pion("WHITE"), "A7");
		add(new Pion("WHITE"), "B7");
		add(new Pion("WHITE"), "C7");
		add(new Pion("WHITE"), "D7");
		add(new Pion("WHITE"), "E7");
		add(new Pion("WHITE"), "F7");
		add(new Pion("WHITE"), "G7");
		add(new Pion("WHITE"), "H7");



	}
	
	public void afficherTableau(){
		plateau_graphique.execute(this);
	}

	public static void main(String[] args) {
		Plateau Board = new Plateau();
		
		Board.initTableau();
		Board.afficherTableau();


		System.out.println();
		
	}
}