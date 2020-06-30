package com.gym.lbdgym.controller.lesson;

import com.gym.lbdgym.model.lesson.Lesson;
import com.gym.lbdgym.service.lesson.LessonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping({ "/lesson" })
@RequiredArgsConstructor
public class LessonController {
  private final LessonService service;

  @GetMapping
  public ResponseEntity<List<Lesson>> findAll() {
    return ResponseEntity.ok(service.findAll());
  }

  @GetMapping(path = { "/{id}" })
  public ResponseEntity<Lesson> findById(@PathVariable Long id) {
    Optional<Lesson> lesson = service.findById(id);
    return lesson.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.badRequest().build());
  }

  @PostMapping
  public ResponseEntity<Lesson> create(@RequestBody Lesson lesson) {
    return ResponseEntity.ok(service.save(lesson));
  }

  @PutMapping
  public ResponseEntity<Lesson> update(@RequestBody Lesson lesson) {
    if (!service.findById(lesson.getId()).isPresent()) {
      return ResponseEntity.badRequest().build();
    }
    return ResponseEntity.ok(service.save(lesson));
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