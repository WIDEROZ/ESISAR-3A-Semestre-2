package partie2;

import java.util.ArrayList;
import java.util.Scanner;

public class Ex3 {
	public static void main(String[] args) {
		ArrayList<Float> notes= new ArrayList<>();
		ArrayList<Float> coefs= new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Saisissez la note (-1 pour finir) : ");
		float scan = sc.nextFloat();
		
		while(scan != -1) {
			notes.add(scan);
			System.out.println("Saisissez la note (-1 pour finir) : ");
			scan = sc.nextFloat();
		}
		System.out.println("Saisissez le coeff (-1 pour finir) : ");
		scan = sc.nextFloat();
		while(scan != -1) {
			coefs.add(scan);
			System.out.println("Saisissez le coeff (-1 pour finir) : ");
			scan = sc.nextFloat();
		}
		
		int k = 0;
		float moyenne = 0;
		float sumcoefs = 0;
		while(k < notes.size()) {
			moyenne += notes.get(k) * coefs.get(k);
			sumcoefs += coefs.get(k);
			k++;
		}
		moyenne /= sumcoefs;
		System.out.println("Moyenne : " + moyenne);
	}
}
