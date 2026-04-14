package EX1;

public class Cercle {
    private int rayon;
    private int centreX;
    private int centreY;



    public Cercle(int rayon, int centreX, int centreY) {
        this.rayon = rayon;
        this.centreX = centreX;
        this.centreY = centreY;
    }

    @Override
    public void afficher(){
        System.out.println("Je suis un Cercle");
    }

    @Override
    public void deplace(int dx, int dy){
        this.centreX += dx;
        this.centreY += dy;
    }
}
