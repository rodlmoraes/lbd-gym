package com.gym.lbdgym.model.room;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@AllArgsConstructor
@Data
@Entity
public class Room implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue
  public Long id;
  public String location; // string???
  public int size;

}