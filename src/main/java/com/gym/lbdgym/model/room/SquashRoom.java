package com.gym.lbdgym.model.room;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.gym.lbdgym.model.Booking;
import com.gym.lbdgym.model.enumerator.State;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Getter
@Setter
@Entity
public class SquashRoom extends Room {

    private static final long serialVersionUID = 1L;

    private State conservationState;

    @OneToMany
    @JsonManagedReference(value = "squashRoom")
    private List<Booking> bookings;

    public SquashRoom(Long id, String location, int size, State conservationState) {
        super(id, location, size);
        this.conservationState = conservationState;
    }

}
