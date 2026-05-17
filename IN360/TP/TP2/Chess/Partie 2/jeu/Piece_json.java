package jeu;

/*
    * Piece_json :
    * Description d'une pièce dans le fichier Json
    * Cette classe hérite de Piece
    * 
    * Attributs :
    * private String nom;
    * private String case_depart;
    * private int[] mouvements;
    * 
    * Getters :
    * public String getNom();
    * public String getCase_depart();
    * public int[] getMouvements();
    * 
    * 
    * 
*/
public class Piece_json extends Piece{
    private String nom;
    private String case_depart;
    private int[] mouvements;

    public Piece_json(String nom, int UNICODE, String couleur, String case_depart, int[] mouvements) {
        super(couleur);
        this.nom = nom;
        this.UNICODE = UNICODE;

        this.case_depart = case_depart;

        if (!Plateau.index_inTab(Plateau.stringToIndex(case_depart))) { // On vérifie que la case de départ est valide
            System.err.println("L'index n'est pas sur le plateau");
        }

        this.mouvements = mouvements;

    }

    public String getNom(){
        return nom;
    }

    public String getCase_depart() {
        return case_depart;
    }

    public int[] getMouvements() {
        return mouvements;
    }

    @Override
    public boolean bouger(int positionD, int positionF){
        for (int deplacement : mouvements) { // On vérifie dans le tableau des mouvements possibles si le mouvement est bien possible
            if (deplacement == (positionF-positionD)) {
                return true;
            }
        }
        return false;
    }

    /* 
     * On considère que les pièces dans le fichier Json
     * peuvent "sauter" au dessus des autres pièces
     * (À la manière du cavalier)
     * 
     */
    @Override
    public boolean pieces_entre(Plateau plateau, int positionD, int positionF){
        return !bouger(positionD, positionF);
    }

    

}