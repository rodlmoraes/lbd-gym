package com.gym.lbdgym.model.room;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Getter
@Setter
@Entity
class EquipmentRoom extends Room {

    private int maxNumberEquipments;

    public EquipmentRoom(Long id, String location, int size, int maxNumberEquipments) {
        super(id, location, size);
        this.maxNumberEquipments = maxNumberEquipments;
    }
}
