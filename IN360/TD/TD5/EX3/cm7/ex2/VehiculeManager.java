package cm7.ex2;

import java.util.ArrayList;

public class VehiculeManager
{
	private ArrayList<IVehicule> vehicules;	
	
	public VehiculeManager()
	{
		this.vehicules = new ArrayList<IVehicule>();
	}

	public void addVehicule(IVehicule v)
	{
		vehicules.add(v);
	}

	/**
	 * @return le véhicule le plus rapide de la liste 
	 */
	public IVehicule findFaster()
	{
		IVehicule res = null;
		for (IVehicule vehicule : vehicules)
		{
			if (res==null)
			{
				res = vehicule;
			}
			else if (res.getVitesseMaxi()<vehicule.getVitesseMaxi())
			{
				res = vehicule;
			}
		}
		return res;
	}
	
}
