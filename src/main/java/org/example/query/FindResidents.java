package org.example.query;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FindResidents {

    final private static String query = "SELECT residents.name, residents.sname, residents.email,  apartments.number, apartments.area, builders.address " +
            "FROM residents " +
            "INNER JOIN residents_to_apartments ON residents.id = residents_to_apartments.resident_id" +
            "INNER JOIN apartments ON apartments.id = residents_to_apartments.apartment_id " +
            "INNER JOIN builders_to_apartments ON builders_to_apartments.apartment_id = apartments.id " +
            "INNER JOIN builders ON builders.id = builders_to_apartments.builder_id " +
            "INNER JOIN property_rights_to_residents ON property_rights_to_residents.resident_id = residents.id " +
            "INNER JOIN property_rights ON property_rights_to_residents.property_right_id = property_rights_to_residents.id " +
            "WHERE residents.drive_into_the_territory = 1 AND property_rights_to_residents.property_right_id <= 3 " +
            "AND (SELECT COUNT(property_rights_to_residents.property_right_id) FROM property_rights_to_residents) = 1;";

    public static void findResidents(Connection connection) {

        try (Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery(query)){
            while(resultSet.next()) {
                String name = resultSet.getString("name");
                String sname = resultSet.getString("sname");
                String email = resultSet.getString("email");
                int number = resultSet.getInt("number");
                int area = resultSet.getInt("area");
                String buildersAddress = resultSet.getString("address");

                System.out.println("name: " + name + ", sname: " + sname + ", email: " + email + ", apartments number: " + number +
                        ", apartments area: " + area + ", builders address: " + buildersAddress);
            }
        }catch (SQLException e) {
            System.out.println("erorcik bliat:" + e);
        }
    }
}
