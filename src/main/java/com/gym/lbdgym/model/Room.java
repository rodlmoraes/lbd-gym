package com.gym.lbdgym.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public interface Room extends Serializable {

  @Id
  @GeneratedValue
  public Long id;
  public String localization; // string???
  public int size;
}