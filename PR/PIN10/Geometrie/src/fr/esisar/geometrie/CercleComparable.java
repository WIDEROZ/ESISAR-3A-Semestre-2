package fr.esisar.geometrie;

public class CercleComparable extends Cercle implements Comparable<CercleComparable>{

    public CercleComparable(double rayon, Point centre, String couleur) {
        super(rayon, centre, couleur);
    }

    @Override
    public int compareTo(CercleComparable o){
        return Double.compare(super.getRayon(), o.getRayon());
    }

    public String toString(){
        String centre = super.getCentre().getNom() + "(" + super.getCentre().getAbscisse() + ", " + super.getCentre().getOrdonnee() + ")";
        return "Cercle de centre : " + centre + " et de rayon : " + super.getRayon();
    }
}
