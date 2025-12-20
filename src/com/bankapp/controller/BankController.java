package com.bankapp.controller;

import com.bankapp.dao.TransactionDAO;
import com.bankapp.dao.UserDAO;
import com.bankapp.exception.InsufficientBalanceException;
import com.bankapp.model.User;

public class BankController {

    private UserDAO userDAO = new UserDAO();
    private TransactionDAO transactionDAO = new TransactionDAO();

    // Deposit money
    public boolean deposit(User user, double amount) {

        if (amount <= 0)
            return false;

        double newBalance = user.getBalance() + amount;
        user.setBalance(newBalance);

        userDAO.updateBalance(user.getId(), newBalance);
        transactionDAO.saveTransaction(user.getId(), "DEPOSIT", amount);

        return true;
    }

    // Withdraw money
    public boolean withdraw(User user, double amount)
            throws InsufficientBalanceException {

        if (amount <= 0)
            return false;

        if (amount > user.getBalance())
            throw new InsufficientBalanceException();

        double newBalance = user.getBalance() - amount;
        user.setBalance(newBalance);

        userDAO.updateBalance(user.getId(), newBalance);
        transactionDAO.saveTransaction(user.getId(), "WITHDRAW", amount);

        return true;
    }
}
