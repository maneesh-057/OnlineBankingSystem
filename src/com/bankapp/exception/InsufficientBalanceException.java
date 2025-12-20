package com.bankapp.exception;

public class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException() {
        super("Insufficient Balance");
    }
}
