package src;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class Feur extends TAF implements arg{
    public void fest(){
        ArrayList<Integer> array = new ArrayList<Integer>();

        Iterator<Integer> iter = array.Iterator();


        while(iter.hasnext()){


            iter.remove();
            iter.next();
        }
    }
}
