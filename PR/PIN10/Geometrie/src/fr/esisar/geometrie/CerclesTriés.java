package fr.esisar.geometrie;

import java.util.ArrayList;

public class CerclesTriés {

    private static void tri(ArrayList<CercleComparable> list_cercle){
        int index_min;
        CercleComparable cercle;
        CercleComparable cercle_min;

        for (int i = 0; i < list_cercle.size(); i++) {
            index_min = i+1;
            for (int j = i+1; j < list_cercle.size(); j++) {
                cercle = list_cercle.get(j);
                cercle_min = list_cercle.get(index_min);
                if (cercle_min.compareTo(cercle) > 0){
                    index_min = j;
                }
            }
            cercle = list_cercle.get(i);
            cercle_min = list_cercle.get(index_min);

            if (cercle.compareTo(cercle_min) > 0) {
                list_cercle.add(i, cercle_min);
                list_cercle.add(index_min, cercle);
            }
        }
    }

    public static void main(String[] args) {
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
        
        CercleComparable cercle_bleu = new CercleComparable(rayon, A, "blue");
        CercleComparable cercle_noir = new CercleComparable(rayon, B, "black");
        CercleComparable cercle_rouge = new CercleComparable(rayon, C, "red");

        CercleComparable cercle_jaune = new CercleComparable(rayon, D, "yellow");
        CercleComparable cercle_vert = new CercleComparable(rayon, E, "green");

        // Liste de cercles
        ArrayList<CercleComparable> list_cercle = new ArrayList<CercleComparable>();


        list_cercle.add(cercle_bleu);
        list_cercle.add(cercle_noir);
        list_cercle.add(cercle_rouge);
        list_cercle.add(cercle_jaune);
        list_cercle.add(cercle_vert);


        tri(list_cercle);

            


        
    }
}
