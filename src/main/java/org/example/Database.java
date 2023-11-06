package org.example;

import org.apache.log4j.Logger;
import org.flywaydb.core.Flyway;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    final private static Logger logger = Logger.getLogger(Database.class);
    final private static String URL = "jdbc:h2:~/db";
    final private static String USER = "sa";
    final private static String PASSWORD = "password";
    private static Database instance;
    private Connection connection;

    public Database getInstance() {
        if (instance == null) {
            try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
                instance = new Database();
                instance.connection = connection;
            } catch (SQLException e) {
                logger.error(e);
            }
        }
        return instance;
    }

    public void flywayMigration(){
        Flyway.configure()
                .dataSource(URL, USER, PASSWORD)
                .load()
                .migrate();
    }
}
