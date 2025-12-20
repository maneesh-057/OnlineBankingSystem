package com.bankapp.ui;

import com.bankapp.controller.AuthController;

import javax.swing.*;
import java.awt.*;

public class RegisterFrame extends BaseFrame {

    private JTextField usernameField;
    private JPasswordField passwordField;
    private AuthController authController;

    public RegisterFrame() {
        super("Online Banking - Register");
        authController = new AuthController();
        initUI();
        setVisible(true);
    }

    private void initUI() {
        JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10));

        panel.add(new JLabel("Username:"));
        usernameField = new JTextField();
        panel.add(usernameField);

        panel.add(new JLabel("Password:"));
        passwordField = new JPasswordField();
        panel.add(passwordField);

        JButton registerBtn = new JButton("Register");
        JButton backBtn = new JButton("Back to Login");

        panel.add(registerBtn);
        panel.add(backBtn);

        add(panel);

        registerBtn.addActionListener(e -> handleRegister());
        backBtn.addActionListener(e -> {
            dispose();
            new LoginFrame();
        });
    }

    private void handleRegister() {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());

        boolean success = authController.register(username, password);

        if (success) {
            JOptionPane.showMessageDialog(this,
                    "Registration successful!");
            dispose();
            new LoginFrame();
        } else {
            JOptionPane.showMessageDialog(this,
                    "Registration failed (min 4 chars)",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}
