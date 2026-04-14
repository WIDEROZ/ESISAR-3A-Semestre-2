package cm7.ex2;

import java.util.ArrayList;

public class AnimalManager
{
	private ArrayList<IAnimal> animals;
	
	public AnimalManager()
	{
		this.animals = new ArrayList<IAnimal>();
	}

	public void addAnimal(IAnimal v)
	{
		animals.add(v);
	}

	/**
	 * Affiche les animaux mangeant cette nourriture 
	 */
	public void displayAnimalsEating(String nourriture)
	{
		System.out.println("Les animaux mangeant des "+nourriture+" sont :");
		for (IAnimal animal : animals)
		{
			if (animal.getNourriture().compareTo(nourriture)==0)
			{
				System.out.println("=>"+animal);
			}
		}
		System.out.println();
	}
}
