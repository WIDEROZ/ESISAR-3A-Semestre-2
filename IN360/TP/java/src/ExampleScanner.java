package src;

import java.util.Scanner;

public class ExampleScanner 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Bonjour JAVA.");
        System.out.println("Merci de saisir un nombre");
        int nb1 = sc.nextInt();

        System.out.println("Vous avez saisi le nombre "+nb1);

        System.out.println("Merci de saisir un texte :");
        String str = sc.next();

        System.out.println("Vous avez saisi le texte "+str);

        System.out.println("Au revoir JAVA.");
    }
}
