package com.serg_tito.jdbs.starter.dao;

public class TicketDao {

    private static final TicketDao INSTANCE = new TicketDao();

    private TicketDao() {
    }

    public static TicketDao getInstance(){
        return INSTANCE;
    }
}
