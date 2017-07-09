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
@Table(name = "bus")
public class Bus {
    @Id
    @Column(name = "bus_no")
    @Getter
    @Setter
    Integer busNo;

    @Getter
    @Setter
    @OneToOne(cascade = CascadeType.ALL)
    BusType busType;

    @Getter
    @Setter
    @Column(name = "services")
    String services;

    @ManyToMany(cascade = CascadeType.ALL)
    @Getter
    @Setter
    List<BusTime> busTimes;

    @ManyToOne(cascade = CascadeType.ALL)
    @Getter
    @Setter
    Route route;

    @Getter
    @Setter
    @OneToMany(mappedBy = "bus",cascade = CascadeType.ALL)
    List<Seat>seatList;
}

