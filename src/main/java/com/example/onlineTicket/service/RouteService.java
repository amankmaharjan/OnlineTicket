package com.example.onlineTicket.service;

import com.example.onlineTicket.domain.Bus;
import com.example.onlineTicket.domain.Route;
import com.example.onlineTicket.repository.BusRepository;
import com.example.onlineTicket.repository.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by aman on 7/9/17.
 */
@Service
@Transactional
public class RouteService {
    @Autowired
    RouteRepository routeRepository;
    @Autowired
    BusRepository busRepository;
    List<Bus> busList;

    public void insert(Route route) {
        busList = new LinkedList<>();
        for (Bus bus : route.getBusList()
                ) {
            busList.add(busRepository.findOne(bus.getBusNo()));
        }
        route.setBusList(busList);
        routeRepository.save(route);
    }

    public List<Route> findAll() {
        return routeRepository.findAll();
    }


}
