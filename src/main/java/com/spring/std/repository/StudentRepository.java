package com.spring.std.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.std.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

}
