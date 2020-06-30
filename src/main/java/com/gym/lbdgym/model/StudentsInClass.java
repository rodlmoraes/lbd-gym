package com.gym.lbdgym.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.gym.lbdgym.model.lesson.LessonAvailable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class StudentsInClass implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JsonBackReference(value = "associate")
    private Associate associate;

    @ManyToOne
    @JsonBackReference(value = "lessonAvailable")
    private LessonAvailable lessonAvailable;

}
