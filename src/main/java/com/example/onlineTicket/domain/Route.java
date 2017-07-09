package com.example.onlineTicket.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    String routeId;

    @Getter
    @Setter
    @Column(name = "source")
    String source;

    @Getter
    @Setter
    @Column(name = "destination")
    String destination;

    @Getter
    @Setter
    @OneToOne(mappedBy = "route",cascade = CascadeType.ALL)
    Reservation reservation;


    @Getter
    @Setter
    @OneToMany(mappedBy = "route",cascade = CascadeType.ALL)
    List<Bus> busList;

}
