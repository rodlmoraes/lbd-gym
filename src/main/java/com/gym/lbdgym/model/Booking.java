package com.gym.lbdgym.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.gym.lbdgym.model.room.SquashRoom;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.time.LocalDateTime;

public class Booking implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id;
    private LocalDateTime dateTime;

    @ManyToOne
    @JsonBackReference(value = "squashRoom")
    private SquashRoom squashRoom;

    @ManyToOne
    @JsonBackReference(value = "associate")
    private Associate associate;

}
