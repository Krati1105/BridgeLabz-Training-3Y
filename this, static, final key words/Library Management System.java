class Book {
    static String libraryName = "City Central Library";

    private final String isbn;
    private String title;
    private String author;

    public Book(String isbn, String title, String author) {
        this.isbn = isbn;       
        this.title = title;     
        this.author = author;   
    }

    public static void displayLibraryName() {
        System.out.println("Library Name: " + libraryName);
    }

    public void displayDetails() {
        if (this instanceof Book) {
            System.out.println("Library: " + libraryName);
            System.out.println("ISBN: " + isbn);
            System.out.println("Title: " + title);
            System.out.println("Author: " + author);
            System.out.println("---------------------------");
        } else {
            System.out.println("Not a valid Book object!");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Book.displayLibraryName();

        Book b1 = new Book("ISBN101", "Java Programming", "James Gosling");
        Book b2 = new Book("ISBN102", "C++ Basics", "Bjarne Stroustrup");

        b1.displayDetails();
        b2.displayDetails();
    }
}
