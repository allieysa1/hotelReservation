package com.csc3402.lab.hotelreservation.controller;

import com.csc3402.lab.hotelreservation.model.Guest;
import com.csc3402.lab.hotelreservation.model.Reservation;
import com.csc3402.lab.hotelreservation.repository.GuestRepository;
import com.csc3402.lab.hotelreservation.repository.ReservationRepository;
import com.csc3402.lab.hotelreservation.repository.RoomRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/rooms")
public class RoomController {
    private final RoomRepository roomRepository;

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private GuestRepository guestRepository;


    public RoomController(RoomRepository roomRepository){
        this.roomRepository = roomRepository;
    }

    @GetMapping("list")
    public String showMyList(Model model) {
        model.addAttribute("rooms", roomRepository.findAll());
        model.addAttribute("guests", guestRepository.findAll());
        model.addAttribute("reservations", reservationRepository.findAll());
        return "roomList";
    }

    @GetMapping("signup")
    public String showSignUpForm(Guest guest, Model model) {
        model.addAttribute("reservations", reservationRepository.findAll());
        return "guest-info";
    }

    @PostMapping("addGuest")
    public String addGuest(@Valid Guest guest, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "guest-info";
        }

        guestRepository.save(guest);
        return "redirect:reservation";
    }

    @GetMapping("reservation")
    public String showReserveForm(Model model) {
        model.addAttribute("guests", guestRepository.findAll());
        return "choose-to-addReservation";
    }

    /*@GetMapping("reservation")
    public String assignReservation(Model model) {
        model.addAttribute("guests",guestRepository.findAll());
        return "choose-to-addReservation";
    }*/
    @GetMapping("edit/{id}")
    public String showReservationForm(@PathVariable("id") int id, Model model) {
        Guest guest = guestRepository.findById((int) id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid guest Id:" + id));
        Reservation reservation = new Reservation(); // Create a new Reservation object
        reservation.setGuest(guest); // Set the guest in the reservation object
        model.addAttribute("guest", guest);
        model.addAttribute("reservation", reservation); // Add the reservation object to the model
        model.addAttribute("reservations", reservationRepository.findAll());

        return "add-reservation";
    }
        @PostMapping("booking/{id}")
    public String saveReservation(@PathVariable("id") int id, @Valid Reservation reservation,
                                  BindingResult result, Model model) {
        if (result.hasErrors()) {
            reservation.setReservationId((int) id);
            return "index";
        }
        model.addAttribute("guests", guestRepository.findAll());
        model.addAttribute("reservations", reservationRepository.findAll());
        reservationRepository.save(reservation);
        return "list";
    }
//
}


