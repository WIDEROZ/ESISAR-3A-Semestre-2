package fr.esisar.geometrie;

public class CercleAvecException extends ObjetGeometrique{
    private double rayon;
    private Point centre;
    private String couleur;

    public CercleAvecException(double rayon, Point centre, String couleur) throws Exception{
        super("Cercle");
        if (rayon < 0) {
            throw new Exception("Le rayon du cercle ne peut être négatif.");
        }
        else{
            this.rayon = rayon;
        }
        
        this.centre = centre;
        this.couleur = couleur;
    }

    public double getRayon() {
        return rayon;
    }

    public Point getCentre(){
        return centre;
    }

    public String getCouleur(){
        return couleur;
    }

    public void setRayon(double rayon) throws Exception{
        if(rayon < 0){
            throw new Exception("Rayon négatif");
        }
        else{
            this.rayon = rayon;
        }
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
