public class Fraction {
    private int num;
    private int den;

    public Fraction(int num, int den){
        if (den == 0) {
            System.out.println("IMPOSSIBLE DE DIVISER PAR 0 MALHEUREUX");
            return;
        }
        else{
            this.num = num;
            this.den = den;
        }
    }

    public int pgcd(int a, int b){
        return 1;
    }

    public void add(int x){
        num = x*den+num;
    }

    public void sub(int x){
        add(x);
        if (num == 0) {
            den = 0;
        }
    }

    public void mult(int x){
        num *= x;
        if (num == 0){
            den = 0;
        }
    }

    public void réduire(){
        int x = pgcd(num, den);
        num /= x;
        den /= x;
    }

    public void addFraction(Fraction f){
        num = ;
        den = ;
        
    }



}
