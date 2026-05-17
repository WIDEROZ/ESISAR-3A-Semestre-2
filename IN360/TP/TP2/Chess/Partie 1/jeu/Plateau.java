package jeu;

import java.util.Scanner;

/*
	* Plateau :
	* Représente le plateau de jeu par une liste
	*
	* On encode les cases de cette manière :
	* - Lignes : chiffres des unités
	* - Colonnes : Chiffre des dixaines
	* 
	* On appellera cet entier index dans toute la classe
	* 
	* Exemple : L'index 68 correspond à la case F8
	* 
	* Attribut : 
	* - private Piece[][] plateau;
	* 
	* Méthodes :
	* - public static boolean index_inTab(int index);
	* - public static void getCase(int index);
	* - public Piece getPiece(int index);
	* - public static int stringToIndex(String Case);
	* - public boolean isTherePiece(int index);
	* - private void add(Piece piece, String position);
	* - private void bougerPieceSurPlateau(int index_D, int index_A);
	* - private void initTableau();
	* - private void afficherPlateau();
	* - private int getIndex_D(Scanner scanner, boolean tour_des_blancs);
	* - private int getIndex_A(Scanner scanner, boolean tour_des_blancs, int index_D);
	* - private void GM();
*/
public class Plateau {
	private Piece[][] plateau = new Piece[8][8];
	
	public Plateau() {
		
	}
	

	/*
	 * Vérifie si l'indice donné en paramètre est bien dans le tableau
	 * (index entre 11 et 88 )
	 * @param int index
	 * @return boolean
	 * */
	public static boolean index_inTab(int index){
		
		int unites = index-((index/10)*10);
		if(11 <= index && index <= 88 && unites !=9 && unites != 0){
			return true;
		}
		else {
			System.err.println("Index FAUX : L'index n'est pas dans le tableau");
			return false;
		}
	}
	
	/*
	 * Print la case réelle suivant celle donné en entrée par l'index
	 * @param int index
	 * 
	 * Exemple : 
	 * index = 53
	 * print : E3
	 * 
	 * index = 102
	 * print : L'index n'est pas dans le tableau
	 * */
	public static void getCase(int index) {
		int ligne  = index-((index/10)*10);
		int colone = index/10;
		char coloneLettre = (char)(colone + 64);
		if(index_inTab(index)) {
			System.out.println("La pièce est à la case : " + coloneLettre + ligne);
		}
		else {
			System.out.println("L'index n'est pas dans le tableau");
		}
	}

	/*
	 * Renvoie l'objet Piece à l'index donné en entrée
	 * @param int index
	 * @return Piece
	 * */
	public Piece getPiece(int index){
		int ligne  = index-((index/10)*10)-1;
		int colone = index/10-1;
		return plateau[ligne][colone];
	}

	/*
	 * Convertit une case de l'echequier string en un index entier
	 * @param String Case
	 * @return int Renvoie l'index si l'opération est un succès et -1 sinon
	* */
	public static int stringToIndex(String Case){
		if (Case.length() == 2){
			int dixaines = Case.charAt(0) - 64;
			int unités = Case.charAt(1) - 48;
			return dixaines*10 + unités;
		}
		else{
			System.err.println("Index FAUX : Trop de caractères");
			return -1;
		}
		
	}

	/*
	 * Vérifie si il existe une pièce sur la case du plateau par rapport à l'index donné
	 * @param int index
	 * @return boolean
	 * */
	public boolean isTherePiece(int index) {
		if (index_inTab(index)) {
			int ligne  = index-((index/10)*10)-1;
			int colone = index/10-1;
			if(plateau[ligne][colone] != null) {
				return true;
			}
		}
		return false;

	}

	/*
	 * Ajoute une pièce dans le plateau
	 * @param Piece piece : Pièce que l'on souhaite mettre dans le tableau
	 * @param String position : Position (case) à laquelle on souhaite mettre la pièce
	 * 
	 * Print un message d'erreur si la case n'est pas dans le tableau
	 * Print un message d'erreur si il y a une pièce sur la case
	 * */
	private void add(Piece piece, String position){
		int index = stringToIndex(position);
		int ligne  = index-((index/10)*10)-1;
		int colone = index/10-1;

		if(!index_inTab(index)){
			System.err.println("Problème d'index la case n'est pas dans le tableau" + index);
		}
		else{
			plateau[ligne][colone] = piece;
		}
	}

