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
@Table(indexes = { @Index(name = "associate_id_index", columnList = "associate_id"),
        @Index(name = "lessonAvailable_id_index", columnList = "lessonAvailable_id") })
public class Enrollment implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "associate_id", nullable = false)
    @JsonBackReference(value = "associate")
    private Associate associate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lessonAvailable_id", nullable = false)
    @JsonBackReference(value = "lessonAvailable")
    private LessonAvailable lessonAvailable;

}
