package com.gym.lbdgym.model.lesson;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.gym.lbdgym.model.CanTeach;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(indexes = { @Index(name = "name_index", columnList = "name") })
public class Lesson implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id;
    private String name;

    @OneToMany(mappedBy = "lesson", fetch = FetchType.LAZY)
    @JsonManagedReference(value = "lesson")
    public List<CanTeach> canTeach;

}
