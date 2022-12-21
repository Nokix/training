package com.example.training.model;

import com.github.javafaker.Faker;

public class StudentCreator implements Creator<Student> {
    private final Faker faker = new Faker();

    @Override
    public Student create() {
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String email = firstName.toLowerCase()
                + "." + lastName.toLowerCase()
                + "@" + faker.internet().domainName();
        return new Student()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email);
    }

}
