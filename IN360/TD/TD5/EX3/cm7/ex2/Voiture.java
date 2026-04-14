package cm7.ex2;

public class Voiture extends Vehicule
{
	private String carburant;

	
	public Voiture(String identifiant, int vitesseMaxi, String carburant)
	{
		super(identifiant, vitesseMaxi);
		this.carburant = carburant;
	}

	public String getCarburant()
	{
		return carburant;
	}

	public void setCarburant(String carburant)
	{
		this.carburant = carburant;
	}
}
