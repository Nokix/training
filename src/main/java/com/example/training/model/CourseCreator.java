package com.example.training.model;

import com.github.javafaker.Faker;

public class CourseCreator implements Creator<Course>{

    private final Faker faker = new Faker();

    @Override
    public Course create() {
        String name = faker.commerce().productName();
        return new Course().setName(name);
    }
}

