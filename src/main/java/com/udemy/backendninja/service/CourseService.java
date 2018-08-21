package com.udemy.backendninja.service;

import com.udemy.backendninja.entity.Course;
import com.udemy.backendninja.model.CourseModel;

import java.util.List;

public interface CourseService {

    public abstract List<CourseModel> listAllCourses();
    public abstract CourseModel addCourse(Course course);
    public abstract void removeCourse(Long id);
    public abstract CourseModel updateCourse(Course course);



}
