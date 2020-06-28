package com.gym.lbdgym.service.lesson;

import com.gym.lbdgym.model.lesson.LessonAvailable;
import com.gym.lbdgym.repository.lesson.LessonAvailableRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class LessonAvailableService {

  private final LessonAvailableRepository repository;

  public List<LessonAvailable> findAll() {
    return repository.findAll();
  }

  public Optional<LessonAvailable> findById(Long id) {
    return repository.findById(id);
  }

  public LessonAvailable save(LessonAvailable lessonAvailable) {
    return repository.save(lessonAvailable);
  }

  public void deleteById(Long id) {
    repository.deleteById(id);
  }
}