	/*
	 * Permet de bouger des pièces sur l'échequier 
	 * ATTENTION : Ecrase la pièce à l'arivée
	 * @param int index_D : index de départ
	 * @param int index_A : index d'arrivée
	 */
	private void bougerPieceSurPlateau(int index_D, int index_A){
		int ligne_D  = index_D-((index_D/10)*10)-1;
		int colone_D = index_D/10-1;

		int ligne_A  = index_A-((index_A/10)*10)-1;
		int colone_A = index_A/10-1;

		if (index_inTab(index_A) && index_inTab(index_D)){
			plateau[ligne_A][colone_A] = plateau[ligne_D][colone_D];
			plateau[ligne_D][colone_D] = null;
		}
		else{
			System.err.println("Les index ne sont pas dans les plateaux");
		}
	}

	/*
	 * Initialise la position initiale du tableau : 
	 * Les pièces blanches en bas
	 * Les pièces noires en haut
	 * */
	private void initTableau(){
		add(new Pion("WHITE"), "A2");
		add(new Pion("WHITE"), "B2");
		add(new Pion("WHITE"), "C2");
		add(new Pion("WHITE"), "D2");
		add(new Pion("WHITE"), "E2");
		add(new Pion("WHITE"), "F2");
		add(new Pion("WHITE"), "G2");
		add(new Pion("WHITE"), "H2");

		add(new Tour("WHITE"), "A1");
		add(new Cavalier("WHITE"), "B1");
		add(new Fou("WHITE"), "C1");
		add(new Reine("WHITE"), "D1");
		add(new Roi("WHITE"), "E1");
		add(new Fou("WHITE"), "F1");
		add(new Cavalier("WHITE"), "G1");
		add(new Tour("WHITE"), "H1");



		add(new Tour("BLACK"), "A8");
		add(new Cavalier("BLACK"), "B8");
		add(new Fou("BLACK"), "C8");
		add(new Reine("BLACK"), "D8");
		add(new Roi("BLACK"), "E8");
		add(new Fou("BLACK"), "F8");
		add(new Cavalier("BLACK"), "G8");
		add(new Tour("BLACK"), "H8");

		add(new Pion("BLACK"), "A7");
		add(new Pion("BLACK"), "B7");
		add(new Pion("BLACK"), "C7");
		add(new Pion("BLACK"), "D7");
		add(new Pion("BLACK"), "E7");
		add(new Pion("BLACK"), "F7");
		add(new Pion("BLACK"), "G7");
		add(new Pion("BLACK"), "H7");

	}

	/*
	 * Affiche dans le terminal le plateau d'Echecs actuel
	 */
	private void afficherPlateau(){
		int c=1;
		int l=8;
		while (l >= 1) {
			System.out.print(l + " |");
			while (c <= 8){
				if (isTherePiece(c * 10 + l)){
					String piece = new String(Character.toChars(plateau[l-1][c-1].getUNICODE()));
					System.out.print(piece + '|');
				}
				else{
					System.out.print(" " + "|");
				}
				c++;
			}
		System.out.println();
		c=1;
		l--;
		}
		System.out.println("   A B C D E F G H");
	}

	/*
	 * Récupération de l'index de départ (demande au joueur) en faisant les vérifications de conversions et de dépassement
	 * @param Scanner scanner : scanner qui servira a demader au joueur l'index de départ
	 * @return int : l'index de départ souhaité
	 */
	private int getIndex_D(Scanner scanner, boolean tour_des_blancs){
		String depart;
		int index_D = 0;
		boolean indexValide = false;
		boolean pieceCouleurBlanche = false;

		while (!indexValide){
			System.out.println("Choisissez la case de départ : ");
			depart = scanner.next();
			index_D = stringToIndex(depart);

			if (index_inTab(index_D)){
				if(isTherePiece(index_D)){
					pieceCouleurBlanche = (getPiece(index_D).getCouleur().equals("WHITE"));
					if (tour_des_blancs ^ !pieceCouleurBlanche) {
						indexValide = true;
					}
					else{
						if (tour_des_blancs){
							System.out.println("C'est le tour des blancs");
						}
						else{
							System.out.println("C'est le tour des noirs");
						}
					}
				}
				else{
					System.out.println("Il n'y a pas de pièces sur cette case");
				}
			}
			else{
				System.out.println("La case n'est pas dans le plateau");
			}
			
		}
		return index_D;
	}

