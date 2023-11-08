package org.example.database;

import org.flywaydb.core.Flyway;
public class FlywayMigration {
    public void migration() {
        Flyway.configure()
                .dataSource(Config.URL, Config.USER, Config.PASSWORD)
                .load()
                .migrate();
           }
}
