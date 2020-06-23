package com.gym.lbdgym.controller;

import java.net.PortUnreachableException;
import java.util.List;
import java.util.Optional;

import com.gym.lbdgym.model.Booking;
import com.gym.lbdgym.model.room.SquashRoom;
import com.gym.lbdgym.repository.AssociateRepository;
import com.gym.lbdgym.service.AssociateService;
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
  private final AssociateService associateService;

  @GetMapping(path = { "/{id}" })
  public ResponseEntity<Booking> findById(@PathVariable Long id) {
    Optional<Booking> booking = service.findById(id);
    return booking.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.badRequest().build());
  }

  @PostMapping
  public ResponseEntity<Booking> bookRoom (@RequestBody Booking booking) {
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

  @GetMapping(path = { "/associateSquashRooms/{associateId}" })
  public ResponseEntity<List<SquashRoom>> findAssociateSquashRooms(@PathVariable Long associateId){
    if (!associateService.findById(associateId).isPresent()) {
      return ResponseEntity.badRequest().build();
    }
    return ResponseEntity.ok(service.associateSquashRooms(associateId));
  }
}