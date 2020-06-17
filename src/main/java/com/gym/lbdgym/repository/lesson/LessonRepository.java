package com.gym.lbdgym.repository.lesson;

import com.gym.lbdgym.model.lesson.Lesson;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LessonRepository extends JpaRepository<Lesson, Long> {

}