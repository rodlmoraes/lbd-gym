package com.gym.lbdgym.controller.room;

import com.gym.lbdgym.model.room.EquipmentRoom;
import com.gym.lbdgym.service.room.EquipmentRoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping({ "/equipmentRoom" })
@RequiredArgsConstructor
public class EquipmentRoomController {
  private final EquipmentRoomService service;

  @GetMapping
  public ResponseEntity<List<EquipmentRoom>> findAll() {
    return ResponseEntity.ok(service.findAll());
  }

  @GetMapping(path = { "/{id}" })
  public ResponseEntity<EquipmentRoom> findById(@PathVariable Long id) {
    Optional<EquipmentRoom> equipmentRoom = service.findById(id);
    return equipmentRoom.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.badRequest().build());
  }

  @PostMapping
  public ResponseEntity<EquipmentRoom> create(@RequestBody EquipmentRoom equipmentRoom) {
    return ResponseEntity.ok(service.save(equipmentRoom));
  }

  @PutMapping
  public ResponseEntity<EquipmentRoom> update(@RequestBody EquipmentRoom equipmentRoom) {
    if (!service.findById(equipmentRoom.getId()).isPresent()) {
      return ResponseEntity.badRequest().build();
    }
    return ResponseEntity.ok(service.save(equipmentRoom));
  }

  @DeleteMapping(path = { "/{id}" })
  public ResponseEntity<?> delete(@PathVariable Long id) {
    if (!service.findById(id).isPresent()) {
      return ResponseEntity.badRequest().build();
    }
    service.deleteById(id);
    return ResponseEntity.ok().build();
  }
}