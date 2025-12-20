package com.bankapp.dao;

import com.bankapp.db.DBConnection;
import com.bankapp.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO {

    // Register new user
    public boolean register(String username, String password) {
        try (Connection con = DBConnection.getConnection()) {

            String sql =
              "INSERT INTO users(username, password) VALUES (?, ?)";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            return false;
        }
    }

    // Login user
    public User login(String username, String password) {
        try (Connection con = DBConnection.getConnection()) {

            String sql =
              "SELECT * FROM users WHERE username=? AND password=?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new User(
                    rs.getInt("id"),
                    rs.getString("username"),
                    rs.getDouble("balance")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // Update balance
    public void updateBalance(int userId, double balance) {
        try (Connection con = DBConnection.getConnection()) {

            String sql =
              "UPDATE users SET balance=? WHERE id=?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDouble(1, balance);
            ps.setInt(2, userId);

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
