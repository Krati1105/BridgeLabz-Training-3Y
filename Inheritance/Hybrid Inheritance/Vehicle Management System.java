interface Refuelable {
    void refuel();
}

class Vehicle {
    String model;
    int maxSpeed;

    public Vehicle(String model, int maxSpeed) {
        this.model = model;
        this.maxSpeed = maxSpeed;
    }

    public void displayDetails() {
        System.out.println("Model: " + model);
        System.out.println("Max Speed: " + maxSpeed + " km/h");
    }
}

class ElectricVehicle extends Vehicle {
    int batteryCapacity;

    public ElectricVehicle(String model, int maxSpeed, int batteryCapacity) {
        super(model, maxSpeed);
        this.batteryCapacity = batteryCapacity;
    }

    public void charge() {
        System.out.println("Charging " + model + " with " + batteryCapacity + " kWh battery.");
    }

    public void displayEVDetails() {
        displayDetails();
        System.out.println("Battery Capacity: " + batteryCapacity + " kWh");
        System.out.println("Status: Electric Vehicle");
        System.out.println("----------------------------");
    }
}

class PetrolVehicle extends Vehicle implements Refuelable {
    int fuelCapacity;

    public PetrolVehicle(String model, int maxSpeed, int fuelCapacity) {
        super(model, maxSpeed);
        this.fuelCapacity = fuelCapacity;
    }

    @Override
    public void refuel() {
        System.out.println("Refueling " + model + " with " + fuelCapacity + " liters of petrol.");
    }

    public void displayPetrolDetails() {
        displayDetails();
        System.out.println("Fuel Capacity: " + fuelCapacity + " liters");
        System.out.println("Status: Petrol Vehicle");
        System.out.println("----------------------------");
    }
}

public class Main {
    public static void main(String[] args) {
        ElectricVehicle ev = new ElectricVehicle("Tesla Model S", 250, 100);
        PetrolVehicle pv = new PetrolVehicle("Honda City", 180, 40);

        ev.displayEVDetails();
        ev.charge();

        pv.displayPetrolDetails();
        pv.refuel();
    }
}
