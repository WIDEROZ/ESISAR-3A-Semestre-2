package EX4;

public abstract class Vehicule{
    private int poids;
    
    public Vehicule(int poids){
        this.poids=poids;
    }

    public int getPoids() {
        return poids;
    }


    public void setPoids(int poids) {
        this.poids = poids;
    }

}
