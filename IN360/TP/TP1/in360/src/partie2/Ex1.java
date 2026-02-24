package partie2;

import java.util.Scanner;

public class Ex1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Nombre de notes : ");
		int n = sc.nextInt();
		System.out.println();
		
		int[] notes;
		notes = new int[n];
		int[] coefs;
		coefs = new int[n];
		
		int moyenne = 0;
		
		int k = 0;
		while(k < n) {
			System.out.print("Entrez la note numéro : " + k);
			notes[k] = sc.nextInt();
			System.out.println();
			k--;
		}
		k = 0;
		while(k < n) {
			System.out.print("Entrez le coef numéro : " + k);
			coefs[k] = sc.nextInt();
			System.out.println();
			k--;
		}
		k = 0;
		while(k < n) {
			moyenne+= notes[k]*coefs[k];
		}
		
	}
}
