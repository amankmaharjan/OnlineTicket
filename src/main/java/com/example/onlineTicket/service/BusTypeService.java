package com.example.onlineTicket.service;

import com.example.onlineTicket.domain.BusType;
import com.example.onlineTicket.repository.BusTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by aman on 7/9/17.
 */
@Service
@Transactional
public class BusTypeService {
    @Autowired
    BusTypeRepository busTypeRepository;

    public void insert(BusType busType) {
        busTypeRepository.save(busType);
    }

    public List<BusType> findAll() {
        return busTypeRepository.findAll();
    }

}

