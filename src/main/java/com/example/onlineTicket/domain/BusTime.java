package com.example.onlineTicket.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

/**
 * Created by aman on 7/9/17.
 */
@Entity
@NoArgsConstructor
@Table(name = "bus_time")
@ToString
public class BusTime {
    @Id
    @Getter
    @Setter
    @GenericGenerator(name = "sequence_time_id", strategy = "com.example.onlineTicket.config.generator.TimeIdGenerator")
    @GeneratedValue(generator = "sequence_time_id")
    @Column(name = "time_id")
    private
    String timeId;

    @Getter
    @Setter
    @Column(name = "arrival_time")
    private
    String arrivalTime;

    @Getter
    @Setter
    @Column(name = "departure_time")
    private
    String departureTime;

//    @Getter
//    @Setter
//    @ManyToMany(mappedBy = "busTimes", cascade = CascadeType.ALL)
//    private
//    List<Bus> busList;
}
