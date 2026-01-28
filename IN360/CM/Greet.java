public class Greet {
    /* Fields */
    private String str = "";
    
    /* Constructor */
    public Greet(){};

    /* Methods */
    public void set_str(String str){
        this.str = str;
    }
    public String get_str(){
        return str;
    }
    public void print(){
        System.out.println("Hello, " + str + "!");
    }
    

    public static void main(String[] args) {

        Greet greet = new Greet();
        greet.set_str("feur");
        greet.print();
        

    }

}