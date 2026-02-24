package partie2;

import java.util.ArrayList;
import java.util.Scanner;

public class Ex4 {
	public static void main(String[] args) {
		ArrayList<Float> notes= new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Saisissez la note (-1 pour finir) : ");
		float scan = sc.nextFloat();
		
		while(scan != -1) {
			notes.add(scan);
			System.out.println("Saisissez la note (-1 pour finir) : ");
			scan = sc.nextFloat();
		}

		// Tri a bulle
		int k = 0;
		boolean exchange = true;
		float tmp = 0f;
		while(exchange) {
			k = 0;
			exchange = false;
			while(k < notes.size()-1) {
				if(notes.get(k) > notes.get(k+1)) {
					tmp = notes.get(k);
					notes.set(k, notes.get(k+1));
					notes.set(k+1, tmp);
					exchange = true;
				}
				
				k++;
			}
		}
				
		// Affichage des notes : 
		
		System.out.println("La note mini est de : " + notes.get(0));
		System.out.println("La note maxi est de : " + notes.get(k));
		
		k = 0;
		while(k <notes.size()) {
			System.out.println("Note numéro " + k + " : " + notes.get(k));
			k++;
		}
		
	}
}
