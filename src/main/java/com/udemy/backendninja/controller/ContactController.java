package com.udemy.backendninja.controller;

import com.udemy.backendninja.constant.ViewConstant;
import com.udemy.backendninja.model.ContactModel;
import com.udemy.backendninja.service.ContactService;
import com.udemy.backendninja.service.ContactServiceImp;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.lang.reflect.InvocationTargetException;

@Controller
@RequestMapping("/contacts")
public class ContactController {

    private Log log = LogFactory.getLog(ContactController.class);

    @Autowired
    @Qualifier("contactServiceImp")
    private ContactServiceImp contactService;


    @GetMapping("/contactsform")
    private String redirectContactForm(@RequestParam(name="id", required=false) Long id, Model model) {

        ContactModel contactModel;

        if(id == null) {
            model.addAttribute("contactModel", new ContactModel());
        } else {
            contactModel = contactService.findContactById(id);
            model.addAttribute("contactModel", contactModel);
        }

        return ViewConstant.CONTACT_FORM;
    }

    @GetMapping("/cancel")
    private String redirectContacts() {

        return "redirect:/contacts/listcontacts";
    }

    @PostMapping("/addcontact/listcontacts")
    private String addContact(@ModelAttribute(name = "contactModel") ContactModel contactModel, Model model) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {

        log.info("METHOD: addContact() -- PARAMS: userCredentials: " + contactModel.toString());
        model.addAttribute("result", 1);

        contactService.addContact(contactModel);

        return "redirect:/contacts/listcontacts";
    }

    @GetMapping("/listcontacts")
    private String listContacts(Model model) {

        model.addAttribute("contactlist", contactService.findAllContacts());

        return ViewConstant.CONTACTS;

    }

    @GetMapping("/removecontact") // tocaria hacerlo con put, pero para nohace ajax y javascript usamos get
    public String removeContact(@RequestParam(name="id", required=true) String contactId, Model model ) {

        contactService.removeContact(Long.valueOf(contactId));

        model.addAttribute("contactlist", contactService.findAllContacts());

        return ViewConstant.CONTACTS;

    }
}
