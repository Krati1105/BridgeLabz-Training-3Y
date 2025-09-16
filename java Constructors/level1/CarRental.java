package com.bridgelabz.oops.levelone;

class CarRental {
    private String customerName;
    private String carModel;
    private int rentalDays;
    private double costPerDay = 1000.0;

    public CarRental(String customerName, String carModel, int rentalDays) {
        this.customerName = customerName;
        this.carModel = carModel;
        this.rentalDays = rentalDays;
    }

    public double calculateTotalCost() {
        return rentalDays * costPerDay;
    }

    public void display() {
        System.out.println("Customer: " + customerName + ", Car: " + carModel + ", Days: " + rentalDays + ", Total Cost: " + calculateTotalCost());
    }

    public static void main(String[] args) {
        CarRental cr = new CarRental("Charlie", "Toyota", 5);
        cr.display();
    }
}
