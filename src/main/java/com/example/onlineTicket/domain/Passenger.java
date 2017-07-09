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
@Table(name = "passenger")
public class Passenger {
    @Id
    @Getter
    @Setter
    @Column(name = "name")
    String name;

    @Getter
    @Setter
    @Column(name = "gender")
    Boolean gender;

    @OneToOne(cascade = CascadeType.ALL)
    @Getter
    @Setter
    Contact contact;
    @OneToMany(mappedBy = "passenger",cascade = CascadeType.ALL)
    @Getter
    @Setter
    List<Reservation>reservationList;

}
