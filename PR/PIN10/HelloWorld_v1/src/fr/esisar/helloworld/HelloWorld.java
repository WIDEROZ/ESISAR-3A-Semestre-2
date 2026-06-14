package fr.esisar.helloworld;


public class HelloWorld {
    /**
      * ###### 1.
      * Vérifier si le chemin renseigné pour exécuter le fichier .class est bon.

      * ###### 2.
      * public static void main(String[] args){

      * ###### 3.
      * C'est le byte code
    **/
    public static void main(String[] args) {
        if (args.length == 1) {
            System.out.println("Hello " + args[0] + "!");
        }
        else{
            System.out.println("Hello World !");
        }
    }
}
