package com.gym.lbdgym.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.gym.lbdgym.model.enumerator.State;
import com.gym.lbdgym.model.room.EquipmentRoom;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Equipment implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue
  private Long id;
  private State conservationState;
  private String description;

  @ManyToOne
  @JoinColumn(name = "equipmentRoom_id", nullable = false)
  @JsonBackReference(value = "equipmentRoom")
  private EquipmentRoom equipmentRoom;

}