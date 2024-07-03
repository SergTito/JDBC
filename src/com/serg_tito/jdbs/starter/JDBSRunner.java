package com.serg_tito.jdbs.starter;

import org.postgresql.Driver;
import com.serg_tito.jdbs.starter.util.ConnectionManager;

import java.sql.SQLException;

public class JDBSRunner {
    public static void main(String[] args) throws SQLException {

        Class<Driver> driverClass = Driver.class;


        try (var connection = ConnectionManager.open()) {
            System.out.println(connection.getTransactionIsolation());
        }

    }
}
