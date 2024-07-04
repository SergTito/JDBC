package com.serg_tito.jdbs.starter.util;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Transaction {
    public static void main(String[] args) throws SQLException {

        long flightID = 8;
        //language=PostgreSQL
        var deleteFlightSql = "DELETE FROM flight WHERE id = ?";
        var deleteTicketsSql = "DELETE FROM ticket WHERE flight_id = ?";

        Connection connection = null;
        PreparedStatement deleteFlightStatement = null;
        PreparedStatement deleteTicketStatement = null;
        try {
            connection = ConnectionManager.open();
            deleteFlightStatement = connection.prepareStatement(deleteFlightSql);
            deleteTicketStatement = connection.prepareStatement(deleteTicketsSql);

                    connection.setAutoCommit(false);

            deleteFlightStatement.setLong(1, flightID);

            deleteTicketStatement.executeUpdate();

            if (true) {
                throw new RuntimeException("oops");
            }
            deleteFlightStatement.executeUpdate();
            connection.commit();
        } catch (Exception e) {
            if (connection != null) {
                connection.rollback();
            }
            throw e;
        }finally {
            if (connection != null) {
                connection.close();
            }
            if (deleteFlightStatement != null) {
                deleteFlightStatement.close();
            }
            if (deleteTicketStatement != null) {
                deleteTicketStatement.close();
            }
        }

    }
}
