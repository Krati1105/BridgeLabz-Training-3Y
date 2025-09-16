import java.util.*;

abstract class LibraryItem {
    private String itemId;
    private String title;
    private String author;

    public LibraryItem(String itemId, String title, String author) {
        this.itemId = itemId; this.title = title; this.author = author;
    }

    public String getItemId() { return itemId; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }

    public abstract int getLoanDuration(); // days

    public void getItemDetails() {
        System.out.printf("%s: %s by %s (loan %d days)%n", itemId, title, author, getLoanDuration());
    }
}

interface Reservable {
    boolean reserveItem(String borrower);
    boolean checkAvailability();
}

class Book extends LibraryItem implements Reservable {
    private boolean available = true;
    private String reservedBy = null;

    public Book(String id, String title, String author) { super(id,title,author); }
    public int getLoanDuration() { return 21; }
    public boolean reserveItem(String borrower) {
        if (available && reservedBy == null) { reservedBy = borrower; available = false; return true; }
        return false;
    }
    public boolean checkAvailability() { return available; }
}

class Magazine extends LibraryItem {
    public Magazine(String id, String title, String author) { super(id,title,author); }
    public int getLoanDuration() { return 7; }
}

class DVD extends LibraryItem {
    public DVD(String id, String title, String author) { super(id,title,author); }
    public int getLoanDuration() { return 3; }
}

public class LibrarySystem {
    public static void main(String[] args) {
        List<LibraryItem> items = List.of(
            new Book("B001","Java Programming","A. Author"),
            new Magazine("M001","Tech Monthly","Editorial"),
            new DVD("D001","Learning Java","Studio")
        );

        for (LibraryItem it : items) it.getItemDetails();

        Book book = (Book) items.get(0);
        System.out.println("Reserve success: " + book.reserveItem("Krati"));
        System.out.println("Available now? " + book.checkAvailability());
    }
}
