package com.udemy.backendninja.repository;

import com.udemy.backendninja.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("contactRepository")
public interface ContactRepository extends JpaRepository<Contact,Long>{ // El tutorial usa JpaRepository<Contact,Serializable>, a saber porque.


}
