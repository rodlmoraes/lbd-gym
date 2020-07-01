package com.gym.lbdgym.model.lesson;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.gym.lbdgym.model.CanTeach;
import com.gym.lbdgym.model.Enrollment;
import com.gym.lbdgym.model.Monitor;
import com.gym.lbdgym.model.room.LessonRoom;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
    @JoinColumn(name = "monitor_id", nullable = false)
    @JsonBackReference(value = "monitor")
    private Monitor monitor;

    @OneToMany(mappedBy = "lessonAvailable")
    @JsonManagedReference(value = "lessonAvailable")
    private List<Enrollment> enrollments;

    @ManyToOne
    @JoinColumn(name = "lessonRoom_id", nullable = false)
    @JsonBackReference(value = "lessonRoom")
    private LessonRoom lessonRoom;

    public LessonAvailable(Long id, String name, List<CanTeach> canTeach, String description, LocalDateTime dateTime) {
        super(id, name, canTeach);
        this.description = description;
        this.dateTime = dateTime;
    }

    public LessonAvailable() {

    }
}
