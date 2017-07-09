package com.example.onlineTicket.web.rest;

import com.example.onlineTicket.domain.Bus;
import com.example.onlineTicket.service.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.
        bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by aman on 7/9/17.
 */
@RestController
public class BusController {
    @Autowired
    BusService busService;

    @PostMapping(path = "/bus/")
    public ResponseEntity<?> insert(@RequestBody Bus bus) {
        busService.insert(bus);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(path = "/bus/")
    public ResponseEntity<?> getAll() {
        return new ResponseEntity<>(busService.findAll(), HttpStatus.OK);
    }
}
