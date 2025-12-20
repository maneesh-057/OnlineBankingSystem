package com.bankapp.model;

public class Transaction {
    private String type;
    private double amount;
    private String time;

    public Transaction(String type, double amount, String time) {
        this.type = type;
        this.amount = amount;
        this.time = time;
    }

    public String getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    public String getTime() {
        return time;
    }
}
