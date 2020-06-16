package com.gym.lbdgym.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.gym.lbdgym.model.enumerator.Schooling;
import com.gym.lbdgym.model.lesson.Lesson;
import com.gym.lbdgym.model.lesson.LessonAvailable;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.List;

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
  @JsonBackReference(value = "lessonAvailable")
  private List<LessonAvailable> teaches;

  @OneToMany
  @JsonBackReference(value = "lesson")
  private List<Lesson> canTeach;
}