package EX4;

import java.text.ParseException;
import java.util.ArrayList;

public class Parking {
    
    /* Parameters */
    
    private int nbPlaces;
    private int poidsMax;

    private Vehicule[] parking;
    

    /* Constructor */

    public Parking(int nbPlaces, int poidsMax){
        this.nbPlaces = nbPlaces;
        this.poidsMax = poidsMax;
        int i = 0;

        while (i < nbPlaces) {
            parking[i] = null;
        }

    }

    /* Getters and Setters */

    public int getNbPlaces() {
        return nbPlaces;
    }

    public int getPoidsMax() {
        return poidsMax;
    }

    public void setNbPlaces(int nbPlaces) {
        this.nbPlaces = nbPlaces;
    }

    public void setPoidsMax(int poidsMax) {
        this.poidsMax = poidsMax;
    }

    /* END Getters and Setters */


    public void garer(Vehicule v, int place) throws ParkingExceptions{
        if(place >= nbPlaces || place < 0){
            throw new HorsParkingException();
        }
        else if(v.getPoids()+poidsMax > poidsMax){
            throw new PoidsMaxiException();
        }
        else if(parking[place] != null){
            throw new PlaceNonLibreException();
        }
        else if(place-1 >= 0){
            if(parking[place-1].getClass() == "Camion"){
                throw new CamionTropProcheException();
            }
        }
    }

    
}
