package com.example.onlineTicket.service;

import com.example.onlineTicket.domain.Bus;
import com.example.onlineTicket.domain.BusTime;
import com.example.onlineTicket.domain.BusType;
import com.example.onlineTicket.domain.Seat;
import com.example.onlineTicket.repository.BusRepository;
import com.example.onlineTicket.repository.BusTimeRepository;
import com.example.onlineTicket.repository.BusTypeRepository;
import com.example.onlineTicket.repository.SeatRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by aman on 7/9/17.
 */
@Service
@Transactional
public class BusService {
    private final Logger log = LoggerFactory.getLogger(BusService.class);
    @Autowired
    BusRepository busRepository;
    @Autowired
    BusTimeRepository busTimeRepository;
    @Autowired
    BusTypeRepository busTypeRepository;
    List<BusTime> busTimeList;

    public void insert(Bus bus) {
        busTimeList = new LinkedList<>();
        BusType busType = busTypeRepository.findOne(bus.getBusType().getType());

        for (BusTime busTime : bus.getBusTimes()
                ) {
            busTimeList.add(busTimeRepository.findOne(busTime.getTimeId()));
        }

        bus.setBusTimes(busTimeList);
        bus.setBusType(busType);
        busRepository.save(bus);
    }

    public List<Bus> findAll() {
        return busRepository.findAll();
    }

    public void update(Bus editedBus) {
        Bus bus = findOneBus(editedBus.getBusNo());
        if (bus != null) {
            bus.setBusNo(editedBus.getBusNo());
            bus.setServices(editedBus.getServices());
            busRepository.save(bus);
        }
    }

    public Bus findOneBus(Integer id) {
        return busRepository.findOne(id);
    }

}
