package com.springsecurityrestapi.service;

import com.springsecurityrestapi.model.Course;
import com.springsecurityrestapi.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;



    @Override
    public Course addCourse(Course course){
        return courseRepository.save(course);
    }


    public List<Course> getAllCourse(){
        return courseRepository.findAll();
    }


    public Optional<Course> getCourseById(Long id){
        return courseRepository.findById(id);
    }


    public void deleteCourse(Long id){
        courseRepository.deleteById(id);
    }

    public Course updatedCourse( Long id, Course updatedCourse){
        Course course = courseRepository.findById(id).orElseThrow();
        course.setName(updatedCourse.getName());
        return courseRepository.save(course);

    }
}
