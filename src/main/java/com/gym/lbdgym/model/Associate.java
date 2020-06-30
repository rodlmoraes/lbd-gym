package com.gym.lbdgym.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
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
public class Associate implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue
  private Long id;
  private String name;
  private String address;
  private String profession;
  private String phone;

  @OneToMany
  @JsonManagedReference(value = "students_in_class")
  private List<StudentsInClass> studentsInClasses;

  @OneToOne
  private BankingData bankingData;

  @OneToMany(mappedBy = "associate")
  @JsonManagedReference(value = "associate")
  private List<Booking> bookings;
}