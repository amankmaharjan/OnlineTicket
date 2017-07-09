package com.example.onlineTicket.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by aman on 7/8/17.
 */
@Entity
@NoArgsConstructor
@Table(name = "reservation")
public class Reservation {
    @Id
    @Getter
    @Setter
    @Column(name="ticket_id")
    Integer tickedId;

    @OneToOne(cascade = CascadeType.ALL)
    @Getter
    @Setter
    Route route;

    @Getter
    @Setter
    @ManyToOne(cascade = CascadeType.ALL)
    Passenger passenger;

    @Getter
    @Setter
    @Column(name = "fare")
    Integer fare;
}
