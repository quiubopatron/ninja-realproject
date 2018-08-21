package com.udemy.backendninja.service;

import com.udemy.backendninja.converter.CourseConverter;
import com.udemy.backendninja.entity.Course;
import com.udemy.backendninja.model.CourseModel;
import com.udemy.backendninja.repository.CourseJPARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service("CourseServiceImp")
public class CourseServiceImp implements CourseService {

    @Autowired
    @Qualifier("courseJPARepository")
    private CourseJPARepository courseJPARepository;

    @Autowired
    @Qualifier("courseConverter")
    private CourseConverter courseConverter;



    @Override
    public List<CourseModel> listAllCourses() {

        List<Course>  c =  courseJPARepository.findAll();

        List<CourseModel> cM = c.stream().map(cn -> courseConverter.entityToModel(cn)).collect(Collectors.toList());

        return cM;
    }

    @Override
    public CourseModel addCourse(Course course) {

        return courseConverter.entityToModel(courseJPARepository.save(course)) ;
    }

    @Override
    public void removeCourse(Long id) {
          courseJPARepository.deleteById(id);
    }

    @Override
    public CourseModel updateCourse(Course course) {
        return courseConverter.entityToModel(courseJPARepository.save(course));
    }
}
