package com.csc3402.lab.hotelreservation.model;

import jakarta.persistence.*;

@Entity
public class Room {

    public Room() {
    }

    public Room(Integer roomId, String roomName, Integer price, String roomType, String roomDesc, String photoUrl){
        this.roomId = roomId;
        this.roomName = roomName;
        this.price = price;
        this.roomType = roomType;
        this.roomDesc = roomDesc;
        this.photoUrl = photoUrl;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "room_id")
    private Integer roomId;

    @Column(name = "room_name")
    private String roomName;

    @Column(name = "price")
    private Integer price;

    @Column(name = "room_type")
    private String roomType;

    @Column(name = "room_desc")
    private String roomDesc;

    @Column(name = "photo_Url")
    private String photoUrl;

    @ManyToOne
    @JoinColumn (name = "reservation_no")
    private Reservation reservation;

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getRoomDesc() {
        return roomDesc;
    }

    public void setRoomDesc(String roomDesc) {
        this.roomDesc = roomDesc;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }


    @Override
    public String toString() {
        return "Room{" +
                "roomId=" + roomId +
                ", roomName='" + roomName + '\'' +
                ", price=" + price +
                ", roomType='" + roomType + '\'' +
                ", roomDesc='" + roomDesc + '\'' +
                ", photoUrl='" + photoUrl + '\'' +
                '}';
    }



    public Reservation getReservation(){
        return reservation;
    }

    public void setReservation(Reservation reservation){
        this.reservation = reservation;
    }
}


