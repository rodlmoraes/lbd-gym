package com.gym.lbdgym.model.lesson;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class LessonAvailable extends Lesson{

    private String description;
    private LocalDateTime dateTime;
    public LessonAvailable(Long id, String name, String description, LocalDateTime dateTime) {
        super(id, name);
        this.description = description;
        this.dateTime = dateTime;
    }

}
