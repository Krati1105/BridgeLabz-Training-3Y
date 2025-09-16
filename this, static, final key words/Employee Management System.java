class Employee {
    static String companyName = "Tech Solutions Pvt. Ltd.";
    private static int totalEmployees = 0;

    private final int id;
    private String name;
    private String designation;

    public Employee(int id, String name, String designation) {
        this.id = id;
        this.name = name;
        this.designation = designation;
        totalEmployees++;
    }

    public static void displayTotalEmployees() {
        System.out.println("Total Employees: " + totalEmployees);
    }

    public void displayDetails() {
        if (this instanceof Employee) {
            System.out.println("Company: " + companyName);
            System.out.println("Employee ID: " + id);
            System.out.println("Name: " + name);
            System.out.println("Designation: " + designation);
            System.out.println("----------------------------");
        } else {
            System.out.println("Not a valid Employee object!");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Employee e1 = new Employee(101, "Krati Agrawal", "Software Engineer");
        Employee e2 = new Employee(102, "Akhil Rai", "Project Manager");

        e1.displayDetails();
        e2.displayDetails();

        Employee.displayTotalEmployees();
    }
}
