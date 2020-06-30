package com.gym.lbdgym.controller;

import com.gym.lbdgym.model.Booking;
import com.gym.lbdgym.model.room.SquashRoom;
import com.gym.lbdgym.service.AssociateService;
import com.gym.lbdgym.service.BookingService;
import com.gym.lbdgym.service.room.SquashRoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping({ "/booking" })
@RequiredArgsConstructor
public class BookingController {

  private final BookingService service;
  private final AssociateService associateService;
  private final SquashRoomService squashRoomService;

  @GetMapping(path = { "/{id}" })
  public ResponseEntity<Booking> findById(@PathVariable Long id) {
    Optional<Booking> booking = service.findById(id);
    return booking.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.badRequest().build());
  }

  @PostMapping
  public ResponseEntity<Boolean> save(@RequestBody Booking booking) {
    SquashRoom squashRoom = booking.getSquashRoom();

    if (!squashRoomService.isAvailable(squashRoom.getId(), booking.getStartDate(), booking.getEndDate())) {
      return ResponseEntity.ok(false);
    }

    return ResponseEntity.ok(service.save(booking) != null);
  }

  @PutMapping
  public ResponseEntity<Booking> update(@RequestBody Booking booking) {
    if (!service.findById(booking.getId()).isPresent()) {
      return ResponseEntity.badRequest().build();
    }
    return ResponseEntity.ok(service.save(booking));
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
  public ResponseEntity<List<SquashRoom>> findAssociateSquashRooms(@PathVariable Long associateId) {
    if (!associateService.findById(associateId).isPresent()) {
      return ResponseEntity.badRequest().build();
    }
    return ResponseEntity.ok(service.associateSquashRooms(associateId));
  }
}