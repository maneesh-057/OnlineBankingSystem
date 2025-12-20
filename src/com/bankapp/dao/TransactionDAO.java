package com.bankapp.dao;

import com.bankapp.db.DBConnection;
import com.bankapp.model.Transaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TransactionDAO {

    // Save transaction
    public void saveTransaction(int userId, String type, double amount) {
        try (Connection con = DBConnection.getConnection()) {

            String sql =
              "INSERT INTO transactions(user_id, type, amount) VALUES (?,?,?)";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, userId);
            ps.setString(2, type);
            ps.setDouble(3, amount);

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Fetch transaction history
    public List<Transaction> getTransactions(int userId) {

        List<Transaction> list = new ArrayList<>();

        try (Connection con = DBConnection.getConnection()) {

            String sql =
              "SELECT * FROM transactions WHERE user_id=?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, userId);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new Transaction(
                    rs.getString("type"),
                    rs.getDouble("amount"),
                    rs.getString("time")
                ));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}
