package com.springsecurityrestapi.service;

import com.springsecurityrestapi.model.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    Student addStudent(Student student);
    List<Student> getAllStudent();
    Optional<Student> getStudentById(Long id);
    void deleteStudent(Long id);
    Student updatedStudent( Long id, Student updatedStudent);
}
