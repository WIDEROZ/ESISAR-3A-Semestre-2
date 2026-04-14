package cm7.ex2;

public class Velo extends Vehicule
{
	private String couleur;
	
	public Velo(String identifiant, int vitesseMaxi, String couleur)
	{
		super(identifiant, vitesseMaxi);
		this.couleur = couleur;
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
