package com.gym.lbdgym.service;

import java.util.List;
import java.util.Optional;

import com.gym.lbdgym.model.Monitor;
import com.gym.lbdgym.repository.MonitorRepository;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MonitorService {

  private final MonitorRepository repository;

  public List<Monitor> findAll() {
    return repository.findAll();
  }

  public Optional<Monitor> findById(Long id) {
    return repository.findById(id);
  }

  public Monitor save(Monitor monitor) {
    return repository.save(monitor);
  }

  public void deleteById(Long id) {
    repository.deleteById(id);
  }
}