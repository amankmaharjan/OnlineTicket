package com.example.onlineTicket.service;

import com.example.onlineTicket.domain.Contact;
import com.example.onlineTicket.domain.Reservation;
import com.example.onlineTicket.repository.ContactRepository;
import com.example.onlineTicket.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by aman on 7/9/17.
 */
@RestController
public class ReservationService {
    @Autowired
    ReservationRepository reservationRepository;

    public void insert(Reservation reservation) {
        reservationRepository.save(reservation);
    }

    public List<Reservation> findAll() {
        return reservationRepository.findAll();
    }

}