	/*
	 * Récupération de l'index d'arrivée (demande au joueur) en faisant les vérifications de conversions et de dépassement
	 * @param Scanner scanner : scanner qui servira a demader au joueur l'index d'arrivé
	 * @return int : l'index de d'arrivée souhaité
	 */
	private int getIndex_A(Scanner scanner, boolean tour_des_blancs, int index_D){
		String arrivee;
		int index_A = -1;
		boolean indexValide = false;
		boolean pieceCouleurBlanche = false;
		Piece piece;

		while (!indexValide){
			System.out.println("Choisissez la case d'arrivée \n(Entrez Y si vous souhaiter saisir de nouveau la case de départ) : ");
			arrivee = scanner.next();

			if (arrivee.contentEquals("Y")) {
				return -1;
			}


			index_A = stringToIndex(arrivee);

			if (index_inTab(index_A)){
				if (!isTherePiece(index_A)){
					piece = getPiece(index_D);
					if (piece.bouger(index_D, index_A)) {
						if (!piece.pieces_entre(this, index_D, index_A)) {
							return index_A;
						}
						else{
							System.err.println("Il y a une pièce entre le départ et l'arrivée");
						}
					}
					else{
						System.err.println("Mouvement illégal pour cette pièce");
					}
					
				}
				else{
					pieceCouleurBlanche = (getPiece(index_A).getCouleur().equals("WHITE"));
					if (pieceCouleurBlanche ^ tour_des_blancs) {
						piece = getPiece(index_D);
						if (piece.prend(index_D, index_A)) {
							if (!piece.pieces_entre(this, index_D, index_A)){
								return index_A;
							}
							else{
								System.err.println("Il y a une pièce entre le départ et l'arrivée");
							}
						}
						else{
							System.err.println("Mouvement illégal pour cette pièce");
						}
					}
					else{
						System.out.println("Vous ne pouvez pas prendre votre propre pièce");
					}
				}
			}
			else{
				System.out.println("La case n'est pas dans le plateau");
			}
			
		}
		return index_A;
	}

	/*
	 * Game Manager :
	 * Demande au joueur une case de départ et une case d'arrivée
	 * puis si le déplacement est valide pour la pièce qu'il souhaite déplacer alors il la déplace.
	 * 
	 */
	private void GM(){
		boolean is_finished = false;
		boolean tour_des_blancs = true;
		int index_D = 0;
		int index_A = 0;


		Scanner scanner = new Scanner(System.in);

		while (!is_finished) {

			/* Obtention de l'index de départ et d'arrivé avec tous les tests */
			index_D = getIndex_D(scanner, tour_des_blancs);
			index_A = getIndex_A(scanner, tour_des_blancs, index_D);

			
			
			if (index_A == -1) {
				
			}
			// On vérifie que si le joueur prend le roi alors la partie est terminée
			else if(getPiece(index_A) != null){
				if (getPiece(index_A).getUNICODE() == 0x2654 || getPiece(index_A).getUNICODE() == 0x265A) {
					is_finished = true;
				}
			}
			// On vérifie que l'utilisateur n'as pas demandé de saisir une nouvelle fois l'index de départ
			else if (index_A != -1) {
				bougerPieceSurPlateau(index_D, index_A);
				afficherPlateau();
				tour_des_blancs = !tour_des_blancs;
			}
			
		}

		if (tour_des_blancs) {
			System.out.println("Les blancs ont gagné!");
		}
		else{
			System.out.println("Les noirs ont gagné!");
		}

		scanner.close();
		
	}

	public static void main(String[] args) {
		Plateau Board = new Plateau();
		
		Board.initTableau();
		Board.afficherPlateau();

		System.out.println();

		Board.GM();
		
	}
}

