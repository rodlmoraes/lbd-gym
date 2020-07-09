package com.gym.lbdgym.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(indexes = { @Index(name = "account_index", columnList = "account"),
    @Index(name = "agency_index", columnList = "agency"),
    @Index(name = "associate_id_index", columnList = "associate_id") })
public class BankingData implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue
  private Long id;
  private String account;
  private String agency;

  @OneToOne(fetch = FetchType.LAZY)
  private Associate associate;
}