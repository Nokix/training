package com.example.training;

import com.example.training.model.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;

@SpringBootApplication
public class TrainingApplication {

    public static void main(String[] args) {
        SpringApplication.run(TrainingApplication.class, args);
    }

    //@Bean
    CommandLineRunner start(StudentRepository studentRepository,
                            CourseRepository courseRepository) {
        return args -> {
            Student s1 = new Student();
            Student s2 = new Student();
            Course c1 = new Course();
            Course c2 = new Course();
            s1.addLikes(c1, c2);
            studentRepository.save(s1);
            s2 = studentRepository.save(s2);
//            courseRepository.save(c1);
//            courseRepository.save(c2);
            c2 = courseRepository.findById("C1").get();
            c2.addLikes(s2);
            courseRepository.save(c2);

        };
    }

    @Bean
    CommandLineRunner start2(StudentRepository studentRepository,
                            CourseRepository courseRepository) {
        // Erstelle Students und Kurse und zufällige Likes
        return args -> {
            StudentCreator studentCreator = new StudentCreator();
            Collection<Student> students = studentCreator.createMultiple(20);
            Collection<Course> courses = new CourseCreator().createMultiple(5);
            students.forEach(student -> {
                ArrayList<Course> c = new ArrayList<>(courses);
                Collections.shuffle(c);
                int r = new Random().nextInt(0, c.size());
                c.subList(0,r).forEach(student::addLikes);
            });
            studentRepository.saveAll(students);

        };
    }

}
