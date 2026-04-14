package cm7.ex2;

public class Lapin extends Animal
{
	private String couleur;

	public Lapin(String nom, String nourriture, String couleur)
	{
		super(nom, nourriture);
		this.couleur = couleur;
	}

	public String toString()
	{
		return "Lapin [nom=" + getNom() + "]";
	}
	
	public String getCouleur()
	{
		return couleur;
	}

	public void setCouleur(String couleur)
	{
		this.couleur = couleur;
	}
	
}
