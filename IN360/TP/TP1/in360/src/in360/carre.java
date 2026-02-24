package in360;

import java.util.Scanner;

public class carre {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("donnez un nombre positif :");
		double nb = sc.nextInt();
		
		while(nb != 0) {
			if(nb < 0) {
				System.out.println("svp positif");
			}
			else {
				System.out.println("La racine de " + nb + "est : " + Math.sqrt(nb) );
			}
			System.out.println("donnez un nombre positif :");
			nb = sc.nextInt();
		}
		
		System.out.println("Au revoir");
		
	}
}
