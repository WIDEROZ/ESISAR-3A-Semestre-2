package jeu;

public class Chess {
	
	public static void main(String[] args) {
		new Chess().execute();
	}

	static public final int ROOK_WHITE = 0x2656; 
	static public final int ROOK_BLACK = 0x265C;
	
	static public final int KNIGHT_WHITE = 0x2658;
	static public final int KNIGHT_BLACK = 0x265E;
	
	static public final int BISHOP_WHITE = 0x2657;
	static public final int BISHOP_BLACK = 0x265D;
	
	static public final int PAWN_WHITE = 0x2659;
	static public final int PAWN_BLACK = 0x265F;
	
	static public final int QUEEN_WHITE = 0x2655;
	static public final int QUEEN_BLACK = 0x265B;
	
	static public final int KING_WHITE = 0x2656;
	static public final int KING_BLACK = 0x265A;
	
	private void execute() 
	{
		// 
		System.out.println("8|"+show(ROOK_BLACK)+"|"+show(KNIGHT_BLACK)+"|"+show(BISHOP_BLACK)+"|"+show(QUEEN_BLACK)+"|"+show(KING_BLACK)+"|"+show(BISHOP_BLACK)+"|"+show(KNIGHT_BLACK)+"|"+show(ROOK_BLACK)+"|");
		System.out.println("7|"+show(PAWN_BLACK)+"|"+show(PAWN_BLACK)+"|"+show(PAWN_BLACK)+"|"+show(PAWN_BLACK)+"|"+show(PAWN_BLACK)+"|"+show(PAWN_BLACK)+"|"+show(PAWN_BLACK)+"|"+show(PAWN_BLACK)+"|");
		System.out.println("6|"+empty()+"|"+empty()+"|"+empty()+"|"+empty()+"|"+empty()+"|"+empty()+"|"+empty()+"|"+empty()+"|");
		System.out.println("5|"+empty()+"|"+empty()+"|"+empty()+"|"+empty()+"|"+empty()+"|"+empty()+"|"+empty()+"|"+empty()+"|");
		System.out.println("4|"+empty()+"|"+empty()+"|"+empty()+"|"+empty()+"|"+empty()+"|"+empty()+"|"+empty()+"|"+empty()+"|");
		System.out.println("3|"+empty()+"|"+empty()+"|"+empty()+"|"+empty()+"|"+empty()+"|"+empty()+"|"+empty()+"|"+empty()+"|");
		System.out.println("2|"+show(12)+"|"+show(22)+"|"+show(32)+"|"+show(42)+"|"+show(52)+"|"+show(62)+"|"+show(72)+"|"+show(82)+"|");
		System.out.println("1|"+show(11)+"|"+show(21)+"|"+show(31)+"|"+show(41)+"|"+show(51)+"|"+show(61)+"|"+show(71)+"|"+show(81)+"|");
		System.out.println("  A B C D E F G H");
		
	}


	private void execute(Plateau plateau){
		int c=8;
		int l=1;
		while (l <= 8) {
			while (c >= 1){
				if (plateau.isTherePiece(c * 10 + l)){
					System.out.print( + '|');
				}
				c--;
			}
		System.out.println(8-c + '|');
		l++;
		}
		System.out.println("  A B C D E F G H");
	}
	
	
	private String empty() 
	{
		return " ";
	}


	private String show(int piece, int index)
	{
		return new String(Character.toChars(KING_BLACK));
	}

}
