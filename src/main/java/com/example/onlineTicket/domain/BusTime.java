package com.example.onlineTicket.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/**
 * Created by aman on 7/9/17.
 */
@Entity
@NoArgsConstructor
@Table(name = "bus_time")
public class BusTime {
    @Id
    @Getter
    @Setter
    @Column(name = "time_Id")
    String timeId;

    @Getter
    @Setter
    @Column(name = "arrivalTime")
    String arrivalTime;

    @Getter
    @Setter
    @Column(name = "departure_Time")
    String departureTime;

    @Getter
    @Setter
    @ManyToMany(mappedBy = "busTimes",cascade = CascadeType.ALL)
    List<Bus> busList;

}
