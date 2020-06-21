package com.gym.lbdgym.controller.room;

import java.util.Optional;

import com.gym.lbdgym.model.room.EquipmentRoom;
import com.gym.lbdgym.service.room.EquipmentRoomService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping({ "/equipmentRoom" })
@RequiredArgsConstructor
public class EquipmentRoomController {
  private final EquipmentRoomService service;

  @GetMapping(path = { "/{id}" })
  public ResponseEntity<EquipmentRoom> findById(@PathVariable Long id) {
    Optional<EquipmentRoom> equipmentRoom = service.findById(id);
    if (!equipmentRoom.isPresent()) {
      return ResponseEntity.badRequest().build();
    }
    return ResponseEntity.ok(equipmentRoom.get());
  }

  @PostMapping
  public ResponseEntity<EquipmentRoom> create(@RequestBody EquipmentRoom equipmentRoom) {
    return ResponseEntity.ok(service.save(equipmentRoom));
  }

  @PutMapping(value = "/{id}")
  public ResponseEntity<EquipmentRoom> update(@PathVariable("id") Long id, @RequestBody EquipmentRoom EquipmentRoom) {
    if (!service.findById(id).isPresent()) {
      return ResponseEntity.badRequest().build();
    }
    return ResponseEntity.ok(service.save(EquipmentRoom));
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