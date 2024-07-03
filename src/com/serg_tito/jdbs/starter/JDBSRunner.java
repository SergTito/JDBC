package com.serg_tito.jdbs.starter;

import org.postgresql.Driver;
import com.serg_tito.jdbs.starter.util.ConnectionManager;

import java.sql.SQLException;

public class JDBSRunner {
    public static void main(String[] args) throws SQLException {

        Class<Driver> driverClass = Driver.class;
        String sql = """
                CREATE TABLE IF NOT EXISTS info(
                id SERIAL PRIMARY KEY ,
                data TEXT NOT NULL
                );
                """;
        try (var connection = ConnectionManager.open();
             var statement = connection.createStatement()) {
            System.out.println(connection.getSchema());
            System.out.println(connection.getTransactionIsolation());
            var executeResult = statement.execute(sql);
            System.out.println(executeResult);
        }

    }
}
