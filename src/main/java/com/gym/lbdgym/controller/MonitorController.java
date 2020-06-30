package com.gym.lbdgym.controller;

import com.gym.lbdgym.model.Monitor;
import com.gym.lbdgym.service.MonitorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping({ "/monitor" })
@RequiredArgsConstructor
public class MonitorController {
  private final MonitorService service;

  @GetMapping(path = { "/{id}" })
  public ResponseEntity<Monitor> findById(@PathVariable Long id) {
    Optional<Monitor> monitor = service.findById(id);
    return monitor.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.badRequest().build());
  }

  @PostMapping
  public ResponseEntity<Monitor> create(@RequestBody Monitor monitor) {
    return ResponseEntity.ok(service.save(monitor));
  }

  @PutMapping
  public ResponseEntity<Monitor> update(@RequestBody Monitor monitor) {
    if (!service.findById(monitor.getId()).isPresent()) {
      return ResponseEntity.badRequest().build();
    }
    return ResponseEntity.ok(service.save(monitor));
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