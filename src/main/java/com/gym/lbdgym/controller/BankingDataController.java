package com.gym.lbdgym.controller;

import java.util.Optional;

import com.gym.lbdgym.model.BankingData;
import com.gym.lbdgym.service.BankingDataService;

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
@RequestMapping({ "/bankingData" })
@RequiredArgsConstructor
public class BankingDataController {
  private final BankingDataService service;

  @GetMapping(path = { "/{id}" })
  public ResponseEntity<BankingData> findById(@PathVariable Long id) {
    Optional<BankingData> bankingData = service.findById(id);
    return bankingData.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.badRequest().build());
  }

  @PostMapping
  public ResponseEntity<BankingData> create(@RequestBody BankingData bankingData) {
    return ResponseEntity.ok(service.save(bankingData));
  }

  @PutMapping(value = "/{id}")
  public ResponseEntity<BankingData> update(@PathVariable("id") Long id, @RequestBody BankingData BankingData) {
    if (!service.findById(id).isPresent()) {
      return ResponseEntity.badRequest().build();
    }
    return ResponseEntity.ok(service.save(BankingData));
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