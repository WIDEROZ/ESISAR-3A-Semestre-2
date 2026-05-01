package jeu;

public class Chess {
	
	public static void main(String[] args) {
		//new Chess().execute(plateau);
	}

	static public final int Tour_WHITE = 0x2656; 
	static public final int Tour_BLACK = 0x265C;
	
	static public final int Chevalier_WHITE = 0x2658;
	static public final int Chevalier_BLACK = 0x265E;
	
	static public final int Fou_WHITE = 0x2657;
	static public final int Fou_BLACK = 0x265D;
	
	static public final int Pion_WHITE = 0x2659;
	static public final int Pion_BLACK = 0x265F;
	
	static public final int Reine_WHITE = 0x2655;
	static public final int Reine_BLACK = 0x265B;
	
	static public final int Roi_WHITE = 0x2654;
	static public final int Roi_BLACK = 0x265A;


	public Chess(){

	}


	public void execute(Plateau board){
		int c=1;
		int l=8;
		while (l >= 1) {
			System.out.print(l + " |");
			while (c <= 8){
				if (board.isTherePiece(c * 10 + l)){
					//System.out.println("AAAAAAAAAAAAAA : " + (int)(c * 10 + l) + ".");
					//System.out.println(new String(board.plateau[l-1][c-1].getClass().getName()));
					System.out.print(new String(board.plateau[l-1][c-1].getCouleur()));
					
					String piece = show(new String(board.plateau[l-1][c-1].getClass().getName()), new String(board.plateau[l-1][c-1].getCouleur()));
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




	private String show(String nom, String couleur){
		int piece;

		
		if (couleur.equals("BLACK")) {
			if (nom.equals("jeu.Tour")) {
				piece = Tour_BLACK;
			}
			else if (nom.equals("jeu.Cavalier")) {
				piece = Chevalier_BLACK;
			}
			else if (nom.equals("jeu.Fou")) {
				piece = Fou_BLACK;
			}
			else if (nom.equals("jeu.Reine")) {
				piece = Reine_BLACK;
			}
			else if (nom.equals("jeu.Roi")) {
				piece = Roi_BLACK;
			}
			else if (nom.equals("jeu.Pion")) {
				piece = Pion_BLACK;
			}
			else {
				System.out.println("Mauvais nom de pièce");
				return "Error";
			}
		}
		else if (couleur.equals("WHITE")) {
			if (nom.equals("jeu.Tour")) {
				piece = Tour_WHITE;
			}
			else if (nom.equals("jeu.Cavalier")) {
				piece = Chevalier_WHITE;
			}
			else if (nom.equals("jeu.Fou")) {
				piece = Fou_WHITE;
			}
			else if (nom.equals("jeu.Reine")) {
				piece = Reine_WHITE;
			}
			else if (nom.equals("jeu.Roi")) {
				piece = Roi_WHITE;
			}
			else if (nom.equals("jeu.Pion")) {
				piece = Pion_WHITE;
			}
			else {
				System.out.println("Mauvais nom de pièce");
				return "Error";
			}
		}
		else{
			System.out.println("Mauvaise couleure de pièce pour show chess");
			return "Error";
		}
		return new String(Character.toChars(piece));
	}

}
