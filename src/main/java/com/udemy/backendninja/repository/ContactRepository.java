package com.udemy.backendninja.repository;

import com.udemy.backendninja.entity.ContactEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("contactRepository")
public interface ContactRepository extends JpaRepository<ContactEntity,Long>{ // El tutorial usa JpaRepository<ContactEntity,Serializable>, a saber porque.


}
