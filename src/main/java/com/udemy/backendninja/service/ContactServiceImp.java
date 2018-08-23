package com.udemy.backendninja.service;

import com.udemy.backendninja.Exception.ServiceException;
import com.udemy.backendninja.entity.ContactEntity;
import com.udemy.backendninja.model.ContactModel;
import com.udemy.backendninja.repository.ContactRepository;
import com.udemy.backendninja.service.converter.ContactConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service("contactServiceImp")
public class ContactServiceImp implements ContactService {

    @Autowired
    @Qualifier("contactRepository")
    private ContactRepository contactRepository;

    @Autowired
    @Qualifier("contactConverter")
    private ContactConverter contactConverter;

    @Override
    public ContactModel addContact(ContactModel contactModel) throws ServiceException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {

        ContactEntity contactEntity  = null;

        contactEntity = contactRepository.save(contactConverter.convertContactModelToContact(contactModel));

        return contactConverter.convertContactEntityToContactModel(contactEntity);
    }

    @Override
    public List<ContactModel> findAllContacts() {

        List<ContactEntity> contactEntityList  = contactRepository.findAll();

        List<ContactModel> contactModels  = contactEntityList.stream().map(cel -> contactConverter.convertContactEntityToContactModel(cel)).collect(Collectors.toList());

        return contactModels;
    }

    @Override
    public ContactModel findContactById(Long id) {

        Optional<ContactEntity> con  = contactRepository.findById(id);

        ContactModel contactModel = null;

        if(con.isPresent()) {
            contactModel =contactConverter.convertContactEntityToContactModel(con.get());
        }

        return contactModel;
    }

    @Override
    public ContactModel removeContact(Long id) {

        ContactModel contactModel = findContactById(id);

        if (contactModel != null) {
            contactRepository.delete(contactConverter.convertContactModelToContact(contactModel));
        }

        return contactModel;

    }
}
