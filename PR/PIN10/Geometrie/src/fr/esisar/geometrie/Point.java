package fr.esisar.geometrie;

public class Point {
    private String nom;
    private double abscisse;
    private double ordonnee;
    
    public Point(String nom, double abscisse, double ordonnee) {
        this.nom = nom;
        this.abscisse = abscisse;
        this.ordonnee = ordonnee;
    }
    
    public String getNom() {
        return nom;
    }
    
    public double getAbscisse() {
        return abscisse;
    }
    
    public double getOrdonnee() {
        return ordonnee;
    }

    public void afficher(){
        System.out.println(nom + "(" + abscisse + "," + ordonnee +")");
    }


    public void deplacer(double dx, double dy){
        abscisse += dx;
        ordonnee += dy;
    }

    public void tourner(double theta){
        double tmp = abscisse;
        theta = Math.toRadians(theta);
        abscisse =  abscisse * Math.cos(theta) - ordonnee* Math.sin(theta);
        ordonnee =  tmp * Math.sin(theta) + ordonnee* Math.cos(theta);
    }

    public void afficherPoint(){
        System.out.println(nom + "(" + String.format("%.4f", abscisse) + "," + String.format("%.4f", ordonnee) +")");
    }


}
