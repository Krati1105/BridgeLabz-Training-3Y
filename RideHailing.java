import java.util.*;

abstract class Vehicle {
    private String vehicleId;
    private String driverName;
    private double ratePerKm;

    public Vehicle(String vehicleId, String driverName, double ratePerKm) {
        this.vehicleId = vehicleId; this.driverName = driverName; this.ratePerKm = ratePerKm;
    }

    public String getVehicleId() { return vehicleId; }
    public String getDriverName() { return driverName; }
    public double getRatePerKm() { return ratePerKm; }
    public void setRatePerKm(double rate) { this.ratePerKm = rate; }

    public abstract double calculateFare(double distance);

    public void getVehicleDetails() {
        System.out.printf("%s driven by %s rate/km=%.2f%n", vehicleId, driverName, ratePerKm);
    }
}

interface GPS {
    String getCurrentLocation();
    void updateLocation(String newLocation);
}

class Car extends Vehicle implements GPS {
    private String location = "unknown";
    public Car(String id, String driver, double rate) { super(id,driver,rate); }
    public double calculateFare(double distance) { return getRatePerKm() * distance; }
    public String getCurrentLocation() { return location; }
    public void updateLocation(String newLocation) { location = newLocation; }
}

class Bike extends Vehicle implements GPS {
    private String location = "unknown";
    public Bike(String id, String driver, double rate) { super(id,driver,rate); }
    public double calculateFare(double distance) { return getRatePerKm() * distance * 0.8; }
    public String getCurrentLocation() { return location; }
    public void updateLocation(String newLocation) { location = newLocation; }
}

class Auto extends Vehicle implements GPS {
    private String location = "unknown";
    public Auto(String id, String driver, double rate) { super(id,driver,rate); }
    public double calculateFare(double distance) { return Math.max(30, getRatePerKm() * distance); }
    public String getCurrentLocation() { return location; }
    public void updateLocation(String newLocation) { location = newLocation; }
}

public class RideHailing {
    public static void main(String[] args) {
        List<Vehicle> fleet = List.of(
            new Car("V001","Ramesh",15),
            new Bike("V002","Geeta",8),
            new Auto("V003","Sunil",10)
        );

        double distance = 12.5;
        for (Vehicle v : fleet) {
            v.getVehicleDetails();
            System.out.printf("Fare for %.1f km: %.2f%n", distance, v.calculateFare(distance));
            if (v instanceof GPS) {
                GPS g = (GPS) v;
                g.updateLocation("Near Mall");
                System.out.println("Location: " + g.getCurrentLocation());
            }
            System.out.println("---");
        }
    }
}
