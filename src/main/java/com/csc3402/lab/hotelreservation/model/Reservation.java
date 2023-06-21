package com.csc3402.lab.hotelreservation.model;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.Set;

@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reservation_id")
    private Integer reservationId;

    @Column(name = "check_in")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private Date checkIn;

    @Column(name = "check_out")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private Date checkOut;

    @OneToMany(mappedBy = "reservation", cascade = CascadeType.ALL)
    private Set<Room> rooms;

    @ManyToOne
    @JoinColumn(name = "guest_id")
    private Guest guest;

    public Reservation() {
    }

    public Reservation(Integer reservationId, Date checkIn, Date checkOut, Set<Room> rooms, Guest guest) {
        this.reservationId= reservationId;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.rooms = rooms;
        this.guest = guest;
    }

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }

    public Integer getReservationId() {
        return reservationId;
    }

    public void setReservationId(Integer reservationId) {
        this.reservationId = reservationId;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(Date checkIn) {
        this.checkIn = checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(Date checkOut) {
        this.checkOut = checkOut;
    }

    public Set<Room> getRooms() {
        return rooms;
    }

    public void setRooms(Set<Room> rooms) {
        this.rooms = rooms;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "reservationId=" + reservationId +
                ", checkIn=" + checkIn +
                ", checkOut=" + checkOut +
                ", rooms=" + rooms +
                ", guest=" + guest +
                '}';
    }


}


