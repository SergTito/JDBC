package com.serg_tito.jdbs.starter.entity;

import java.math.BigDecimal;
import java.util.Objects;

public class Ticket {

    private Long id;
    private String passengerNo;
    private String passengerName;
    private Long flightID;
    private String seatNo;
    private BigDecimal coast;


    public Ticket(Long id, String passengerNo, String passengerName, Long flightID, String seatNo, BigDecimal coast) {
        this.id = id;
        this.passengerNo = passengerNo;
        this.passengerName = passengerName;
        this.flightID = flightID;
        this.seatNo = seatNo;
        this.coast = coast;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return Objects.equals(id, ticket.id) && Objects.equals(passengerNo, ticket.passengerNo) && Objects.equals(passengerName, ticket.passengerName) && Objects.equals(flightID, ticket.flightID) && Objects.equals(seatNo, ticket.seatNo) && Objects.equals(coast, ticket.coast);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, passengerNo, passengerName, flightID, seatNo, coast);
    }

    @Override
    public String toString() {
        return "Ticket{" +
               "id=" + id +
               ", passengerNo='" + passengerNo + '\'' +
               ", passengerName='" + passengerName + '\'' +
               ", flightID=" + flightID +
               ", seatNo='" + seatNo + '\'' +
               ", coast=" + coast +
               '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPassengerNo() {
        return passengerNo;
    }

    public void setPassengerNo(String passengerNo) {
        this.passengerNo = passengerNo;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public Long getFlightID() {
        return flightID;
    }

    public void setFlightID(Long flightID) {
        this.flightID = flightID;
    }

    public String getSeatNo() {
        return seatNo;
    }

    public void setSeatNo(String seatNo) {
        this.seatNo = seatNo;
    }

    public BigDecimal getCoast() {
        return coast;
    }

    public void setCoast(BigDecimal coast) {
        this.coast = coast;
    }
}
