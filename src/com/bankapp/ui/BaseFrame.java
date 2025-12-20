package com.bankapp.ui;

import javax.swing.JFrame;

public class BaseFrame extends JFrame {

    public BaseFrame(String title) {
        setTitle(title);
        setSize(400, 300);
        setLocationRelativeTo(null); // center screen
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
