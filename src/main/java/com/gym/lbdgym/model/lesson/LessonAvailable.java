package com.gym.lbdgym.model.lesson;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.gym.lbdgym.model.Monitor;
import com.gym.lbdgym.model.MonitorLessons;
import com.gym.lbdgym.model.StudentsInClass;
import com.gym.lbdgym.model.room.LessonRoom;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
public class LessonAvailable extends Lesson {

    private String description;
    private LocalDateTime dateTime;

    @ManyToOne
    @JsonBackReference(value = "monitor")
    private Monitor monitor;

    @OneToMany
    @JsonManagedReference(value = "lessonAvailable")
    private List<StudentsInClass> studentsInClasses;

    @ManyToOne
    @JsonBackReference(value = "lessonRoom")
    private LessonRoom lessonRoom;

    public LessonAvailable(Long id, String name, List<MonitorLessons> monitorLessons, String description, LocalDateTime dateTime) {
        super(id, name, monitorLessons);
        this.description = description;
        this.dateTime = dateTime;
    }

}
