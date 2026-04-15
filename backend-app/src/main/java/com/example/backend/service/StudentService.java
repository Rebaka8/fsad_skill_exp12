package com.example.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.backend.entity.Student;
import com.example.backend.repository.StudentRepository;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repo;

    public List<Student> getAllStudents() {
        return repo.findAll();
    }

    public Student addStudent(Student s) {
        return repo.save(s);
    }

    public Student updateStudent(Long id, Student s) {
        Student existing = repo.findById(id).orElseThrow();
        existing.setName(s.getName());
        existing.setEmail(s.getEmail());
        existing.setCourse(s.getCourse());
        return repo.save(existing);
    }

    public void deleteStudent(Long id) {
        repo.deleteById(id);
    }
}