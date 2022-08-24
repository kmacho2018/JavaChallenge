package com.exercise.javaChallenge.dao.repository;

import com.exercise.javaChallenge.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
