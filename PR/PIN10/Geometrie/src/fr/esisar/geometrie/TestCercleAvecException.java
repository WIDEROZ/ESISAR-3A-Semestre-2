package fr.esisar.geometrie;

public class TestCercleAvecException{
    public static void main(String[] args) throws Exception{
        Point centre = new Point("M", 12.6, -5.2);
        CercleAvecException cercle = new CercleAvecException(-12, centre, "red");
    }
}
