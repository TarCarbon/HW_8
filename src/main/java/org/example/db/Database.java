package org.example.db;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    final private static Logger logger = Logger.getLogger(Database.class);

    private static Database instance;
    private Connection connection;

    public Database getInstance() {
        if (instance == null) {
            try (Connection connection = DriverManager.getConnection(Config.URL, Config.USER, Config.PASSWORD)) {
                instance = new Database();
                instance.connection = connection;
                logger.info("connection successful");
            } catch (SQLException e) {
                logger.error(e);
            }
        }
        return instance;
    }

    public Connection getConnection(){
        return connection;
    }
    public void closeConnection(){
        try {
            connection.close();
            logger.info("Connection is close");
        }catch (SQLException e) {
            logger.error("Error close connection" + e);
        }
    }
}
