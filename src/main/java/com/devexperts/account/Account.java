package com.devexperts.account;

public class Account {
    private final AccountKey accountKey;
    private final String firstName;
    private final String lastName;
    private double balance;

    public Account(AccountKey accountKey, String firstName, String lastName, double balance) {
        this.accountKey = accountKey;
        this.firstName = firstName;
        this.lastName = lastName;
        this.balance = balance;
    }

    public AccountKey getAccountKey() {
        return accountKey;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
