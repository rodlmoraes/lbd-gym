package com.gym.lbdgym.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.gym.lbdgym.model.lesson.Lesson;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class CanTeach implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "monitor_id",nullable = false)
    @JsonBackReference(value = "monitor")
    private Monitor monitor;

    @ManyToOne
    @JoinColumn(name = "lesson_id", nullable = false)
    @JsonBackReference(value = "lesson")
    private Lesson lesson;
}
