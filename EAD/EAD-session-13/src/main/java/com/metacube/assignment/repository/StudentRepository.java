package com.metacube.assignment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.metacube.assignment.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

	public List<Student> findByEmailContainingIgnoreCase(Student student);

	public List<Student> findByStdContainingIgnoreCase(String std);

}
