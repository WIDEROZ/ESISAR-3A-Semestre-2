package EX2;

import java.io.IOException;

public class IntergerUtils {
    /**
     * @param args
     * @throws IOException 
     */

    public IntergerUtils(){}

    public int toInteger(String str)  
    {
        int c;

        try {
            c= Integer.parseInt(str);
            return c;
        }
        catch (Exception e) {
            return -1;
        }

    }


    public static void main(String[] args) {
        
        IntergerUtils I = new IntergerUtils();
        
        System.out.println(I.toInteger("12"));
    }

}
