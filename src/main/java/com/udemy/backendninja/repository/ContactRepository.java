package com.udemy.backendninja.repository;

import com.udemy.backendninja.entity.ContactEntity;
import com.udemy.backendninja.model.ContactModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository("contactRepository")
public interface ContactRepository extends JpaRepository<ContactEntity,Long>{ // El tutorial usa JpaRepository<ContactEntity,Serializable>, a saber porque.


}
