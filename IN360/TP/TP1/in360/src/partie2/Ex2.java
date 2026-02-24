package partie2;

import java.util.Scanner;

public class Ex2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Nombre de notes : ");
		int n = sc.nextInt();
		System.out.println();
		
		float[] notes;
		notes = new float[n];
		float[] coefs;
		coefs = new float[n];
		
		int k = 0;
		while(k < n) {
			System.out.print("Entrez la note numéro : " + k);
			notes[k] = sc.nextFloat();
			System.out.println();
			k++;
		}
		
		
		// Tri a bulle
		
		boolean exchange = true;
		float tmp = 0f;
		while(exchange) {
			k = 0;
			while(k < n-1) {
				if(notes[k] > notes[k+1]) {
					tmp = notes[k];
				}
				
				k++;
			}
		}
		
	}
}
