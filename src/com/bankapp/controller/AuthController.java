package com.bankapp.controller;

import com.bankapp.dao.UserDAO;
import com.bankapp.model.User;

public class AuthController {

    private UserDAO userDAO = new UserDAO();

    // Simulates doPost() for login
    public User login(String username, String password) {

        if (username == null || password == null)
            return null;

        if (username.trim().isEmpty() || password.trim().isEmpty())
            return null;

        return userDAO.login(username, password);
    }

    // Simulates doPost() for registration
    public boolean register(String username, String password) {

        if (username == null || password == null)
            return false;

        if (username.length() < 4 || password.length() < 4)
            return false;

        return userDAO.register(username, password);
    }
}
