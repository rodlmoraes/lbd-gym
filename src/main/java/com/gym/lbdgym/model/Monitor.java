package com.gym.lbdgym.model;

import com.gym.lbdgym.model.enumerator.Schooling;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@AllArgsConstructor
@Data
@Entity
public class Monitor implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue
  private Long id;
  private String name;
  private Schooling schooling;
  private String rg;
  private String professionalExperience;
  private String phone;
}