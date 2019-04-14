package com.wajahat.synchronization.deadlock;

public class Account {

    private int balance = 10000;

    public void deposit(int amount) {
        balance += amount;
    }

    public void withdraw(int amount) {
        balance -= amount;
    }

    public int getBalance() {
        return balance;
    }

    public static void transfer(Account a1, Account a2, int amount) {
        a1.withdraw(amount);
        System.out.println("Withdraw from a1: " + a1);
        a2.deposit(amount);
        System.out.println("Deposit to a2: " + a2);
    }

    @Override
    public String toString() {
        return "balance: " + balance;
    }
}
