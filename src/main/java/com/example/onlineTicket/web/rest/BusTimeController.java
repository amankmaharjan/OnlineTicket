package com.example.onlineTicket.web.rest;

import com.example.onlineTicket.domain.BusTime;
import com.example.onlineTicket.service.BusTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by aman on 7/9/17.
 */
@RestController
public class BusTimeController {
    @Autowired
    BusTimeService busTimeService;

    @PostMapping(path = "/time/")
    public ResponseEntity<?> insert(@RequestBody BusTime busTime) {
        busTimeService.insert(busTime);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(path = "/time/")
    public ResponseEntity<?> getAll() {
        return new ResponseEntity<>(busTimeService.findAll(), HttpStatus.OK);
    }

}
