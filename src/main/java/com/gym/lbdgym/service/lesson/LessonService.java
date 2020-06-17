package com.gym.lbdgym.service.lesson;

import java.util.List;
import java.util.Optional;

import com.gym.lbdgym.model.lesson.Lesson;
import com.gym.lbdgym.repository.lesson.LessonRepository;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class LessonService {

  private final LessonRepository repository;

  public List<Lesson> findAll() {
    return repository.findAll();
  }

  public Optional<Lesson> findById(Long id) {
    return repository.findById(id);
  }

  public Lesson save(Lesson lesson) {
    return repository.save(lesson);
  }

  public void deleteById(Long id) {
    repository.deleteById(id);
  }
}