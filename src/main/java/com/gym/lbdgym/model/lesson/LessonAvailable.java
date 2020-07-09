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
import javax.persistence.FetchType;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
@Table(indexes = { @Index(name = "monitor_id_index", columnList = "monitor_id"),
        @Index(name = "lessonRoom_id_index", columnList = "lessonRoom_id"),
        @Index(name = "dateTime_index", columnList = "dateTime") })
public class LessonAvailable extends Lesson {

    private static final long serialVersionUID = 1L;

    private String description;
    private LocalDateTime dateTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "monitor_id", nullable = false)
    @JsonBackReference(value = "monitor")
    private Monitor monitor;

    @OneToMany(mappedBy = "lessonAvailable", fetch = FetchType.LAZY)
    @JsonManagedReference(value = "lessonAvailable")
    private List<Enrollment> enrollments;

    @ManyToOne(fetch = FetchType.LAZY)
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
