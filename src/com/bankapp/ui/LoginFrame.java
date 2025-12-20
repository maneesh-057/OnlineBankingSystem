package com.bankapp.ui;

import com.bankapp.controller.AuthController;
import com.bankapp.model.User;
import java.awt.*;
import javax.swing.*;

public class LoginFrame extends BaseFrame {

    private JTextField usernameField;
    private JPasswordField passwordField;
    private AuthController authController;

    public LoginFrame() {
        super("Online Banking - Login");
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

        JButton loginBtn = new JButton("Login");
        JButton registerBtn = new JButton("Register");

        panel.add(loginBtn);
        panel.add(registerBtn);

        add(panel);

        // 🔹 EVENT HANDLING (VERY IMPORTANT)
        loginBtn.addActionListener(e -> handleLogin());
        registerBtn.addActionListener(e -> {
            dispose();
            new RegisterFrame();
        });

    }

    private void handleLogin() {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());

        User user = authController.login(username, password);

        if (user != null) {
            JOptionPane.showMessageDialog(this, "Login Successful!");
            dispose();
            new DashboardFrame(user);
        } else {
            JOptionPane.showMessageDialog(this,
                    "Invalid credentials",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }

    }
}
