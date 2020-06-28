package com.gym.lbdgym.controller;

import com.gym.lbdgym.model.Associate;
import com.gym.lbdgym.service.AssociateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping({ "/associate" })
@RequiredArgsConstructor
public class AssociateController {
  private final AssociateService service;

  @GetMapping(path = { "/{id}" })
  public ResponseEntity<Associate> findById(@PathVariable Long id) {
    Optional<Associate> associate = service.findById(id);
    return associate.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.badRequest().build());
  }

  @PostMapping
  public ResponseEntity<Associate> create(@RequestBody Associate associate) {
    return ResponseEntity.ok(service.save(associate));
  }

  @PutMapping(value = "/{id}")
  public ResponseEntity<Associate> update(@PathVariable Long id, @RequestBody Associate Associate) {
    if (!service.findById(id).isPresent()) {
      return ResponseEntity.badRequest().build();
    }
    return ResponseEntity.ok(service.save(Associate));
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