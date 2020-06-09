package com.gym.lbdgym.model;

import com.gym.lbdgym.model.enumerator.State;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
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
}