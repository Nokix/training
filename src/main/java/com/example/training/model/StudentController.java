package com.example.training.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(path = "/students")
public class StudentController {
    // TODO: warum ist das hier nicht empfohlen?
    @Autowired
    private StudentRepository studentRepository;

    @GetMapping
    public Iterable<Student> getAll() {
        return studentRepository.findAll();
    }

    @GetMapping(path = "/{name}")
    public Optional<Student> getByName(@PathVariable String name) {
        return studentRepository.findStudentByFirstNameOrLastName(name);
    }
}
