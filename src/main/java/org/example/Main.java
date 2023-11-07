package org.example;

import org.apache.log4j.Logger;
import org.example.Database.Database;
import org.example.Database.FlywayMigration;

public class Main {

    final private static Logger logger = Logger.getLogger(Main.class);
    public static void main(String[] args) {
        logger.info("Started");
        new FlywayMigration().migration();
        Database database = new Database().getInstance();
        database.closeConnection();
    }
}