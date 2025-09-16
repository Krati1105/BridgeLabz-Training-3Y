class Course {
    String courseName;
    int duration; // in weeks

    public Course(String courseName, int duration) {
        this.courseName = courseName;
        this.duration = duration;
    }

    public void displayCourseInfo() {
        System.out.println("Course Name: " + courseName);
        System.out.println("Duration: " + duration + " weeks");
    }
}

class OnlineCourse extends Course {
    String platform;
    boolean isRecorded;

    public OnlineCourse(String courseName, int duration, String platform, boolean isRecorded) {
        super(courseName, duration);
        this.platform = platform;
        this.isRecorded = isRecorded;
    }

    @Override
    public void displayCourseInfo() {
        super.displayCourseInfo();
        System.out.println("Platform: " + platform);
        System.out.println("Recorded: " + (isRecorded ? "Yes" : "No"));
    }
}

class PaidOnlineCourse extends OnlineCourse {
    double fee;
    double discount;

    public PaidOnlineCourse(String courseName, int duration, String platform, boolean isRecorded, double fee, double discount) {
        super(courseName, duration, platform, isRecorded);
        this.fee = fee;
        this.discount = discount;
    }

    @Override
    public void displayCourseInfo() {
        super.displayCourseInfo();
        double finalFee = fee - (fee * discount / 100);
        System.out.println("Course Fee: " + fee);
        System.out.println("Discount: " + discount + "%");
        System.out.println("Final Fee after Discount: " + finalFee);
        System.out.println("----------------------------");
    }
}

public class Main {
    public static void main(String[] args) {
        Course c1 = new Course("Mathematics Basics", 6);
        OnlineCourse c2 = new OnlineCourse("Java Programming", 8, "Coursera", true);
        PaidOnlineCourse c3 = new PaidOnlineCourse("Full Stack Development", 12, "Udemy", true, 5000, 20);

        c1.displayCourseInfo();
        System.out.println();
        c2.displayCourseInfo();
        System.out.println();
        c3.displayCourseInfo();
    }
}
