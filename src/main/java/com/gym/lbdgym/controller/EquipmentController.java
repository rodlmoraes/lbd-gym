package com.gym.lbdgym.controller;

import com.gym.lbdgym.model.Equipment;
import com.gym.lbdgym.service.EquipmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping({ "/equipment" })
@RequiredArgsConstructor
public class EquipmentController {

  private final EquipmentService service;

  @GetMapping
  public ResponseEntity<List<Equipment>> findAll() {
    return ResponseEntity.ok(service.findAll());
  }

  @GetMapping(path = { "/{id}" })
  public ResponseEntity<Equipment> findById(@PathVariable Long id) {
    Optional<Equipment> equipment = service.findById(id);
    return equipment.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.badRequest().build());
  }

  @PostMapping
  public ResponseEntity<Equipment> create(@RequestBody Equipment equipment) {
    return ResponseEntity.ok(service.save(equipment));
  }

  @PutMapping
  public ResponseEntity<Equipment> update(@RequestBody Equipment equipment) {
    if (!service.findById(equipment.getId()).isPresent()) {
      return ResponseEntity.badRequest().build();
    }
    return ResponseEntity.ok(service.save(equipment));
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