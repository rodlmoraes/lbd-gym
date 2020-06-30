package com.gym.lbdgym.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.gym.lbdgym.model.enumerator.Schooling;
import com.gym.lbdgym.model.lesson.LessonAvailable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
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

  @OneToMany
  @JsonManagedReference(value = "monitor")
  private List<LessonAvailable> lessonsAvailable;

  @OneToMany
  @JsonManagedReference(value = "monitor")
  private List<CanTeach> monitorLessons;
}