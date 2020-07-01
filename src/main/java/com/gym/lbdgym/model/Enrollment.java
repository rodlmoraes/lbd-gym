package com.gym.lbdgym.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.gym.lbdgym.model.lesson.LessonAvailable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Enrollment implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "associate_id", nullable = false)
    @JsonBackReference(value = "associate")
    private Associate associate;

    @ManyToOne
    @JoinColumn(name = "lessonAvailable_id", nullable = false)
    @JsonBackReference(value = "lessonAvailable")
    private LessonAvailable lessonAvailable;

}
