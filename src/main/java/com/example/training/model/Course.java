package com.example.training.model;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Entity
@GenericGenerator(name = "custom_id_gen", strategy = "com.example.training.model.CourseIdGenerator")
public class Course {

    @Id
    @GeneratedValue(generator = "custom_id_gen")
    private String id;

    // TODO: Warum genau brauche ich hier das Eager?
    @ManyToMany(mappedBy = "likes", fetch = FetchType.EAGER)
    private Set<Student> likedBy;

    private String name;

    // TODO: von wem wird der gebraucht? Hibernate oder Spring?
    public Course() {
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Course setName(String name) {
        this.name = name;
        return this;
    }

    public boolean addLikes(Student... students) {
        if (likedBy == null) likedBy = new HashSet<>();
        return Collections.addAll(likedBy, students);
    }
}
