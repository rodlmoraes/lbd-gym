package com.gym.lbdgym.service.room;

import java.util.List;
import java.util.Optional;

import com.gym.lbdgym.model.room.EquipmentRoom;
import com.gym.lbdgym.repository.room.EquipmentRoomRepository;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class EquipmentRoomService {

  private final EquipmentRoomRepository repository;

  public List<EquipmentRoom> findAll() {
    return repository.findAll();
  }

  public Optional<EquipmentRoom> findById(Long id) {
    return repository.findById(id);
  }

  public EquipmentRoom save(EquipmentRoom equipmentRoom) {
    return repository.save(equipmentRoom);
  }

  public void deleteById(Long id) {
    repository.deleteById(id);
  }
}