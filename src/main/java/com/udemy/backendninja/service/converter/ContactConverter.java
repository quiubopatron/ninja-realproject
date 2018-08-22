package com.udemy.backendninja.service.converter;

import com.udemy.backendninja.entity.ContactEntity;
import com.udemy.backendninja.model.ContactModel;
import org.apache.commons.beanutils.PropertyUtilsBean;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;

@Component("contactConverter")
public class ContactConverter {

    public ContactEntity convertContactModelToContact(ContactModel contactModel) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {

        ContactEntity contactEntity = new ContactEntity();

        PropertyUtilsBean propertyUtilsBean = new PropertyUtilsBean();

        propertyUtilsBean.copyProperties(contactEntity, contactModel);


        return contactEntity;


    }

    public ContactModel convertContactEntityToContactModel(ContactEntity contactEntity) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {

        ContactModel contactModel = new ContactModel();

        PropertyUtilsBean propertyUtilsBean = new PropertyUtilsBean();
        propertyUtilsBean.copyProperties(contactModel, contactEntity);

        return contactModel;







    }




}
