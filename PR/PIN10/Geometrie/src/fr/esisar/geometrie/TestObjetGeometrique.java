package fr.esisar.geometrie;

public class TestObjetGeometrique {


    public boolean surfaceIdentique(ObjetGeometrique objet1, ObjetGeometrique objet2){
        if (objet1.aire() == objet2.aire()) {
            return true;
        }
        else{
            return false;
        }
    }

    public static void afficheObjetGeometrique(ObjetGeometrique objet){
        System.out.println("Cet objet est un/une : " + objet.getName());
    }



    public static void main(String[] args) {
        Cercle cercle = new Cercle(10, new Point("A", 10, 20), "white");
        Cercle cercle2 = new Cercle(10, new Point("A", 10, 20), "white");

        TestObjetGeometrique object = new TestObjetGeometrique();

        System.out.println(object.surfaceIdentique(cercle, cercle2));
    }
}
