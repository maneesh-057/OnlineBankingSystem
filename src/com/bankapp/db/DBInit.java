// package com.bankapp.db;

// import java.sql.Connection;
// import java.sql.Statement;

// public class DBInit {

//     public static void init() {
//         try (Connection con = DBConnection.getConnection()) {

//             Statement st = con.createStatement();

//             st.execute("""
//                 CREATE TABLE IF NOT EXISTS users (
//                     id INTEGER PRIMARY KEY AUTOINCREMENT,
//                     username TEXT UNIQUE,
//                     password TEXT,
//                     balance REAL DEFAULT 0
//                 )
//             """);

//             st.execute("""
//                 CREATE TABLE IF NOT EXISTS transactions (
//                     id INTEGER PRIMARY KEY AUTOINCREMENT,
//                     user_id INTEGER,
//                     type TEXT,
//                     amount REAL,
//                     time DATETIME DEFAULT CURRENT_TIMESTAMP
//                 )
//             """);

//         } catch (Exception e) {
//             e.printStackTrace();
//         }
//     }
// }
package com.bankapp.db;

import java.sql.Connection;
import java.sql.Statement;

public class DBInit {

    public static void init() {

        Connection con = DBConnection.getConnection();

        if (con == null) {
            System.out.println("DB Init aborted: connection is null");
            return;
        }

        try {
            Statement st = con.createStatement();

            st.execute("""
                CREATE TABLE IF NOT EXISTS users (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    username TEXT UNIQUE,
                    password TEXT,
                    balance REAL DEFAULT 0
                )
            """);

            st.execute("""
                CREATE TABLE IF NOT EXISTS transactions (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    user_id INTEGER,
                    type TEXT,
                    amount REAL,
                    time DATETIME DEFAULT CURRENT_TIMESTAMP
                )
            """);

            System.out.println("Database initialized successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
