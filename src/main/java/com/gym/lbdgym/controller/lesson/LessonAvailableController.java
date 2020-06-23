package com.gym.lbdgym.controller.lesson;

import java.util.Optional;

import com.gym.lbdgym.model.lesson.LessonAvailable;
import com.gym.lbdgym.service.lesson.LessonAvailableService;

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
@RequestMapping({ "/lessonAvailable" })
@RequiredArgsConstructor
public class LessonAvailableController {
  private final LessonAvailableService service;

  @GetMapping(path = { "/{id}" })
  public ResponseEntity<LessonAvailable> findById(@PathVariable Long id) {
    Optional<LessonAvailable> lessonAvailable = service.findById(id);
    return lessonAvailable.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.badRequest().build());
  }

  @PostMapping
  public ResponseEntity<LessonAvailable> create(@RequestBody LessonAvailable lessonAvailable) {
    return ResponseEntity.ok(service.save(lessonAvailable));
  }

  @PutMapping(value = "/{id}")
  public ResponseEntity<LessonAvailable> update(@PathVariable("id") Long id,
      @RequestBody LessonAvailable LessonAvailable) {
    if (!service.findById(id).isPresent()) {
      return ResponseEntity.badRequest().build();
    }
    return ResponseEntity.ok(service.save(LessonAvailable));
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