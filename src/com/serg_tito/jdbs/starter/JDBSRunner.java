package com.serg_tito.jdbs.starter;

import org.postgresql.Driver;
import com.serg_tito.jdbs.starter.util.ConnectionManager;

import java.sql.SQLException;

public class JDBSRunner {
    public static void main(String[] args) throws SQLException {

        Class<Driver> driverClass = Driver.class;
        String sql = """
                UPDATE info
                SET data = 'testTEST'
                WHERE id = 5
                RETURNING *
                """;
        try (var connection = ConnectionManager.open();
             var statement = connection.createStatement()) {
            System.out.println(connection.getSchema());
            System.out.println(connection.getTransactionIsolation());
            var executeResult = statement.executeUpdate(sql);
            System.out.println(executeResult);

        }

    }
}
