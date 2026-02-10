package EX2;

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
        int x = 0;

        

        return x;
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
        int x = pgcd(f.den, den);
        num = (num * f.den/x) + (f.num * den / x);
        den = (f.den * den) / x;
    }

    public void multFraction(Fraction f){
        num *= f.num;
        den *= f.den;
    }


}

