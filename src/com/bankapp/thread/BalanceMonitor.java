package com.bankapp.thread;

import com.bankapp.model.User;

public class BalanceMonitor extends Thread {

    private User user;
    private boolean running = true;

    public BalanceMonitor(User user) {
        this.user = user;
    }

    // synchronized method (VERY IMPORTANT)
    private synchronized void checkBalance() {
        System.out.println(
            "[Monitor Thread] Current balance: " + user.getBalance()
        );
    }

    @Override
    public void run() {
        while (running) {
            checkBalance();
            try {
                Thread.sleep(5000); // runs every 5 seconds
            } catch (InterruptedException e) {
                running = false;
            }
        }
    }

    public void stopMonitor() {
        running = false;
    }
}
