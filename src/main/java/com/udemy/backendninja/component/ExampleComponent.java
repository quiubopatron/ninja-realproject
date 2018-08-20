package com.udemy.backendninja.component;

import com.udemy.backendninja.entity.Course;
import com.udemy.backendninja.repository.CourseJPARepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("exampleComponent")
public class ExampleComponent {

    private static final Log LOG = LogFactory.getLog(ExampleComponent.class);

    @Autowired
    @Qualifier("courseJPARepository")
    private CourseJPARepository courseJPARepository;

    public void sayHello (){

        LOG.info("HELLO FROM EXAMPLECOMPONENT");

        List<Course> ejemplo  = courseJPARepository.findByName("ejemplo");
    }




}
