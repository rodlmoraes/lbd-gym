package com.gym.lbdgym.controller.room;

import java.util.Optional;

import com.gym.lbdgym.model.room.LessonRoom;
import com.gym.lbdgym.service.room.LessonRoomService;

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
@RequestMapping({ "/lessonRoom" })
@RequiredArgsConstructor
public class LessonRoomController {
  private final LessonRoomService service;

  @GetMapping(path = { "/{id}" })
  public ResponseEntity<LessonRoom> findById(@PathVariable Long id) {
    Optional<LessonRoom> lessonRoom = service.findById(id);
    if (!lessonRoom.isPresent()) {
      return ResponseEntity.badRequest().build();
    }
    return ResponseEntity.ok(lessonRoom.get());
  }

  @PostMapping
  public ResponseEntity<LessonRoom> create(@RequestBody LessonRoom lessonRoom) {
    return ResponseEntity.ok(service.save(lessonRoom));
  }

  @PutMapping(value = "/{id}")
  public ResponseEntity<LessonRoom> update(@PathVariable("id") Long id, @RequestBody LessonRoom LessonRoom) {
    if (!service.findById(id).isPresent()) {
      return ResponseEntity.badRequest().build();
    }
    return ResponseEntity.ok(service.save(LessonRoom));
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