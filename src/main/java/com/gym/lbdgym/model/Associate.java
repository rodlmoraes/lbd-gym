package com.gym.lbdgym.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
  @ManyToOne
  @JsonBackReference(value = "associate")
  private LessonAvailable lessonAvailable;
  @OneToMany
  @JsonManagedReference(value = "bankingData")
  private List<BankingData> bankingData;

}