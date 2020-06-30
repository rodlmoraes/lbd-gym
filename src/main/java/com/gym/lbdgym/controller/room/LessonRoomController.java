package com.gym.lbdgym.controller.room;

import com.gym.lbdgym.model.room.LessonRoom;
import com.gym.lbdgym.service.room.LessonRoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping({ "/lessonRoom" })
@RequiredArgsConstructor
public class LessonRoomController {
  private final LessonRoomService service;

  @GetMapping
  public ResponseEntity<List<LessonRoom>> findAll() {
    return ResponseEntity.ok(service.findAll());
  }

  @GetMapping(path = { "/{id}" })
  public ResponseEntity<LessonRoom> findById(@PathVariable Long id) {
    Optional<LessonRoom> lessonRoom = service.findById(id);
    return lessonRoom.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.badRequest().build());
  }

  @PostMapping
  public ResponseEntity<LessonRoom> create(@RequestBody LessonRoom lessonRoom) {
    return ResponseEntity.ok(service.save(lessonRoom));
  }

  @PutMapping
  public ResponseEntity<LessonRoom> update(@RequestBody LessonRoom lessonRoom) {
    if (!service.findById(lessonRoom.getId()).isPresent()) {
      return ResponseEntity.badRequest().build();
    }
    return ResponseEntity.ok(service.save(lessonRoom));
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