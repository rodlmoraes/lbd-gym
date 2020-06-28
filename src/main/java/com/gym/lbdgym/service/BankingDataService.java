package com.gym.lbdgym.service;

import com.gym.lbdgym.model.BankingData;
import com.gym.lbdgym.repository.BankingDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class BankingDataService {

  private final BankingDataRepository repository;

  public List<BankingData> findAll() {
    return repository.findAll();
  }

  public Optional<BankingData> findById(Long id) {
    return repository.findById(id);
  }

  public BankingData save(BankingData bankingData) {
    return repository.save(bankingData);
  }

  public void deleteById(Long id) {
    repository.deleteById(id);
  }
}