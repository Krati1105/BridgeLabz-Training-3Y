interface Worker {
    void performDuties();
}

class Person {
    String name;
    int id;

    public Person(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
    }
}

class Chef extends Person implements Worker {
    String specialty;

    public Chef(String name, int id, String specialty) {
        super(name, id);
        this.specialty = specialty;
    }

    @Override
    public void performDuties() {
        System.out.println("Role: Chef");
        displayDetails();
        System.out.println("Specialty: " + specialty);
        System.out.println("Duties: Cooking delicious meals.");
        System.out.println("----------------------------");
    }
}

class Waiter extends Person implements Worker {
    int tablesAssigned;

    public Waiter(String name, int id, int tablesAssigned) {
        super(name, id);
        this.tablesAssigned = tablesAssigned;
    }

    @Override
    public void performDuties() {
        System.out.println("Role: Waiter");
        displayDetails();
        System.out.println("Tables Assigned: " + tablesAssigned);
        System.out.println("Duties: Serving food and attending customers.");
        System.out.println("----------------------------");
    }
}

public class Main {
    public static void main(String[] args) {
        Chef chef = new Chef("Ramesh", 101, "Italian Cuisine");
        Waiter waiter = new Waiter("Suresh", 201, 5);

        Worker w1 = chef;
        Worker w2 = waiter;

        w1.performDuties();
        w2.performDuties();
    }
}
