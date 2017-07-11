package com.example.onlineTicket.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

/**
 * Created by aman on 7/8/17.
 */
@Entity
@NoArgsConstructor
@Table(name = "route")
public class Route {
    @Id
    @Getter
    @Setter
    @Column(name = "route_id")
    @GenericGenerator(name = "sequence_route_id", strategy = "com.example.onlineTicket.config.generator.RouteIdGenerator")
    @GeneratedValue(generator = "sequence_route_id")
    private
    String routeId;

    @Getter
    @Setter
    @Column(name = "source")
    private
    String source;

    @Getter
    @Setter
    @Column(name = "destination")
    private
    String destination;

    @Getter
    @Setter
    @OneToOne(mappedBy = "route", cascade = CascadeType.ALL)
    private
    Reservation reservation;


    @Getter
    @Setter
    @OneToMany(cascade = CascadeType.ALL)
    private
    List<Bus> busList;
}
