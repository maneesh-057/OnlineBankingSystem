package com.bankapp.service;

import com.bankapp.exception.InsufficientBalanceException;

public class BankService implements BankOperations {

    private double balance;

    public BankService(double balance) {
        this.balance = balance;
    }

    @Override
    public boolean deposit(double amount) {
        balance += amount;
        return true;
    }

    @Override
    public boolean withdraw(double amount)
            throws InsufficientBalanceException {
        if (amount > balance)
            throw new InsufficientBalanceException();
        balance -= amount;
        return true;
    }
}
