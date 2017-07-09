package com.example.onlineTicket.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by aman on 7/9/17.
 */
@Entity
@NoArgsConstructor
@Table(name = "bus_type")
public class BusType {
    @Id
    @Getter
    @Setter
    @Column(name = "bus_type_id")
    String id;

    @Getter
    @Setter
    @Column(name = "bus_type")
    String type;

    @Getter
    @Setter
    @OneToOne(mappedBy = "busType",cascade = CascadeType.ALL)
    Bus bus;
}
