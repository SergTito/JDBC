package com.connection01;

import com.serg_tito.jdbs.starter.util.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCRunner02 {
    public static void main(String[] args) throws SQLException {


//        String flightId = "2";
//        List<Long> result = getTicketsByFlightId(flightId);
//        System.out.println(result);
//        System.out.println("---");
        checkMetaData();

    }

    private static void checkMetaData() throws SQLException {
        try (Connection connection = ConnectionManager.open()) {
            DatabaseMetaData metaData = connection.getMetaData();
            var catalogs = metaData.getCatalogs();
            while(catalogs.next()){
                System.out.println(catalogs.getString(1));

                ResultSet schemas = metaData.getSchemas();
                while(schemas.next()){
                    System.out.println(schemas.getString("TABLE_SCHEM"));

                    ResultSet tables = metaData.getTables(null, null, "%s", null);
                    while(tables.next()){
                        System.out.println(tables.getString("TABLE_NAME"));
                    }
                }
            }
        }
    }


    private static List<Long> getTicketsByFlightId(String flightId) {
        String sql = """
                SELECT id
                FROM ticket
                WHERE flight_id = %s
                """.formatted(flightId);

        List<Long> result = new ArrayList<>();
        try (Connection connection = ConnectionManager.open();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            statement.setFetchSize(50);
            statement.setQueryTimeout(10);
            statement.setMaxRows(100);


            while (resultSet.next()) {
//                result.add(resultSet.getLong("id"));
                result.add(resultSet.getObject("id",Long.class));//NULL safe
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
}
