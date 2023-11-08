package org.example;

import org.apache.log4j.Logger;
import org.example.CRUD.Buildings;
import org.example.CRUD.Residents;
import org.example.database.Database;
import org.example.database.FlywayMigration;
import org.example.query.FindResidents;

public class Main {

    final private static Logger logger = Logger.getLogger(Main.class);
    public static void main(String[] args) {
        logger.info("Started");
        new FlywayMigration().migration();
        Database database = new Database().getInstance();
        Buildings.readRecords(database.getConnection());
        Residents.readRecord();
        FindResidents.findResidents(database.getConnection());
        database.closeConnection();
    }
}