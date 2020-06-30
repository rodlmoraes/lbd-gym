package com.gym.lbdgym.controller.lesson;

import com.gym.lbdgym.model.lesson.LessonAvailable;
import com.gym.lbdgym.service.lesson.LessonAvailableService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping({ "/lessonAvailable" })
@RequiredArgsConstructor
public class LessonAvailableController {
  private final LessonAvailableService service;

  @GetMapping
  public ResponseEntity<List<LessonAvailable>> findAll() {
    return ResponseEntity.ok(service.findAll());
  }

  @GetMapping(path = { "/{id}" })
  public ResponseEntity<LessonAvailable> findById(@PathVariable Long id) {
    Optional<LessonAvailable> lessonAvailable = service.findById(id);
    return lessonAvailable.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.badRequest().build());
  }

  @PostMapping
  public ResponseEntity<LessonAvailable> create(@RequestBody LessonAvailable lessonAvailable) {
    return ResponseEntity.ok(service.save(lessonAvailable));
  }

  @PutMapping
  public ResponseEntity<LessonAvailable> update(@RequestBody LessonAvailable lessonAvailable) {
    if (!service.findById(lessonAvailable.getId()).isPresent()) {
      return ResponseEntity.badRequest().build();
    }
    return ResponseEntity.ok(service.save(lessonAvailable));
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