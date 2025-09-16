package com.bridgelabz.oops.levelone;

class Book {
    private String title;
    private String author;
    private double price;

    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public void displayDetails() {
        System.out.println("Book Title: " + title);
        System.out.println("Book Author: " + author);
        System.out.println("Book Price: " + price);
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public double getPrice() {
        return price;
    }
}

public class BookMain {
    public static void main(String[] args) {
        Book b1 = new Book("Java Programming", "James Gosling", 599.0);
        Book b2 = new Book("Effective Java", "Joshua Bloch", 799.0);

        b1.displayDetails();
        System.out.println("----------------------");
        b2.displayDetails();
    }
}
