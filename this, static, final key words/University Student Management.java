class Student {
    static String universityName = "National University";
    private static int totalStudents = 0;

    private final int rollNumber;
    private String name;
    private String grade;

    public Student(int rollNumber, String name, String grade) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.grade = grade;
        totalStudents++;
    }

    public static void displayTotalStudents() {
        System.out.println("Total Students Enrolled: " + totalStudents);
    }

    public void updateGrade(String newGrade) {
        if (this instanceof Student) {
            this.grade = newGrade;
            System.out.println("Grade updated for " + name + " to " + grade);
        } else {
            System.out.println("Not a valid Student object!");
        }
    }

    public void displayDetails() {
        if (this instanceof Student) {
            System.out.println("University: " + universityName);
            System.out.println("Roll Number: " + rollNumber);
            System.out.println("Name: " + name);
            System.out.println("Grade: " + grade);
            System.out.println("----------------------------");
        } else {
            System.out.println("Not a valid Student object!");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Student s1 = new Student(101, "Krati Agrawal", "A");
        Student s2 = new Student(102, "Akhil Rai", "B");

        s1.displayDetails();
        s2.displayDetails();

        s2.updateGrade("A+");

        Student.displayTotalStudents();
    }
}
