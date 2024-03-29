package com.course.repository;

import org.springframework.data.repository.CrudRepository;

import com.course.entity.Course;

public interface CourseRepo extends CrudRepository<Course, Long>{

}
