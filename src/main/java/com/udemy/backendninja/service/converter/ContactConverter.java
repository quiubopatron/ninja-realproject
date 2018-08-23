package com.udemy.backendninja.service.converter;

import com.udemy.backendninja.Exception.ServiceException;
import com.udemy.backendninja.entity.ContactEntity;
import com.udemy.backendninja.model.ContactModel;
import org.apache.commons.beanutils.PropertyUtilsBean;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;

@Component("contactConverter")
public class ContactConverter {

    public ContactEntity convertContactModelToContact(ContactModel contactModel) {

        ContactEntity contactEntity = new ContactEntity();

        PropertyUtilsBean propertyUtilsBean = new PropertyUtilsBean();

        try {
            propertyUtilsBean.copyProperties(contactEntity, contactModel);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        return contactEntity;


    }

    public ContactModel convertContactEntityToContactModel(ContactEntity contactEntity) {

        ContactModel contactModel = new ContactModel();

        PropertyUtilsBean propertyUtilsBean = new PropertyUtilsBean();
        try {
            propertyUtilsBean.copyProperties(contactModel, contactEntity);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        return contactModel;







    }




}
