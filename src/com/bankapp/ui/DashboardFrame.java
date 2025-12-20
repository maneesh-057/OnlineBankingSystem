package com.bankapp.ui;

import com.bankapp.controller.BankController;
import com.bankapp.exception.InsufficientBalanceException;
import com.bankapp.model.User;
import com.bankapp.thread.BalanceMonitor;
import java.awt.*;
import javax.swing.*;



public class DashboardFrame extends BaseFrame {
    
    private BalanceMonitor monitor;
    
    private User user;
    private JLabel balanceLabel;
    private BankController bankController;

    public DashboardFrame(User user) {
        super("Online Banking - Dashboard");
        this.user = user;
        this.bankController = new BankController();

        initUI();
        setVisible(true);

        monitor = new BalanceMonitor(user);
        monitor.start();

    }

    private void initUI() {

        JPanel panel = new JPanel(new GridLayout(5, 2, 10, 10));

        panel.add(new JLabel("Welcome:"));
        panel.add(new JLabel(user.getUsername()));

        panel.add(new JLabel("Current Balance:"));
        balanceLabel = new JLabel(String.valueOf(user.getBalance()));
        panel.add(balanceLabel);

        JButton depositBtn = new JButton("Deposit");
        JButton withdrawBtn = new JButton("Withdraw");
        JButton logoutBtn = new JButton("Logout");

        panel.add(depositBtn);
        panel.add(withdrawBtn);
        panel.add(logoutBtn);

        add(panel);

        depositBtn.addActionListener(e -> handleDeposit());
        withdrawBtn.addActionListener(e -> handleWithdraw());
        logoutBtn.addActionListener(e -> {
            dispose();
            new LoginFrame();
        });
    }

    private void handleDeposit() {
        String input = JOptionPane.showInputDialog(this, "Enter amount:");

        try {
            double amount = Double.parseDouble(input);
            boolean success = bankController.deposit(user, amount);

            if (success) {
                balanceLabel.setText(String.valueOf(user.getBalance()));
                JOptionPane.showMessageDialog(this, "Deposit successful!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                    "Invalid amount",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void handleWithdraw() {
        String input = JOptionPane.showInputDialog(this, "Enter amount:");

        try {
            double amount = Double.parseDouble(input);
            bankController.withdraw(user, amount);
            balanceLabel.setText(String.valueOf(user.getBalance()));
            JOptionPane.showMessageDialog(this, "Withdrawal successful!");

        } catch (InsufficientBalanceException e) {
            JOptionPane.showMessageDialog(this,
                    e.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                    "Invalid amount",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}
