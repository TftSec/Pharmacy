package com.pharmacy.repository.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Database connection manager
 */
public class DatabaseConnection {
    private static final Logger LOGGER = Logger.getLogger(DatabaseConnection.class.getName());
    private static final String CONFIG_FILE = "database.properties";

    private static DatabaseConnection instance;
    private Connection connection;
    private String url;
    private String username;
    private String password;

    private DatabaseConnection() {
        loadConfiguration();
    }

    /**
     * Get singleton instance
     * @return DatabaseConnection instance
     */
    public static synchronized DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    /**
     * Load database configuration from properties file
     */
    private void loadConfiguration() {
        Properties props = new Properties();
        try {
            // Directly set SQLite database path
            String dbPath = System.getProperty("user.home") + "/IdeaProjects/Gestion Pharmacie/ressources/Database.db";
            url = "jdbc:sqlite:" + dbPath;

            // SQLite does not require username or password
            username = null;
            password = null;

            // Load SQLite JDBC driver
            Class.forName("org.sqlite.JDBC");

        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Failed to load database configuration", e);
            throw new RuntimeException("Failed to initialize database connection", e);
        }
    }

    /**
     * Get database connection
     * @return Connection object
     * @throws SQLException if connection fails
     */
    public Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            try {
                connection = DriverManager.getConnection(url, username, password);
                connection.setAutoCommit(false);
            } catch (SQLException e) {
                LOGGER.log(Level.SEVERE, "Failed to establish database connection", e);
                throw e;
            }
        }
        return connection;
    }

    /**
     * Close the current connection
     */
    public void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                LOGGER.log(Level.WARNING, "Error closing database connection", e);
            }
        }
    }

    /**
     * Commit the current transaction
     */
    public void commit() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            try {
                connection.commit();
            } catch (SQLException e) {
                LOGGER.log(Level.SEVERE, "Failed to commit transaction", e);
                throw e;
            }
        }
    }

    /**
     * Rollback the current transaction
     */
    public void rollback() {
        if (connection != null) {
            try {
                connection.rollback();
            } catch (SQLException e) {
                LOGGER.log(Level.SEVERE, "Failed to rollback transaction", e);
            }
        }
    }
}
