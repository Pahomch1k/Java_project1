package step.learning.OOP;


public class OopDemo {
    public void run() {
        Book book = new Book("D. Knuth", "Art of prog");
        System.out.println(book.getCard() );
        Library library = new Library();
        library.add(book);
        library.printAllCards();
    }
}
