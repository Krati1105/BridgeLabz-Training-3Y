class BankAccount {
    static String bankName = "State Bank of India";
    private static int totalAccounts = 0;

    private final int accountNumber;
    private String accountHolderName;
    private double balance;

    public BankAccount(int accountNumber, String accountHolderName, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
        totalAccounts++;
    }

    public static void getTotalAccounts() {
        System.out.println("Total Accounts: " + totalAccounts);
    }

    public void displayDetails() {
        if (this instanceof BankAccount) {
            System.out.println("Bank Name: " + bankName);
            System.out.println("Account Number: " + accountNumber);
            System.out.println("Account Holder: " + accountHolderName);
            System.out.println("Balance: " + balance);
            System.out.println("--------------------------");
        } else {
            System.out.println("Not a valid BankAccount object!");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        BankAccount acc1 = new BankAccount(101, "Krati", 5000.0);
        BankAccount acc2 = new BankAccount(102, "Akhil", 10000.0);

        acc1.displayDetails();
        acc2.displayDetails();

        BankAccount.getTotalAccounts();
    }
}
