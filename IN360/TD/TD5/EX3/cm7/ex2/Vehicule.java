package cm7.ex2;

abstract public class Vehicule implements IVehicule
{
	private String identifiant;
	
	private int vitesseMaxi;
	
	
	public Vehicule(String identifiant, int vitesseMaxi)
	{
		this.identifiant = identifiant;
		this.vitesseMaxi = vitesseMaxi;
	}

	@Override
	public String toString()
	{
		return "Vehicule [identifiant=" + identifiant + ", vitesseMaxi="+ vitesseMaxi + "]";
	}

	
	// GETTERS AND SETTERS
	
	public String getIdentifiant()
	{
		return identifiant;
	}


	public void setIdentifiant(String identifiant)
	{
		this.identifiant = identifiant;
	}

	@Override
	public int getVitesseMaxi()
	{
		return vitesseMaxi;
	}


	public void setVitesseMaxi(int vitesseMaxi)
	{
		this.vitesseMaxi = vitesseMaxi;
	}	
}
