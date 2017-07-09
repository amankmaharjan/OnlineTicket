package com.example.onlineTicket.web.rest;

import com.example.onlineTicket.domain.Route;
import com.example.onlineTicket.service.RouteService;
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
public class RouteController {
    @Autowired
    RouteService routeService;

    @PostMapping(path = "/route/")
    public ResponseEntity<?> insert(@RequestBody Route route) {
        routeService.insert(route);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(path = "/route/")
    public ResponseEntity<?> getAll() {
        return new ResponseEntity<>(routeService.findAll(), HttpStatus.OK);
    }

}
