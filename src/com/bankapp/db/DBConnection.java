// package com.bankapp.db;

// import java.sql.Connection;
// import java.sql.DriverManager;

// public class DBConnection {
//     public static Connection getConnection() {
//         try {
//             return DriverManager.getConnection("jdbc:sqlite:bank.db");
//         } catch (Exception e) {
//             System.out.println("Database connection failed");
//             return null;
//         }
//     }
// }


package com.bankapp.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    public static Connection getConnection() {
        try {
            Class.forName("org.sqlite.JDBC"); // force load driver
            return DriverManager.getConnection("jdbc:sqlite:bank.db");
        } catch (Exception e) {
            System.out.println("Database connection failed");
            e.printStackTrace();   // IMPORTANT
            return null;
        }
    }
}
