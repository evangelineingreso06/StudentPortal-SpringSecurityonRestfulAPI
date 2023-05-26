package com.springsecurityrestapi.repository;

import com.springsecurityrestapi.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
