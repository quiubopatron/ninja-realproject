package com.udemy.backendninja.service;

import com.udemy.backendninja.entity.Course;
import com.udemy.backendninja.repository.CourseJPARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("CourseServiceImp")
public class CourseServiceImp implements CourseService {

    @Autowired
    @Qualifier("courseJPARepository")
    private CourseJPARepository courseJPARepository;


    @Override
    public List<Course> listAllCourses() {
        return courseJPARepository.findAll();
    }

    @Override
    public Course addCourse(Course course) {
        return courseJPARepository.save(course);
    }

    @Override
    public void removeCourse(Long id) {
         courseJPARepository.deleteById(id);
    }

    @Override
    public Course updateCourse(Course course) {
        return courseJPARepository.save(course);
    }
}
