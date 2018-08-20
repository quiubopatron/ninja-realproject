package com.udemy.backendninja.service;

import com.udemy.backendninja.entity.Course;

import java.util.List;

public interface CourseService {

    public abstract List<Course> listAllCourses();
    public abstract Course addCourse(Course course);
    public abstract void removeCourse(Long id);
    public abstract Course updateCourse(Course course);



}
