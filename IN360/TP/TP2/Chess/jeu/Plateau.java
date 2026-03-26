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
	
	Plateau() {
		
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
	
	public void afficherTableau(){
		
	}

	public static void main(String[] args) {
		Plateau Board = new Plateau();
		
		Piece pion = new Pion("WHITE");
		
		System.out.println(pion.couleur);
		
		Board.add(pion, "A2");


		System.out.println();
		
	}
}