package com.gym.lbdgym.model.room;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.gym.lbdgym.model.Equipment;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Getter
@Setter
@Entity
public class EquipmentRoom extends Room {

    private int maxNumberEquipments;

    @OneToMany(mappedBy = "equipmentRoom")
    @JsonManagedReference(value = "equipmentRoom")
    private List<Equipment> equipments;

    public EquipmentRoom(Long id, String location, int size, int maxNumberEquipments) {
        super(id, location, size);
        this.maxNumberEquipments = maxNumberEquipments;
    }
}
