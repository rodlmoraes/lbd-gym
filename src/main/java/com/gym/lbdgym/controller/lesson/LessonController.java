package com.gym.lbdgym.controller.lesson;

import com.gym.lbdgym.model.lesson.Lesson;
import com.gym.lbdgym.service.lesson.LessonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping({ "/lesson" })
@RequiredArgsConstructor
public class LessonController {
  private final LessonService service;

  @GetMapping(path = { "/{id}" })
  public ResponseEntity<Lesson> findById(@PathVariable Long id) {
    Optional<Lesson> lesson = service.findById(id);
    return lesson.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.badRequest().build());
  }

  @PostMapping
  public ResponseEntity<Lesson> create(@RequestBody Lesson lesson) {
    return ResponseEntity.ok(service.save(lesson));
  }

  @PutMapping(value = "/{id}")
  public ResponseEntity<Lesson> update(@PathVariable Long id, @RequestBody Lesson Lesson) {
    if (!service.findById(id).isPresent()) {
      return ResponseEntity.badRequest().build();
    }
    return ResponseEntity.ok(service.save(Lesson));
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