package com.dwatkins.studentroster.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dwatkins.studentroster.models.Contact;
import com.dwatkins.studentroster.models.Student;
import com.dwatkins.studentroster.repositories.ContactRepository;
import com.dwatkins.studentroster.repositories.StudentRepository;

@Service
public class StudentService {
	private final StudentRepository studentRepo;
	private final ContactRepository contactRepo;
	
	public StudentService(StudentRepository studentRepo, ContactRepository contactRepo) {
		this.studentRepo = studentRepo;
		this.contactRepo = contactRepo;
	}
	
	public List<Object[]> allStudents() {
		return studentRepo.joinStudentsAndContacts();
	}
	
	public List<Student> studentsWithoutContact() {
		return studentRepo.studentsWithoutContact();
	}
	
	public Student createStudent(Student s) {
		return studentRepo.save(s);
	}
	
	public Contact createContact(Contact c) {
		return contactRepo.save(c);
	}
}
