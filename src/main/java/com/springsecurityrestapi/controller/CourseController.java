package com.springsecurityrestapi.controller;

import com.springsecurityrestapi.model.Course;
import com.springsecurityrestapi.repository.CourseRepository;
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
@RequestMapping("/courses")
public class CourseController {
    private final CourseRepository courseRepository;

    public CourseController(CourseRepository courseRepository){
        this.courseRepository = courseRepository;
    }

    @PostMapping("/addCourse")
    public Course addCourse(@RequestBody Course course){
        return courseRepository.save(course);
    }

    @GetMapping("/getAllCourse")
    public List<Course> getAllCourse(){
        return courseRepository.findAll();
    }

    @GetMapping("/getCourseById/{id}")
    public Optional<Course> getCourseById(@PathVariable Long id){
        return courseRepository.findById(id);
    }

    @DeleteMapping("/deleteCourse/{id}")
    public void deleteCourse(@PathVariable Long id){
        courseRepository.deleteById(id);
    }

    @PutMapping("/updatedCourse/{id}")
    public Course updatedCourse(@PathVariable Long id, @RequestBody Course updatedCourse){
        Course course = courseRepository.findById(id).orElseThrow();
        course.setName(updatedCourse.getName());
        course.setDescription(updatedCourse.getDescription());
        return courseRepository.save(course);

    }
}
