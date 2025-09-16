import java.util.*;

abstract class Patient {
    private String patientId;
    private String name;
    private int age;

    public Patient(String patientId, String name, int age) {
        this.patientId = patientId; this.name = name; this.age = age;
    }

    public String getPatientId() { return patientId; }
    public String getName() { return name; }
    public int getAge() { return age; }

    public abstract double calculateBill();

    public void getPatientDetails() {
        System.out.printf("%s: %s, age %d, bill=%.2f%n", patientId, name, age, calculateBill());
    }
}

interface MedicalRecord {
    void addRecord(String record);
    List<String> viewRecords();
}

class InPatient extends Patient implements MedicalRecord {
    private double dailyRate;
    private int days;
    private List<String> records = new ArrayList<>();

    public InPatient(String id, String name, int age, double dailyRate, int days) {
        super(id,name,age); this.dailyRate = dailyRate; this.days = days;
    }

    public double calculateBill() { return dailyRate * days + 2000; } // room + misc
    public void addRecord(String record) { records.add(record); }
    public List<String> viewRecords() { return Collections.unmodifiableList(records); }
}

class OutPatient extends Patient implements MedicalRecord {
    private double consultationFee;
    private List<String> records = new ArrayList<>();

    public OutPatient(String id, String name, int age, double consultationFee) {
        super(id,name,age); this.consultationFee = consultationFee;
    }

    public double calculateBill() { return consultationFee; }
    public void addRecord(String record) { records.add(record); }
    public List<String> viewRecords() { return Collections.unmodifiableList(records); }
}

public class HospitalSystem {
    public static void main(String[] args) {
        List<Patient> patients = List.of(
            new InPatient("IP100", "Meera", 30, 3000, 5),
            new OutPatient("OP200", "Sameer", 40, 500)
        );

        for (Patient p : patients) p.getPatientDetails();

        InPatient ip = (InPatient) patients.get(0);
        ip.addRecord("Appendectomy performed.");
        System.out.println("Records: " + ip.viewRecords());
    }
}
