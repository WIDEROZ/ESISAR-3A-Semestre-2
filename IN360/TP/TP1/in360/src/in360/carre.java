package in360;

import java.util.Scanner;

public class carre {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("donnez un nombre positif :");
		int nb1 = sc.nextInt();
		
		while(nb1 != 0) {
			if(nb1 < 0) {
				System.out.println("svp positif");
			}
			else {
				System.out.println("La racine de " + nb1 + "est : " + Math.sqrt(nb1) );
			}
			System.out.println("donnez un nombre positif :");
			double nb1 = sc.nextInt();
		}
		
		System.out.println("Au revoir");
		
	}
}
