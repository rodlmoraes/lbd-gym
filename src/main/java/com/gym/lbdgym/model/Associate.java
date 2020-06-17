package com.gym.lbdgym.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.gym.lbdgym.model.lesson.LessonAvailable;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@Data
@Entity
public class Associate implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue
  private Long id;
  private String name;
  private String address;
  private String profession;
  private String phone;

  @ManyToMany
  private List<LessonAvailable> lessonsAvailable;

  @ManyToMany
  private List<BankingData> bankingDatas;

  @OneToMany
  @JsonManagedReference(value = "associate")
  private List<Booking> bookings;
}