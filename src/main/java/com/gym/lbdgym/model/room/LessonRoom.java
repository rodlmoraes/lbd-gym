package com.gym.lbdgym.model.room;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import java.io.Serializable;

@Getter
@Setter
@Entity
public class LessonRoom extends Room implements Serializable {

    private String lesson;
    private int maxNumberAssociates;

    public LessonRoom(Long id, String location, int size, String lesson, int maxNumberAssociates) {
        super(id, location, size);
        this.lesson = lesson;
        this.maxNumberAssociates = maxNumberAssociates;
    }
}
