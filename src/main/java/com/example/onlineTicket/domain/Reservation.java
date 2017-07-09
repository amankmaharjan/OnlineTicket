package com.example.onlineTicket.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

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
    @Column(name = "ticket_id")
    @GenericGenerator(name = "sequence_ticket_id", strategy = "com.example.onlineTicket.config.generator.TicketIdGenerator")
    @GeneratedValue(generator = "sequence_ticket_id")

    private
    Integer tickedId;

    @OneToOne(cascade = CascadeType.ALL)
    @Getter
    @Setter
    private
    Route route;

    @Getter
    @Setter
    @ManyToOne(cascade = CascadeType.ALL)
    private
    Passenger passenger;

    @Getter
    @Setter
    @Column(name = "fare")
    private
    Integer fare;


}
