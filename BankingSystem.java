import java.util.*;

abstract class BankAccount {
    private String accountNumber;
    private String holderName;
    private double balance;

    public BankAccount(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber; this.holderName = holderName; this.balance = balance;
    }

    public String getAccountNumber() { return accountNumber; }
    public String getHolderName() { return holderName; }
    public double getBalance() { return balance; }

    public void deposit(double amount) {
        if (amount > 0) balance += amount;
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount; return true;
        }
        return false;
    }

    public abstract double calculateInterest(); // per period

    public void display() {
        System.out.printf("%s (%s): balance=%.2f interest=%.2f%n", holderName, accountNumber, balance, calculateInterest());
    }
}

interface Loanable {
    boolean applyForLoan(double amount);
    double calculateLoanEligibility();
}

class SavingsAccount extends BankAccount implements Loanable {
    public SavingsAccount(String acc, String name, double bal) { super(acc,name,bal); }
    public double calculateInterest() { return getBalance() * 0.04; } // 4% simple
    public boolean applyForLoan(double amount) { return calculateLoanEligibility() >= amount; }
    public double calculateLoanEligibility() { return getBalance() * 5; } // simple rule
}

class CurrentAccount extends BankAccount {
    public CurrentAccount(String acc, String name, double bal) { super(acc,name,bal); }
    public double calculateInterest() { return 0; } // no interest
}

public class BankingSystem {
    public static void main(String[] args) {
        List<BankAccount> accounts = List.of(
            new SavingsAccount("SB1001", "Karan", 20000),
            new CurrentAccount("CA2001", "Neha", 15000)
        );

        for (BankAccount a : accounts) a.display();

        SavingsAccount s = (SavingsAccount) accounts.get(0);
        System.out.println("Loan eligibility for " + s.getHolderName() + ": " + s.calculateLoanEligibility());
    }
}
