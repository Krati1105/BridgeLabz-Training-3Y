class Device {
    String deviceId;
    String status;

    public Device(String deviceId, String status) {
        this.deviceId = deviceId;
        this.status = status;
    }

    public void displayStatus() {
        System.out.println("Device ID: " + deviceId);
        System.out.println("Status: " + status);
    }
}

class Thermostat extends Device {
    int temperatureSetting;

    public Thermostat(String deviceId, String status, int temperatureSetting) {
        super(deviceId, status);
        this.temperatureSetting = temperatureSetting;
    }

    @Override
    public void displayStatus() {
        super.displayStatus();
        System.out.println("Temperature Setting: " + temperatureSetting + "°C");
        System.out.println("----------------------------");
    }
}

public class Main {
    public static void main(String[] args) {
        Thermostat t1 = new Thermostat("T1001", "ON", 24);
        Thermostat t2 = new Thermostat("T1002", "OFF", 18);

        t1.displayStatus();
        t2.displayStatus();
    }
}
