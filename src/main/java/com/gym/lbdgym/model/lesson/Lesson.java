package com.gym.lbdgym.model.lesson;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.gym.lbdgym.model.Monitor;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@Data
@Entity
public class Lesson implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id;
    private String name;

    @ManyToMany
    private List<Monitor> monitors;

}
