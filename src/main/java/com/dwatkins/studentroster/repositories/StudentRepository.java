package com.dwatkins.studentroster.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dwatkins.studentroster.models.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {
	@Query("SELECT s, c from Student s LEFT JOIN s.contact c")
	List<Object[]> joinStudentsAndContacts();
	
	@Query("SELECT s from Student s LEFT JOIN s.contact c WHERE c.id IS NULL")
	List<Student> studentsWithoutContact();

	@Query("SELECT s from Student s LEFT JOIN s.dorm d WHERE d.id IS NULL")
	List<Student> studentsWithoutDorm();
}
