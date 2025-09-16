import java.util.*;

abstract class Vehicle {
    private String vehicleNumber;
    private String type;
    private double rentalRate;

    public Vehicle(String vehicleNumber, String type, double rentalRate) {
        this.vehicleNumber = vehicleNumber; this.type = type; this.rentalRate = rentalRate;
    }

    public String getVehicleNumber() { return vehicleNumber; }
    public String getType() { return type; }
    public double getRentalRate() { return rentalRate; }
    public void setRentalRate(double rentalRate) { this.rentalRate = rentalRate; }

    public abstract double calculateRentalCost(int days);

    public void display() {
        System.out.printf("%s (%s) rate=%.2f%n", vehicleNumber, type, rentalRate);
    }
}

interface Insurable {
    double calculateInsurance();
    String getInsuranceDetails();
}

class Car extends Vehicle implements Insurable {
    public Car(String no, double rate) { super(no,"Car",rate); }
    public double calculateRentalCost(int days) { return getRentalRate() * days; }
    public double calculateInsurance() { return 5000; }
    public String getInsuranceDetails() { return "Car policy XYZ"; }
}

class Bike extends Vehicle {
    public Bike(String no, double rate) { super(no,"Bike",rate); }
    public double calculateRentalCost(int days) { return getRentalRate() * days * 0.8; } // discount
}

class Truck extends Vehicle implements Insurable {
    public Truck(String no, double rate) { super(no,"Truck",rate); }
    public double calculateRentalCost(int days) { return getRentalRate() * days * 1.5; } // heavier
    public double calculateInsurance() { return 15000; }
    public String getInsuranceDetails() { return "Truck policy ABC"; }
}

public class VehicleRental {
    public static void main(String[] args) {
        List<Vehicle> fleet = List.of(
            new Car("KA01A1234", 2000),
            new Bike("KA02B2233", 500),
            new Truck("KA03C3344", 5000)
        );

        for (Vehicle v : fleet) {
            v.display();
            System.out.printf("Rental for 3 days: %.2f%n", v.calculateRentalCost(3));
            if (v instanceof Insurable) {
                Insurable ins = (Insurable) v;
                System.out.printf("Insurance: %.2f (%s)%n", ins.calculateInsurance(), ins.getInsuranceDetails());
            }
            System.out.println("---");
        }
    }
}
