package com.gym.lbdgym.model.lesson;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.gym.lbdgym.model.Associate;
import com.gym.lbdgym.model.Monitor;
import com.gym.lbdgym.model.room.LessonRoom;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
public class LessonAvailable extends Lesson {

    private static final long serialVersionUID = 1L;

    private String description;
    private LocalDateTime dateTime;

    @ManyToOne
    @JsonBackReference(value = "monitor")
    private Monitor monitor;

    @ManyToMany
    private List<Associate> associate;

    @ManyToOne
    @JsonBackReference(value = "lessonRoom")
    private LessonRoom lessonRoom;

    public LessonAvailable(Long id, String name, List<Monitor> monitors, String description, LocalDateTime dateTime) {
        super(id, name, monitors);
        this.description = description;
        this.dateTime = dateTime;
    }

}
