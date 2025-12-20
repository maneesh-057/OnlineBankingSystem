package com.bankapp.service;

import com.bankapp.exception.InsufficientBalanceException;

public interface BankOperations {
    boolean deposit(double amount);
    boolean withdraw(double amount) throws InsufficientBalanceException;
}
