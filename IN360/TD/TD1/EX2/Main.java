package EX2;


public class Main {
    public static void main(String[] args) {
        Fraction f1 = new Fraction(123, 456);
        Fraction f2 = new Fraction(789, 10);
        
        // Calcul main
        int calcul_main = (123/456+789/10+11)*12;
        System.out.println("Calcul main : " + calcul_main);

        // Opérations : 
        f1.addFraction(f2);
        f1.add(11);
        f1.mult(12);
        System.out.println("Non réduit : " + );
        


    }
    
}
