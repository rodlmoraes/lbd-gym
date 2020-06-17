package com.gym.lbdgym.model.lesson;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.gym.lbdgym.model.Associate;
import com.gym.lbdgym.model.Monitor;
import com.gym.lbdgym.model.room.LessonRoom;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
public class LessonAvailable extends Lesson {

    private static final long serialVersionUID = 1L;

    private String description;
    private LocalDateTime dateTime;
    @OneToOne
    @JsonManagedReference(value = "lessonAvailable")
    private Monitor monitor;
    @OneToMany
    @JsonManagedReference(value = "associate")
    private List<Associate> associate;
    @OneToOne
    @JsonBackReference(value = "lessonRoom")
    private LessonRoom lessonRoom;

    public LessonAvailable(Long id, String name, List<Monitor> canTeach, String description, LocalDateTime dateTime) {
        super(id, name, canTeach);
        this.description = description;
        this.dateTime = dateTime;
    }

}
