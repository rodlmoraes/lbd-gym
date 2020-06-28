package com.gym.lbdgym.service.room;

import com.gym.lbdgym.model.room.EquipmentRoom;
import com.gym.lbdgym.repository.room.EquipmentRoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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