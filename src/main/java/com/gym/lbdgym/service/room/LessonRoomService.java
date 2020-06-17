package com.gym.lbdgym.service.room;

import java.util.List;
import java.util.Optional;

import com.gym.lbdgym.model.room.LessonRoom;
import com.gym.lbdgym.repository.room.LessonRoomRepository;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class LessonRoomService {

  private final LessonRoomRepository repository;

  public List<LessonRoom> findAll() {
    return repository.findAll();
  }

  public Optional<LessonRoom> findById(Long id) {
    return repository.findById(id);
  }

  public LessonRoom save(LessonRoom lessonRoom) {
    return repository.save(lessonRoom);
  }

  public void deleteById(Long id) {
    repository.deleteById(id);
  }
}