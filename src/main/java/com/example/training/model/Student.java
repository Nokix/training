package com.example.training.model;

import jakarta.persistence.*;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@SequenceGenerator(name = "globalId", sequenceName = "glob", allocationSize = 33, initialValue = 0)
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "globalId")
    private Long id;

    //TODO: was bedeuten die CascadeTypes GANAU?
    //TODO: warum wird hier merge gebraucht bzw. warum wird ein Select durchgeführt?
    //            Student s1 = new Student(1L);
    //            Student s2 = new Student(2L);
    //            Course c1 = new Course(1L);
    //            Course c2 = new Course(2L);
    //            s1.addLikes(c1, c2);
    //            studentRepository.save(s1);
    //            studentRepository.save(s2);
    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(name = "likes")
    private Set<Course> likes;

    private String firstName;
    private String lastName;
    private String email;

    @OneToMany(orphanRemoval = true)
    @JoinColumn(name = "student_id")
    private Set<Book> books = new LinkedHashSet<>();

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    public Student() {
    }

    public Long getId() {
        return id;
    }

    public boolean addLikes(Course... courses) {
        if (likes == null) likes = new HashSet<>();
        return Collections.addAll(likes, courses);
    }

    public String getFirstName() {
        return firstName;
    }

    public Student setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public Student setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Student setEmail(String email) {
        this.email = email;
        return this;
    }


}
