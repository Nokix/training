package com.example.training.model;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Student {
    @Id
    private Long id;

    @ManyToMany
    private Set<Course> likes;



    public Student() {
    }

    public Student(Long id) {
        this.id = id;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public boolean addLikes(Course... courses) {
        if (likes == null) likes = new HashSet<>();
        return Collections.addAll(likes, courses);
    }
}
