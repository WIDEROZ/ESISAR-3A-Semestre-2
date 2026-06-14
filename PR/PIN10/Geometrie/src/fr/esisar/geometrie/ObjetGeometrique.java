package fr.esisar.geometrie;

public abstract class ObjetGeometrique {
    private String name;

    public ObjetGeometrique(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    
    abstract public double perimetre();

    abstract public double aire();

    abstract public void deplacer(double dx, double dy);

}
