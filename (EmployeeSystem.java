import java.util.*;

abstract class Employee {
    private String employeeId;
    private String name;
    private double baseSalary;

    public Employee(String employeeId, String name, double baseSalary) {
        this.employeeId = employeeId;
        this.name = name;
        this.baseSalary = baseSalary;
    }

    // Encapsulation
    public String getEmployeeId() { return employeeId; }
    public String getName() { return name; }
    public double getBaseSalary() { return baseSalary; }
    public void setBaseSalary(double baseSalary) { this.baseSalary = baseSalary; }

    public abstract double calculateSalary(); // abstract

    public void displayDetails() { // concrete
        System.out.printf("ID: %s | Name: %s | Salary: %.2f%n",
                          employeeId, name, calculateSalary());
    }
}

class FullTimeEmployee extends Employee {
    private double fixedAllowance;

    public FullTimeEmployee(String id, String name, double baseSalary, double fixedAllowance) {
        super(id, name, baseSalary);
        this.fixedAllowance = fixedAllowance;
    }

    public double calculateSalary() {
        return getBaseSalary() + fixedAllowance;
    }
}

class PartTimeEmployee extends Employee {
    private int hoursWorked;
    private double hourlyRate;

    public PartTimeEmployee(String id, String name, double hourlyRate, int hoursWorked) {
        super(id, name, 0); // baseSalary not used here
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    public double calculateSalary() {
        return hoursWorked * hourlyRate;
    }

    public void setHoursWorked(int hours) { this.hoursWorked = hours; }
}

interface Department {
    void assignDepartment(String dept);
    String getDepartmentDetails();
}

class HRDepartment implements Department {
    private String deptName;
    public void assignDepartment(String dept) { this.deptName = dept; }
    public String getDepartmentDetails() { return "Department: " + deptName; }
}

public class EmployeeSystem {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new FullTimeEmployee("F001", "Asha", 50000, 5000));
        employees.add(new PartTimeEmployee("P001", "Ravi", 300, 80));

        // Polymorphism: process as Employee
        for (Employee e : employees) e.displayDetails();

        Department hr = new HRDepartment();
        hr.assignDepartment("Human Resources");
        System.out.println(hr.getDepartmentDetails());
    }
}
