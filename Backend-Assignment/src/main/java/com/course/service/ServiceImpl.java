package com.course.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.course.entity.Course;
import com.course.repository.CourseRepo;

@Service
public class ServiceImpl {
	@Autowired
    private CourseRepo courseRepository;

    public Course createCourse(Course course) {
        return courseRepository.save(course);
    }

    public Course updateCourse(Course course) {
        if (courseRepository.existsById(course.getId())) {
            return courseRepository.save(course);
        }
        throw new RuntimeException("Course not found with ID: " + course.getId());
    }

    public Course getCourse(Long id) {
        return courseRepository.findById(id)
                                .orElseThrow(() -> new RuntimeException("Course not found with ID: " + id));
    }
}
