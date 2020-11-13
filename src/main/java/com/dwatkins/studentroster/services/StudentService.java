package com.dwatkins.studentroster.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.dwatkins.studentroster.models.Contact;
import com.dwatkins.studentroster.models.Dorm;
import com.dwatkins.studentroster.models.Student;
import com.dwatkins.studentroster.repositories.ContactRepository;
import com.dwatkins.studentroster.repositories.DormRepository;
import com.dwatkins.studentroster.repositories.StudentRepository;

@Service
public class StudentService {
	private final StudentRepository studentRepo;
	private final ContactRepository contactRepo;
	private final DormRepository dormRepo;
	
	public StudentService(StudentRepository studentRepo, ContactRepository contactRepo, DormRepository dormRepo) {
		this.studentRepo = studentRepo;
		this.contactRepo = contactRepo;
		this.dormRepo = dormRepo;
	}
	
	public List<Object[]> allStudents() {
		return studentRepo.joinStudentsAndContacts();
	}
	
	public List<Dorm> allDorms() {
		return dormRepo.findAll();
	}
	
	public Dorm findDorm(Long id) {
		Optional<Dorm> optionalDorm = dormRepo.findById(id);
		if (optionalDorm.isPresent()) {
			return optionalDorm.get();
		}
		else {
			return null;
		}
	}
	
	public List<Student> studentsWithoutContact() {
		return studentRepo.studentsWithoutContact();
	}
	
	public List<Student> studentsWithoutDorm() {
		return studentRepo.studentsWithoutDorm();
	}
	
	public Student createStudent(Student s) {
		return studentRepo.save(s);
	}
	
	public Contact createContact(Contact c) {
		return contactRepo.save(c);
	}
	
	public Dorm createDorm(Dorm d) {
		return dormRepo.save(d);
	}
	
	public Dorm addStudent(Long dormId, Long studentId) {
		Optional<Dorm> optionalDorm = dormRepo.findById(dormId);
		Optional<Student> optionalStudent = studentRepo.findById(studentId);
		if (optionalDorm.isPresent() && optionalStudent.isPresent()) {
			Dorm dorm = optionalDorm.get();
			Student newStudent = optionalStudent.get();
			List<Student> dormRoster = dorm.getStudents();
			dormRoster.add(newStudent);
			dorm.setStudents(dormRoster);
			return dormRepo.save(dorm);
		}
		else {
			return null;
		}
	}
	
	public Dorm removeStudent(Long dormId, Long studentId) {
		Optional<Dorm> optionalDorm = dormRepo.findById(dormId);
		Optional<Student> optionalStudent = studentRepo.findById(studentId);
		if (optionalDorm.isPresent() && optionalStudent.isPresent()) {
			Dorm dorm = optionalDorm.get();
			Student removeStudent = optionalStudent.get();
			List<Student> dormRoster = dorm.getStudents();
			dormRoster.remove(removeStudent);
			dorm.setStudents(dormRoster);
			return dormRepo.save(dorm);
		}
		else {
			return null;
		}
	}
}
