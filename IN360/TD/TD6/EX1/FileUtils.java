package EX1;

import java.io.FileInputStream;
import java.io.IOException;

public class FileUtils
{
    /**
     */
    static public void displayFileContent(String fileName) throws IOException 
    {
        int c;

        
        try {
            FileInputStream fis = new FileInputStream(fileName);

            c = fis.read();
            while(c!=-1)
            {
                System.out.println("Le caractère est : "+c);
                c = fis.read();
            }
            fis.close();
        }
        catch (Exception e) {
            System.out.println("Le fichier : " + fileName + " n'existe pas");
            return;
        }
    }

    public static void main(String[] args) throws IOException
    {
        displayFileContent("test.txt");
    }
}
