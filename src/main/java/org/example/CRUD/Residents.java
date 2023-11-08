package org.example.CRUD;

import java.sql.*;

public class Residents {

    private static Connection connection;
    public Residents(Connection connection) {
        Residents.connection = connection;
    }
    public static void createRecord( String name, String sname, String email, boolean driveIntoTheTerritory, int participantOSBBid){
        String createQuery = "INSERT INTO residents (name, sname, email, drive_into_the_territory, participant_OSBB_id) VALUES (?, ?, ?, ?, ?)";
        try(PreparedStatement preparedStatement = connection.prepareStatement(createQuery)){
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, sname);
            preparedStatement.setString(3, email);
            preparedStatement.setBoolean(4, driveIntoTheTerritory);
            preparedStatement.setInt(5, participantOSBBid);
            preparedStatement.executeUpdate();
        }catch (SQLException e ) {
            System.out.println("Exception:" + e);
        }
    }

    public static void readRecord(){
        String readQuery = "SELECT * FROM residents";
        try(Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery(readQuery)) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String sname = resultSet.getString("sname");
                String email = resultSet.getString("email");
                boolean driveIntoTheTerritory = resultSet.getBoolean("drive_into_the_territory");
                int participantOSBBid = resultSet.getInt("participant_OSBB_id");
                StringBuilder str = new StringBuilder();
                str.append("id: ").append(id)
                        .append(", name:").append(sname)
                        .append(", surname:").append(email)
                        .append(", drive_into_the_territory").append(driveIntoTheTerritory)
                        .append(", participant_OSBB_id").append(participantOSBBid);
                System.out.println(str);
            }
        }catch (SQLException e) {
            System.out.println("Exception:" + e);
        }
    }

    public static void updateRecord(int id){
        String updateQuery = "UPDATE residents WHERE id = ?";
        try(PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)){
             preparedStatement.setInt(1, id);
             preparedStatement.executeUpdate();
            System.out.println("Update where id=" + id + "is successful!");
        }catch (SQLException e ) {
            System.out.println("Exception in update:" + e);
        }
    }
    public static void deleteRecord(int id) {
        String deleteQuery = "DELETE residents WHERE id = ?";
        try(PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            System.out.println("Delete where id=" + id + "is successful!");

        }catch (SQLException e) {
            System.out.println("DELETE exception: " + e);
        }
    }
}
