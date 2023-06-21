package com.csc3402.lab.hotelreservation.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Guest {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="guest_id")
    private Integer guestId;

    @Column(name="email")
    private String email;

    @Column(name="f_name")
    private String fname;

    @Column(name="l_name")
    private String lname;

    @Column(name="phone_no")
    private String phone;

    @Column(name="card_no")
    private String card;

    @OneToMany(mappedBy= "guest", cascade= CascadeType.ALL)
    private Set<Reservation> reservations;

    public Guest() {
    }

    public Integer getGuestId() {
        return guestId;
    }

    public void setGuestId(Integer guestId) {
        this.guestId = guestId;
    }

    public Guest(String email, String fname, String lname, String phone, String card, Set<Reservation> reservations) {
        this.email = email;
        this.fname = fname;
        this.lname = lname;
        this.phone = phone;
        this.card = card;
        this.reservations = reservations;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }

    public Set<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(Set<Reservation> reservations) {
        this.reservations = reservations;
    }


    @Override
    public String toString() {
        return "Guest{" +
                "guestId=" + guestId +
                ", email='" + email + '\'' +
                ", fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                ", phone='" + phone + '\'' +
                ", card='" + card + '\'' +
                ", reservations=" + reservations +
                '}';
    }
}
