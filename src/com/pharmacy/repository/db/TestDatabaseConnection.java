package com.pharmacy.repository.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestDatabaseConnection {
    public static void main(String[] args) {
        try {
            Connection connection = DatabaseConnection.getInstance().getConnection();
            System.out.println("Connected to SQLite database successfully!");

            // Example query to list tables
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT name FROM sqlite_master WHERE type='table';");

            System.out.println("Tables in the database:");
            while (rs.next()) {
                System.out.println(rs.getString("name"));
            }

            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}