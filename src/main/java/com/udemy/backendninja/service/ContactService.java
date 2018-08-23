package com.udemy.backendninja.service;

import com.udemy.backendninja.Exception.ServiceException;
import com.udemy.backendninja.model.ContactModel;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

@Service
public interface ContactService {

    public abstract ContactModel addContact(ContactModel contactModel) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException, ServiceException;

    public abstract List<ContactModel> findAllContacts();

    public abstract ContactModel findContactById(Long id);

    public abstract ContactModel removeContact(Long id);



}
