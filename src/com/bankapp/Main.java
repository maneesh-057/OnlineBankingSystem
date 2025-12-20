package com.bankapp;

import com.bankapp.db.DBInit;
import com.bankapp.ui.LoginFrame;

public class Main {
    public static void main(String[] args) {
        DBInit.init();      // initialize database
        new LoginFrame();   // launch GUI
    }
}
