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
@Table(name = "contact")
public class Contact {

    @Id
    @Getter
    @Setter
    @Column(name = "mobile_no")
    Integer mobileNo;

    @Getter
    @Setter
    @Column(name = "email")
    String email;

    @Getter
    @Setter
    @Column(name = "boarding_point")
    String boardingPoint;

    @Getter
    @Setter
    @OneToOne(mappedBy = "contact",cascade = CascadeType.ALL)
    Passenger passenger;
}
