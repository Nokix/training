package com.example.training;

import com.example.training.model.Course;
import com.example.training.model.CourseRepository;
import com.example.training.model.Student;
import com.example.training.model.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TrainingApplication {

    public static void main(String[] args) {
        SpringApplication.run(TrainingApplication.class, args);
    }

    @Bean
    CommandLineRunner start(StudentRepository studentRepository,
                            CourseRepository courseRepository) {
        return args -> {
            Student s1 = new Student(1L);
            Student s2 = new Student(2L);
            Course c1 = new Course(1L);
            Course c2 = new Course(2L);
            studentRepository.save(s1);
            studentRepository.save(s2);
            courseRepository.save(c1);
            courseRepository.save(c2);
            c2.addLikes(s1);
            s1.addLikes(c1, c2);
            courseRepository.save(c2);

        };
    }

}
