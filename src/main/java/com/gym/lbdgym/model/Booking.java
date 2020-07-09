package com.gym.lbdgym.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.gym.lbdgym.model.room.SquashRoom;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(indexes = { @Index(name = "squashRoom_id_index", columnList = "squashRoom_id"),
        @Index(name = "associate_id_index", columnList = "associate_id"),
        @Index(name = "startDate_index", columnList = "startDate"),
        @Index(name = "endDate_index", columnList = "endDate") })
public class Booking implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id;
    private LocalDateTime startDate;
    private LocalDateTime endDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "squashRoom_id", nullable = false)
    @JsonBackReference(value = "squashRoom")
    private SquashRoom squashRoom;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "associate_id", nullable = false)
    @JsonBackReference(value = "associate")
    private Associate associate;

}
