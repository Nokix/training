package com.example.training.model;

import com.github.javafaker.Faker;

public class BookCreator implements Creator<Book>{
    private Faker faker = new Faker();

    @Override
    public Book create() {
        return new Book(faker.book().title());
    }
}
