package com.bridgelabz.oops.levelone;

class Course {
    private String courseName;
    private int duration; 
    private double fee;
    private static String instituteName = "BridgeLabz";

    public Course(String courseName, int duration, double fee) {
        this.courseName = courseName;
        this.duration = duration;
        this.fee = fee;
    }

    public void displayCourseDetails() {
        System.out.println("Course Name: " + courseName + ", Duration: " + duration + " months, Fee: " + fee + ", Institute: " + instituteName);
    }

    public static void updateInstituteName(String newInstituteName) {
        instituteName = newInstituteName;
    }

    public static void main(String[] args) {
        Course c1 = new Course("Java Full Stack", 6, 50000);
        Course c2 = new Course("Data Science", 12, 75000);

        c1.displayCourseDetails();
        c2.displayCourseDetails();

        Course.updateInstituteName("TechAcademy");
        System.out.println("After updating institute name:");

        c1.displayCourseDetails();
        c2.displayCourseDetails();
    }
}
