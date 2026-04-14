package cm7.ex2;


/**
 * Logiciel simple gérant une ferme avec des animaux et des vehicules
 * 
 */
public class ZAppli
{
	public static void main(String[] args)
	{
		// Création des managers
		AnimalManager animalManager = new AnimalManager();
		VehiculeManager vehiculeManager = new VehiculeManager();
		
		// Chargement des objets qui vont être gérés
		animalManager.addAnimal(new Vache("qui-rit", "herbe", 20));
		animalManager.addAnimal(new Lapin("cretin1", "carotte", "vert"));
		animalManager.addAnimal(new Lapin("cretin2", "carotte", "blanc"));
		animalManager.addAnimal(new Lapin("cretin3", "fleurs", "jaune"));
		
		vehiculeManager.addVehicule(new Voiture("CV-555-NN", 185, "essence"));
		vehiculeManager.addVehicule(new Voiture("CV-111-NN", 135, "diesel"));
		vehiculeManager.addVehicule(new Velo("fixie", 18, "bleu"));
		
		
		// Utilisation des données - Affichage des animaux mangeant des carrottes
		animalManager.displayAnimalsEating("carotte");
		
		// Utilisation des données - Affichage du véhicule le plus rapide 
		Vehicule v = vehiculeManager.findFaster();
		System.out.println("Le vehicule le plus rapide est "+v);
		
	}
}
