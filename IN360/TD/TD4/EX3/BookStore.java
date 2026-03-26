package EX3;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class BookStore {
    private ArrayList<Book> bibliotheque = new ArrayList<Book>();

    BookStore(){}

    public void addBook(Book livre){
        bibliotheque.add(livre);
    }
    



    public void removeBook(int rfid){
        ListIterator<Book> book = bibliotheque.listIterator();
        while (book.hasNext() && book.next().getTag_rfid() != rfid){
            book.remove();
        }
    }

    public ArrayList<Book> findBookByAuthor(String author){
        ArrayList<Book> livres = new ArrayList<Book>();
        for(Book book : bibliotheque){
            if(book.getAuteur() == author){
                livres.add(book);
            }
        }
        return livres;
    }

    public ArrayList<Book> findBookByTitle(String title){
        ArrayList<Book> livres = new ArrayList<Book>();
        for(Book book : bibliotheque){
            if(book.getTitre() == title){
                livres.add(book);
            }
        }
        return livres;
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


    public void updateBooks(int rfid, Book livre){
        ListIterator<Book> book = bibliotheque.listIterator();
        while(book.hasNext()){
            if(book.next().getTag_rfid() == rfid){
                book.set(livre);
                break;
            }
        }
    }

    public boolean getBookStatus(int rfid){
        ListIterator<Book> book = bibliotheque.listIterator();
        Book nextBook;
        while(book.hasNext()){
            nextBook = book.next();
            if(nextBook.getTag_rfid() == rfid){
                return nextBook.getDisponible() ;
            }
        }
        return false;
    }

    public void setBookStatus(int rfid, boolean disponibilite){
        ListIterator<Book> book = bibliotheque.listIterator();
        Book nextBook;
        while(book.hasNext()){
            nextBook = book.next();
            if(nextBook.getTag_rfid() == rfid){
                nextBook.setDisponible(disponibilite);
                break;
            }
        }
    }



    public static void main(String[] args) {
        BookStore biblio = new BookStore();
        Book livre1 = new Book(1, "Georges Orwell", "1984", "17-03-2026", 39.99f, false);
        Book livre2 = new Book(2, "Baruch Spinoza", "Traité théologico-politique", "12-08-1712", 9.99f, true);
        

        livre1.printInfo();
        livre2.printInfo();


        biblio.addBook(livre1);
        biblio.addBook(livre2);

        biblio.displayAllBooks();
    }

}
