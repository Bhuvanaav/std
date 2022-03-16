package com.spring.std.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.std.model.Student;
import com.spring.std.repository.StudentRepository;

@Service
public class StudentService {
	@Autowired
	private StudentRepository repository;
	
	public List<Student> listAll() {
        return repository.findAll();
    }
	
	public void save(Student std) {
        repository.save(std);
    }
    
    public Student get(Integer id) {
        return repository.findById(id).get();
    }
    
    public void delete(Integer id) {
        repository.deleteById(id);
    }

}
