package com.springsecurityrestapi.service;

import com.springsecurityrestapi.model.Course;

import java.util.List;
import java.util.Optional;

public interface CourseService {
    Course addCourse(Course course);
    List<Course> getAllCourse();
    Optional<Course> getCourseById(Long id);
    void deleteCourse(Long id);
    Course updatedCourse( Long id, Course updatedCourse);
}
