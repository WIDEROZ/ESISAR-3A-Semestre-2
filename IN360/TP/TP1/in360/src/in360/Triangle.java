package in360;

import java.util.Scanner;


public class Triangle {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nombre de lignes : ");
		int n = sc.nextInt();
		int k = n;
		int star_num = 1;
		char space = ' ';
		char star = '*';
		
		
		while(n > 0) {
			k = n-1;
			while(k > 0) {
				System.out.print(space);
				k--;
			}
			k = star_num;
			while(k != 0) {
				System.out.print(star);
				k--;
			}
			
			System.out.println();
			star_num += 2;
			n--;
		}
		
	}
}