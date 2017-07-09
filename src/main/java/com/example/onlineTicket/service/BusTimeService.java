package com.example.onlineTicket.service;

import com.example.onlineTicket.domain.BusTime;
import com.example.onlineTicket.repository.BusTimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * Created by aman on 7/9/17.
 */
@Service
@Transactional
public class BusTimeService {
    @Autowired
    BusTimeRepository busTimeRepository;

    public void insert(BusTime busTime) {
        busTimeRepository.save(busTime);
    }

    public List<BusTime> findAll() {
        return busTimeRepository.findAll();
    }


}
