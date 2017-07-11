package com.example.onlineTicket.service;

import com.example.onlineTicket.domain.*;
import com.example.onlineTicket.repository.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.awt.print.Book;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by aman on 7/9/17.
 */
@RestController
public class ReservationService {
    private final Logger log = LoggerFactory.getLogger(ReservationService.class);

    @Autowired
    ReservationRepository reservationRepository;
    @Autowired
    RouteRepository routeRepository;
    @Autowired
    BusRepository busRepository;
    Boolean statusChecker = false;//indicates seat availability false =not available
    @Autowired
    SeatRepository seatRepository;
    @Autowired
    BusTimeRepository busTimeRepository;


    public void insert(Reservation reservation) {
        Bus bus;
        List<Seat> bookableSeatList = new LinkedList<>();

        Route route;
        BusTime busTime;
        int fare = 500;

        log.info(reservation.getSeatList().toString());
        outerloop:
        for (Seat seat : seatRepository.findAll()
                ) {
            for (Seat bookable : reservation.getSeatList()
                    ) {
                if (seat.getSeatId().equals(bookable.getSeatId())) {
                    System.out.println(seat + "found ");
                    if (seat.getStatus() == true) {
                        statusChecker = false;
                        break outerloop;
                    }
                    seat.setStatus(true);
                    bookableSeatList.add(seat);
                    statusChecker = true;
                }
            }

        }
        bookableSeatList.forEach(System.out::println);

        log.info(statusChecker.toString());

        if (statusChecker) {
            route = routeRepository.findOne(reservation.getRoute().getRouteId());
            bus = busRepository.findOne(reservation.getBus().getBusNo());
            busTime = busTimeRepository.findOne(reservation.getBusTime().getTimeId());

            reservation.setRoute(route);
            reservation.setBus(bus);
            reservation.setBusTime(busTime);
            reservation.setFare(fare);
            reservation.setSeatList(bookableSeatList);
            log.info("reservation");
            log.info(reservation.toString());
            reservationRepository.save(reservation);
        } else {
            log.info("no seat available");
        }
    }

    public List<Reservation> findAll() {
        return reservationRepository.findAll();
    }

}
