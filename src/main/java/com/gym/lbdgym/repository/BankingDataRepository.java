package com.gym.lbdgym.repository;

import com.gym.lbdgym.model.BankingData;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BankingDataRepository extends JpaRepository<BankingData, Long> {

}