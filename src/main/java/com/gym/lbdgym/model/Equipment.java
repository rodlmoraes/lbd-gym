package com.gym.lbdgym.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.gym.lbdgym.model.enumerator.State;
import com.gym.lbdgym.model.room.EquipmentRoom;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@AllArgsConstructor
@Data
@Entity
public class Equipment implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue
  private Long id;
  private State conservationState; // should be enum
  private String description;

  @ManyToOne
 // @JoinColumn(name = "equipmentRoom_id", nullable = false)
  @JsonBackReference(value = "equipmentRoom")
  private EquipmentRoom equipmentRoom;

}