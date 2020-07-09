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
@NamedEntityGraph(attributeNodes = { @NamedAttributeNode("bookings"), @NamedAttributeNode("enrollments"),
    @NamedAttributeNode("bankingData") })
@Table(indexes = { @Index(name = "name_index", columnList = "name"),
    @Index(name = "address_index", columnList = "address"),
    @Index(name = "profession_index", columnList = "profession"), @Index(name = "phone_index", columnList = "phone") })
public class Associate implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue
  private Long id;
  private String name;
  private String address;
  private String profession;
  private String phone;

  @OneToMany(mappedBy = "associate", fetch = FetchType.LAZY)
  @JsonManagedReference(value = "associate")
  private List<Enrollment> enrollments;

  @OneToOne(fetch = FetchType.LAZY)
  private BankingData bankingData;

  @OneToMany(mappedBy = "associate", fetch = FetchType.LAZY)
  @JsonManagedReference(value = "associate")
  private List<Booking> bookings;
}