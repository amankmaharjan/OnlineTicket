package com.example.onlineTicket.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

/**
 * Created by aman on 7/8/17.
 */
@Entity
@NoArgsConstructor
@Table(name = "bus")
@ToString
public class Bus {
    @Id
    @Column(name = "bus_no")
    @Getter
    @Setter
    private
    Integer busNo;

    @Getter
    @Setter
    @ManyToOne(cascade = CascadeType.ALL)
    private
    BusType busType;

    @Getter
    @Setter
    @Column(name = "services" )
    private
    String services;

    @ManyToMany(cascade = CascadeType.ALL)
    @Getter
    @Setter
    private
    List<BusTime> busTimes;

//    @ManyToOne(cascade = CascadeType.ALL)
//    @Getter
//    @Setter
//    private
//    Route route;

    @Getter
    @Setter
    @OneToMany(cascade = CascadeType.ALL)
    private
    List<Seat>seatList;


}

