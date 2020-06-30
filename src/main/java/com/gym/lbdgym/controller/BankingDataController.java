package com.gym.lbdgym.controller;

import com.gym.lbdgym.model.BankingData;
import com.gym.lbdgym.service.BankingDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping({ "/bankingData" })
@RequiredArgsConstructor
public class BankingDataController {
  private final BankingDataService service;

  @GetMapping
  public ResponseEntity<List<BankingData>> findAll() {
    return ResponseEntity.ok(service.findAll());
  }

  @GetMapping(path = { "/{id}" })
  public ResponseEntity<BankingData> findById(@PathVariable Long id) {
    Optional<BankingData> bankingData = service.findById(id);
    return bankingData.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.badRequest().build());
  }

  @PostMapping
  public ResponseEntity<BankingData> create(@RequestBody BankingData bankingData) {
    return ResponseEntity.ok(service.save(bankingData));
  }

  @PutMapping
  public ResponseEntity<BankingData> update(@RequestBody BankingData bankingData) {
    if (!service.findById(bankingData.getId()).isPresent()) {
      return ResponseEntity.badRequest().build();
    }
    return ResponseEntity.ok(service.save(bankingData));
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