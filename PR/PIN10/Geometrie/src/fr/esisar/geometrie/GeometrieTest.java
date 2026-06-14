package fr.esisar.geometrie;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class GeometrieTest {
    /**
     * ###### 1.
     * Ce chiffre correspond à l'adresse en mémoire de l'objet (elle ne change pas)

     * ###### 2.
     * Il n'initialise pas les attributs
     * super est ici si jamais il existe une class parente
    **/
    public static void main(String[] args) {

        /*
        double rapport_diametre_epaisseur_anneaux = 12;
        double epaisseur = 10;
        double diametre = rapport_diametre_epaisseur_anneaux * epaisseur;
        double rayon = diametre/2;

        // Création points : 
        Point A = new Point("A", rayon + 2*epaisseur, rayon + 2*epaisseur);
        Point B = new Point("B", diametre + rayon + 5*epaisseur, rayon + 2*epaisseur);
        Point C = new Point("C", 2*diametre + rayon + 8*epaisseur, rayon + 2*epaisseur);

        Point D = new Point("D", diametre + epaisseur*3.5, diametre + 2.5*epaisseur);
        Point E = new Point("E", 2*diametre + epaisseur*6.5, diametre + 2.5*epaisseur);




        // Création des cercles :
        
        Cercle cercle_bleu = new Cercle(diametre/2, A, "blue");
        Cercle cercle_noir = new Cercle(diametre/2, B, "black");
        Cercle cercle_rouge = new Cercle(diametre/2, C, "red");

        Cercle cercle_jaune = new Cercle(diametre/2, D, "yellow");
        Cercle cercle_vert = new Cercle(diametre/2, E, "green");
        

        try {
            // Création d'un fileWriter pour écrire dans un fichier
            FileWriter fileWriter = new FileWriter("anneaux.svg", false);

            // Création d'un bufferedWriter qui utilise le fileWriter
            BufferedWriter writer = new BufferedWriter(fileWriter);

            // Ajout du texte

            writer.write("<svg viewBox='0 0 500 250' style='background: white' version='1.1' xmlns='http://www.w3.org/2000/svg'>");
            writer.newLine();
            writer.write(cercle_bleu.svg(epaisseur));
            writer.newLine();
            writer.write(cercle_noir.svg(epaisseur));
            writer.newLine();
            writer.write(cercle_rouge.svg(epaisseur));
            writer.newLine();
            writer.write(cercle_jaune.svg(epaisseur));
            writer.newLine();
            writer.write(cercle_vert.svg(epaisseur));
            writer.newLine();

            writer.write("</svg>");


            writer.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        
        */



    }
}
