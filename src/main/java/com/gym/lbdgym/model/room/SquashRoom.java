package com.gym.lbdgym.model.room;

import com.gym.lbdgym.model.enumerator.State;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Getter
@Setter
@Entity
public class SquashRoom extends Room{

    private State conservationState;

    public SquashRoom(Long id, String location, int size, State conservationState) {
        super(id, location, size);
        this.conservationState = conservationState;
    }

}
