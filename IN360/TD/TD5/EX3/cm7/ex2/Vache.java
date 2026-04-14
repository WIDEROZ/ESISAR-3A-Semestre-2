package cm7.ex2;

public class Vache extends Animal
{
	private int nbLitreLait;

	public Vache(String nom, String nourriture, int nbLitreLait)
	{
		super(nom, nourriture);
		this.nbLitreLait = nbLitreLait;
	}
	
	public String toString()
	{
		return "Vache [nom=" + getNom() + "]";
	}

	public int getNbLitreLait()
	{
		return nbLitreLait;
	}

	public void setNbLitreLait(int nbLitreLait)
	{
		this.nbLitreLait = nbLitreLait;
	}	
}
