package com.udemy.backendninja.repository;

import com.udemy.backendninja.entity.Course;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository
@Qualifier("courseJPARepository")
public interface CourseJPARepository extends JpaRepository<Course, Serializable> {


     public abstract Course findByPrice(int price);

     List<Course> findByName(String name);

     Course findByNameOrPrice(String name, int price);


}
