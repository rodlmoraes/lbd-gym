package com.gym.lbdgym.model.room;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.gym.lbdgym.model.Booking;
import com.gym.lbdgym.model.enumerator.State;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import java.util.List;

@Getter
@Setter
@Entity
public class SquashRoom extends Room{

    private State conservationState;
    @OneToOne
    @JsonBackReference(value = "booking")
    private List<Booking> bookingList;

    public SquashRoom(Long id, String location, int size, State conservationState) {
        super(id, location, size);
        this.conservationState = conservationState;
    }

}
