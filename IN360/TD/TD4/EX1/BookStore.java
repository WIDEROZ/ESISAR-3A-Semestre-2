package EX1;
import java.util.ArrayList;

public class BookStore {
    ArrayList<Book> bibliotheque;

    BookStore(){}

    public void addBook(Book livre){
        bibliotheque.add(livre);
    }

    public void displayAllBooks(){
        int c = 0;
        for (Book livre : bibliotheque) {
            System.out.println("Le livre : " + livre.getTitre() + " est disponible dans la bibliothèque.");
            c++;
        }
        System.out.println();
        System.out.println("Le nombre de livres dans la bibliothèque est de : " + c);
    }

    public static void main(String[] args) {
        BookStore biblio = new BookStore();
        Book livre1 = new Book(1, "Georges Orwell", "1984", "17-03-2026", 39.99f);
        Book livre2 = new Book(2, "Baruch Spinoza", "Traité théologico-politique", "12-08-1712", 9.99f);
        

        livre1.printInfo();
        livre2.printInfo();


        biblio.addBook(livre1);
        biblio.addBook(livre2);

        biblio.displayAllBooks();
    }

}
