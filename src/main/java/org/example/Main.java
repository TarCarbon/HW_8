package org.example;

import org.apache.log4j.Logger;
import org.example.Database.Database;

public class Main {

    final private static Logger logger = Logger.getLogger(Main.class);
    public static void main(String[] args) {
        logger.info("Started");
        Database database = new Database().getInstance();
    }
}