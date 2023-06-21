package com.csc3402.lab.hotelreservation.repository;

import com.csc3402.lab.hotelreservation.model.Guest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuestRepository extends JpaRepository<Guest,Integer> {

}
