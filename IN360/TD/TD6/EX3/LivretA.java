package EX3;

public class LivretA {
    private int montant;
    
    public LivretA(){
        montant=0;
    }


    public void depot(int s1) throws MontantIncorrectException{
        if(montant+s1 <= 7500 && montant+s1 >= 0){
            montant += s1;
        }
        else{
            throw new MontantIncorrectException("Le montant est supérieur ou inférieur à 7.500 €");
        }
    }


    public static void main(String[] args) throws MontantIncorrectException{

        LivretA compte = new LivretA();
        
        compte.depot(11215);
    }


}
