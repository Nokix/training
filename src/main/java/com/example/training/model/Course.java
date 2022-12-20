package com.example.training.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Course {

    @Id
    private Long id;

    @ManyToMany
    private Set<Student> likes;

    // von wem wird der gebraucht? Hibernate oder Spring?
    public Course() {

    }

    public Course(Long id) {
        this.id = id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public boolean addLikes(Student... students) {
        if (likes == null) likes = new HashSet<>();
        return Collections.addAll(likes, students);
    }
}
