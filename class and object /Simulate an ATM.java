package com.bridgelabz.oops.levelone;

class BankAccount {
    private String accountHolder;
    private int accountNumber;
    private double balance;

    public BankAccount(String accountHolder, int accountNumber, double balance) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else if (amount > balance) {
            System.out.println("Insufficient balance.");
        } else {
            System.out.println("Invalid withdrawal amount.");
        }
    }

    public void displayBalance() {
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Current Balance: " + balance);
    }
}

public class BankAccountMain {
    public static void main(String[] args) {
        BankAccount acc1 = new BankAccount("Krati Agrawal", 1001, 5000.0);

        acc1.displayBalance();
        System.out.println("----------------------");

        acc1.deposit(2000);
        acc1.displayBalance();
        System.out.println("----------------------");

        acc1.withdraw(3000);
        acc1.displayBalance();
        System.out.println("----------------------");

        acc1.withdraw(6000); // trying to withdraw more than balance
        acc1.displayBalance();
    }
}
