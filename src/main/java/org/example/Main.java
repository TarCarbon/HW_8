package org.example;

import org.apache.log4j.Logger;
import org.example.CRUD.Buildings;
import org.example.CRUD.Residents;
import org.example.db.Database;
import org.example.db.FlywayMigration;
import org.example.query.FindResidents;

public class Main {

    final private static Logger logger = Logger.getLogger(Main.class);
    public static void main(String[] args) throws InterruptedException {
        logger.info("Started");
        new FlywayMigration().migration();
        Database database = new Database().getInstance();
        Buildings.readRecords(database.getConnection());
        Residents.readRecord();
        FindResidents.findResidents(database.getConnection());
        database.closeConnection();
    }
}