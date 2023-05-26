package com.springsecurityrestapi.repository;

import com.springsecurityrestapi.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
