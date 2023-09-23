package step.learning.OOP;

public class Book extends Lirerature {
    public Book(String author, String Title) {
        this.author = author;
        super.setTitle( Title );
    }

    private String author;
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String getCard() {
        return String.format("Book: %s '%s' ", getAuthor(), getTitle());
    }
}
