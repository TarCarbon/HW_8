package org.example.db;

import org.flywaydb.core.Flyway;
public class FlywayMigration {
    public void migration() throws InterruptedException {
        Flyway.configure()
                .dataSource(Config.URL, Config.USER, Config.PASSWORD)
                .load()
                .repair();

        Flyway.configure().dataSource(Config.URL, Config.USER, Config.PASSWORD)
                .load().migrate();


           }
}
