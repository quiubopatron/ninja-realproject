package com.udemy.backendninja.service;

import com.udemy.backendninja.entity.ContactEntity;
import com.udemy.backendninja.model.ContactModel;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;

@Service
public interface ContactService {

    public abstract ContactEntity addContact(ContactModel contactModel) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException;


}
