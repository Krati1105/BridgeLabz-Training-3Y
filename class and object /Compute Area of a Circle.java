package com.bridgelabz.oops.levelone;

class Employee {
    private String name;
    private int id;
    private double salary;

    public Employee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    public void displayDetails() {
        System.out.println("Employee ID: " + id);
        System.out.println("Employee Name: " + name);
        System.out.println("Employee Salary: " + salary);
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public double getSalary() {
        return salary;
    }
}

public class EmployeeMain {
    public static void main(String[] args) {
        Employee emp1 = new Employee("Krati Agrawal", 101, 45000.0);
        Employee emp2 = new Employee("Akhil Rai", 102, 50000.0);

        emp1.displayDetails();
        System.out.println("----------------------");
        emp2.displayDetails();
    }
}
