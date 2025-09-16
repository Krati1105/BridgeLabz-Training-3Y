package com.bridgelabz.oops.levelone;

class MovieTicket {
    private String movieName;
    private int seatNumber;
    private double price;
    private boolean isBooked;

    public MovieTicket(String movieName) {
        this.movieName = movieName;
        this.isBooked = false;
    }


    public void bookTicket(int seatNumber, double price) {
        if (!isBooked) {
            this.seatNumber = seatNumber;
            this.price = price;
            this.isBooked = true;
            System.out.println("Ticket booked successfully!");
        } else {
            System.out.println("Ticket already booked!");
        }
    }

    public void displayTicket() {
        if (isBooked) {
            System.out.println("Movie: " + movieName);
            System.out.println("Seat Number: " + seatNumber);
            System.out.println("Price: " + price);
        } else {
            System.out.println("No ticket booked yet for movie: " + movieName);
        }
    }
}

public class MovieTicketMain {
    public static void main(String[] args) {
        MovieTicket ticket1 = new MovieTicket("Inception");

        ticket1.displayTicket();
        System.out.println("----------------------");

        ticket1.bookTicket(12, 250.0);
        ticket1.displayTicket();
        System.out.println("----------------------");

        ticket1.bookTicket(15, 300.0);
    }
}
