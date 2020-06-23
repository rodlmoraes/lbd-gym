package com.gym.lbdgym.controller;

import java.util.Optional;

import com.gym.lbdgym.model.Associate;
import com.gym.lbdgym.service.AssociateService;

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
  public ResponseEntity<Associate> update(@PathVariable("id") Long id, @RequestBody Associate Associate) {
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