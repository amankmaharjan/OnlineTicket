package com.example.onlineTicket.web.rest;

import com.example.onlineTicket.domain.BusType;
import com.example.onlineTicket.service.BusTypeService;
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
public class BusTypeController {
    @Autowired
    BusTypeService busTypeService;

    @PostMapping(path = "/bustype/")
    public ResponseEntity<?> insert(@RequestBody BusType busTime) {
        busTypeService.insert(busTime);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(path = "/bustype/")
    public ResponseEntity<?> getAll() {
        return new ResponseEntity<>(busTypeService.findAll(), HttpStatus.OK);
    }


}
