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
@Table(name = "seat")
public class Seat {
    @Id
    @Getter
    @Setter
    @Column(name = "seat_name")
    private
    String seatName;

    @Getter
    @Setter
    @Column(name = "status")
    private
    Boolean status;

    @ManyToOne(cascade = CascadeType.ALL)
    @Getter
    @Setter
    private
    Bus bus;

}
