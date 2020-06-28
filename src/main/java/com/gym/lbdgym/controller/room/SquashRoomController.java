package com.gym.lbdgym.controller.room;

import com.gym.lbdgym.model.room.SquashRoom;
import com.gym.lbdgym.service.room.SquashRoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Optional;

@RestController
@RequestMapping({ "/squashRoom" })
@RequiredArgsConstructor
public class SquashRoomController {
  private final SquashRoomService service;

  @GetMapping(path = { "/{id}" })
  public ResponseEntity<SquashRoom> findById(@PathVariable Long id) {
    Optional<SquashRoom> squashRoom = service.findById(id);
    return squashRoom.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.badRequest().build());
  }

  @PostMapping
  public ResponseEntity<SquashRoom> create(@RequestBody SquashRoom squashRoom) {
    return ResponseEntity.ok(service.save(squashRoom));
  }

  @PutMapping(value = "/{id}")
  public ResponseEntity<SquashRoom> update(@PathVariable Long id, @RequestBody SquashRoom SquashRoom) {
    if (!service.findById(id).isPresent()) {
      return ResponseEntity.badRequest().build();
    }
    return ResponseEntity.ok(service.save(SquashRoom));
  }

  @DeleteMapping(path = { "/{id}" })
  public ResponseEntity<?> delete(@PathVariable Long id) {
    if (!service.findById(id).isPresent()) {
      return ResponseEntity.badRequest().build();
    }
    service.deleteById(id);
    return ResponseEntity.ok().build();
  }

  @PostMapping(path = { "/available" })
  public ResponseEntity<Boolean> isAvailable(@RequestBody Long id, @RequestBody LocalDateTime startDate,
      @RequestBody LocalDateTime endDate) {
    if (!service.findById(id).isPresent()) {
      return ResponseEntity.badRequest().build();
    }

    return ResponseEntity.ok(service.isAvailable(id, startDate, endDate));
  }
}