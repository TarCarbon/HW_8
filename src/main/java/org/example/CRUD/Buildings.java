package org.example.CRUD;

import java.sql.*;

public class Buildings {

    public static void createRecord(Connection connection, String address) {
        String insertQuery = "INSERT INTO buildings (address) VALUES (?)";
        try(PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)){
            preparedStatement.setString(1, address);
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            System.out.println("Error: " + e);
        }
    }

    public static void readRecords (Connection connection) {
        String selectQuery = "SELECT * FROM builders";
        try(Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery(selectQuery)) {
            while(resultSet.next()) {
                int id = resultSet.getInt("id");
                String address = resultSet.getString("address");
                System.out.println("ID: " + id + ", Address: " + address);
            }
        }catch (SQLException e) {
            System.out.println("Error: " + e);
        }
    }

    public static void updateRecord(Connection connection, String address) {
        String updateRecord = "UPDATE buildings SET address = ?  WHERE id = ?";
        try(PreparedStatement preparedStatement = connection.prepareStatement(updateRecord)){
            preparedStatement.setString(1,  address);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: " + e);;
        }
    }

    public static void deleteRecord(Connection connection, int id) {
        String deleteRecord = "DELETE FROM buildings WHERE id = ?";
        try(PreparedStatement preparedStatement = connection.prepareStatement(deleteRecord)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            System.out.println("Record with Id: " + id + " was delete" );
        } catch (SQLException e){
            System.out.println("Exception " + e);
        }
    }

}
