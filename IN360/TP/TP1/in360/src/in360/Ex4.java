package in360;

import java.util.Scanner;

public class Ex4 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Choisissez un nombre : ");
		int n = sc.nextInt();
		float nb = 0f;
		
		while(n > 0) {
			nb += 1/((float)(n)*n);
			n--;
		}
		System.out.println("Résultat final : " + nb);
	}
}
