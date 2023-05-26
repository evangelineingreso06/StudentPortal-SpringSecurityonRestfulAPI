package com.springsecurityrestapi.controller;

import com.springsecurityrestapi.model.Course;
import com.springsecurityrestapi.model.Student;
import com.springsecurityrestapi.repository.StudentRepository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/students")
public class StudentController {
    private final StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository){
        this.studentRepository=studentRepository;
    }
    @PostMapping("/addStudent")
    public Student addStudent(@RequestBody Student course){
        return studentRepository.save(course);
    }

    @GetMapping("/getAllStudent")
    public List<Student> getAllStudent(){
        return studentRepository.findAll();
    }

    @GetMapping("/getStudentById/{id}")
    public Optional<Student> getStudentById(@PathVariable Long id){
        return studentRepository.findById(id);
    }

    @DeleteMapping("/deleteStudent/{id}")
    public void deleteStudent(@PathVariable Long id){
        studentRepository.deleteById(id);
    }

    @PutMapping("/updatedStudent/{id}")
    public Student updatedStudent(@PathVariable Long id, @RequestBody Student updatedStudent){
        Student student = studentRepository.findById(id).orElseThrow();
        student.setFirstName(updatedStudent.getFirstName());
        student.setLastName(updatedStudent.getLastName());
        return studentRepository.save(student);

    }

    @PostMapping("/{id}/enroll")
    public Student enroll(@PathVariable Long id, @RequestBody Course course){
        Student student = studentRepository.findById(id).orElseThrow();
        student.setCourse(course);
        return studentRepository.save(student);
    }

    @PostMapping("/{id}/drop")
    public Student drop(@PathVariable Long id, @RequestBody Course course){
        Student student = studentRepository.findById(id).orElseThrow();
        student.setCourse(null);
        return studentRepository.save(student);
    }
}