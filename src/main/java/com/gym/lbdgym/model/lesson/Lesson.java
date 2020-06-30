package com.gym.lbdgym.model.lesson;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.gym.lbdgym.model.Monitor;
import com.gym.lbdgym.model.MonitorLessons;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Lesson implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id;
    private String name;

    @OneToMany
    @JsonManagedReference(value = "monitorLessons")
    public List<MonitorLessons> monitorLessons;

}
