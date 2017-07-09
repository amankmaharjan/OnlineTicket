package com.example.onlineTicket.service;

import com.example.onlineTicket.domain.Bus;
import com.example.onlineTicket.repository.BusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by aman on 7/9/17.
 */
@Service
@Transactional
public class BusService {
    @Autowired
    BusRepository busRepository;

    public void insert(Bus bus) {
        busRepository.save(bus);
    }

    public List<Bus> findAll() {
        return busRepository.findAll();
    }


}
