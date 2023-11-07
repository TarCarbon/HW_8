package org.example.Database;

import org.flywaydb.core.Flyway;
public class FlywayMigration {
    public void migration() {
        Flyway.configure()
                .dataSource(Config.URL, Config.USER, Config.PASSWORD)
                .locations("src/main/resources/migration")
                .load()
                .migrate();
           }
}
