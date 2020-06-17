package com.gym.lbdgym.service;

import java.util.List;
import java.util.Optional;

import com.gym.lbdgym.model.Equipment;
import com.gym.lbdgym.repository.EquipmentRepository;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class EquipmentService {

  private final EquipmentRepository repository;

  public List<Equipment> findAll() {
    return repository.findAll();
  }

  public Optional<Equipment> findById(Long id) {
    return repository.findById(id);
  }

  public Equipment save(Equipment equipment) {
    return repository.save(equipment);
  }

  public void deleteById(Long id) {
    repository.deleteById(id);
  }
}