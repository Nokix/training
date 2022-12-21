package com.example.training.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {
    // Alternativ:
    // @Query("select s from Student s where s.firstName = ?1 or s.lastName = ?1")
    @Query(value = "select s from Student s where s.firstName = :name or s.lastName = :name")
    Optional<Student> findStudentByFirstNameOrLastName(@Param("name") String name);
}
