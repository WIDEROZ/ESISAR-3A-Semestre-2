package cm7.ex2;

abstract public class Animal implements IAnimal
{
	private String nom;
	
	private String nourriture;


	public Animal(String nom, String nourriture)
	{
		super();
		this.nom = nom;
		this.nourriture = nourriture;
	}

	@Override
	public String toString()
	{
		return "Animal [nom=" + nom + "]";
	}

	// GETTERS AND SETTERS
	@Override
	public String getNom()
	{
		return nom;
	}

	@Override
	public void setNom(String nom)
	{
		this.nom = nom;
	}

	@Override
	public String getNourriture()
	{
		return nourriture;
	}

	@Override
	public void setNourriture(String nourriture)
	{
		this.nourriture = nourriture;
	}
}
