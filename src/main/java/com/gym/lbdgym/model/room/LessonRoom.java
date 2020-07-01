package com.gym.lbdgym.model.room;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.gym.lbdgym.model.lesson.LessonAvailable;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Getter
@Setter
@Entity
public class LessonRoom extends Room {

    private static final long serialVersionUID = 1L;

    private int maxNumberAssociates;

    @OneToMany(mappedBy = "lessonRoom")
    @JsonManagedReference(value = "lessonRoom")
    private List<LessonAvailable> lessonAvailable;

    public LessonRoom(Long id, String location, int size, String lesson, int maxNumberAssociates) {
        super(id, location, size);
        this.maxNumberAssociates = maxNumberAssociates;
    }

    public LessonRoom() {

    }
}
