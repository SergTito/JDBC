package com.connection01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class jdbcStarter_Connection01 {
    public static void main(String[] args) throws ClassNotFoundException {


        Class.forName("org.postgresql.Driver");
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/product_repository",
                    "postgres","admin");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
