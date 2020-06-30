package com.gym.lbdgym.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.gym.lbdgym.model.lesson.Lesson;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class MonitorLessons {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JsonBackReference(value = "monitor")
    private Monitor monitor;

    @ManyToOne
    @JsonBackReference(value = "lesson")
    private Lesson lesson;
}
