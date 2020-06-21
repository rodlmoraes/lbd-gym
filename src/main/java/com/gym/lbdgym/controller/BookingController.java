package com.gym.lbdgym.controller;

import java.util.Optional;

import com.gym.lbdgym.model.Booking;
import com.gym.lbdgym.service.BookingService;

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
@RequestMapping({ "/booking" })
@RequiredArgsConstructor
public class BookingController {
  private final BookingService service;

  @GetMapping(path = { "/{id}" })
  public ResponseEntity<Booking> findById(@PathVariable Long id) {
    Optional<Booking> booking = service.findById(id);
    if (!booking.isPresent()) {
      return ResponseEntity.badRequest().build();
    }
    return ResponseEntity.ok(booking.get());
  }

  @PostMapping
  public ResponseEntity<Booking> create(@RequestBody Booking booking) {
    return ResponseEntity.ok(service.save(booking));
  }

  @PutMapping(value = "/{id}")
  public ResponseEntity<Booking> update(@PathVariable("id") Long id, @RequestBody Booking Booking) {
    if (!service.findById(id).isPresent()) {
      return ResponseEntity.badRequest().build();
    }
    return ResponseEntity.ok(service.save(Booking));
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