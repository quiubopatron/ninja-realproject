package com.udemy.backendninja.converter;

import com.udemy.backendninja.entity.Course;
import com.udemy.backendninja.model.CourseModel;
import org.springframework.stereotype.Component;

@Component("courseConverter")
public class CourseConverter {

    // Transforma una entity a un model
    public CourseModel entityToModel(Course course) {

        CourseModel courseModel = new CourseModel();
        courseModel.setName(course.getName());
        courseModel.setDescription(course.getDescription());
        courseModel.setPrice(course.getPrice());
        courseModel.setPrice(course.getHours());

        return courseModel;
    }


    // Transforma de un model a un entity
    public Course modelToEntity(CourseModel courseModel) {

        Course course = new Course();
        course.setName(courseModel.getName());
        course.setDescription(courseModel.getDescription());
        course.setPrice(courseModel.getPrice());
        course.setHours(courseModel.getHours());

        return course;
    }
}
