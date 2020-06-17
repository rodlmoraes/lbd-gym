package com.gym.lbdgym.controller;

import java.util.Optional;

import com.gym.lbdgym.model.Monitor;
import com.gym.lbdgym.service.MonitorService;

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
@RequestMapping({ "/monitor" })
@RequiredArgsConstructor
public class MonitorController {
  private final MonitorService service;

  @GetMapping(path = { "/{id}" })
  public ResponseEntity<Monitor> findById(@PathVariable Long id) {
    Optional<Monitor> monitor = service.findById(id);
    if (!monitor.isPresent()) {
      return ResponseEntity.badRequest().build();
    }
    return ResponseEntity.ok(monitor.get());
  }

  @PostMapping
  public ResponseEntity<Monitor> create(@RequestBody Monitor monitor) {
    return ResponseEntity.ok(service.save(monitor));
  }

  @PutMapping(value = "/{id}")
  public ResponseEntity<Monitor> update(@PathVariable("id") Long id, @RequestBody Monitor Monitor) {
    if (!service.findById(id).isPresent()) {
      return ResponseEntity.badRequest().build();
    }
    return ResponseEntity.ok(service.save(Monitor));
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