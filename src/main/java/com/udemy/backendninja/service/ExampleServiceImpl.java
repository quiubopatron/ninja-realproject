package com.udemy.backendninja.service;

import com.udemy.backendninja.model.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("exampleService")
public class ExampleServiceImpl implements ExampleService {


    @Override
    public List<Person> getListPeople() {

         List<Person> personas = new ArrayList<>();
            Person person1 = new Person("Tomas", 37);
            Person person2 = new Person("Vanessa", 31);
            Person person3 = new Person("Alicia", 3);

            personas.add(person1);
            personas.add(person2);
            personas.add(person3);

            return personas;

        }
    }
