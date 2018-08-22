package com.udemy.backendninja.service;

import com.udemy.backendninja.entity.ContactEntity;
import com.udemy.backendninja.model.ContactModel;
import com.udemy.backendninja.repository.ContactRepository;
import com.udemy.backendninja.service.converter.ContactConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;

@Service("contactServiceImp")
public class ContactServiceImp implements ContactService {

    @Autowired
    @Qualifier("contactRepository")
    private ContactRepository contactRepository;

    @Autowired
    @Qualifier("contactConverter")
    private ContactConverter ContactConverter;

    @Override
    public ContactEntity addContact(ContactModel contactModel) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {

        contactRepository.save(contactModel)

        return contactRepository.save(contactModel);
    }
}
