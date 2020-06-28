package com.gym.lbdgym.service;

import com.gym.lbdgym.model.Associate;
import com.gym.lbdgym.repository.AssociateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class AssociateService {

  private final AssociateRepository repository;

  public List<Associate> findAll() {
    return repository.findAll();
  }

  public Optional<Associate> findById(Long id) {
    return repository.findById(id);
  }

  public Associate save(Associate associate) {
    return repository.save(associate);
  }

  public void deleteById(Long id) {
    repository.deleteById(id);
  }
}