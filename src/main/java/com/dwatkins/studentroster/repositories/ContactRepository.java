package com.dwatkins.studentroster.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dwatkins.studentroster.models.Contact;

@Repository
public interface ContactRepository extends CrudRepository<Contact, Long> {

}
