package fr.esisar.geometrie;

public class Cercle extends ObjetGeometrique{
    private double rayon;
    private Point centre;
    private String couleur;

    public Cercle(double rayon, Point centre, String couleur) {
        super("Cercle");
        this.rayon = rayon;
        this.centre = centre;
        this.couleur = couleur;
    }

    public double getRayon(){
        return rayon;
    }

    public Point getCentre(){
        return centre;
    }

    public String getCouleur(){
        return couleur;
    }


    public void setRayon(double rayon){
        this.rayon = rayon;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }


    @Override
    public void deplacer(double dx, double dy){
        centre.deplacer(dx, dy);
    }


    public void afficher(){
        System.out.println("Cercle de centre : ");
        centre.afficher();
        System.out.println("Et de rayon : " + rayon);
    }

    @Override
    public double perimetre(){
        return 2*Math.PI*rayon;
    }

    @Override
    public double aire(){
        return Math.PI*rayon*rayon;
    }

    public String svg(double strokeWidth){
        return "<circle cx=\"" + centre.getAbscisse() + "\" cy=\"" + centre.getOrdonnee() + "\" r=\"" + rayon + "\" stroke=\"" + couleur + "\" stroke-width=\"" + strokeWidth + "\" fill=\"none\" />";
    }

    


}

