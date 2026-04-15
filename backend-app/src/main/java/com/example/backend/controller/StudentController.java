package com.example.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.backend.entity.Student;
import com.example.backend.service.StudentService;

@RestController
@CrossOrigin("*")
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService service;

    @GetMapping
    public ResponseEntity<List<Student>> getAll() {
        return ResponseEntity.ok(service.getAllStudents());
    }

    @PostMapping
    public ResponseEntity<Student> add(@RequestBody Student s) {
        return ResponseEntity.ok(service.addStudent(s));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> update(@PathVariable Long id, @RequestBody Student s) {
        return ResponseEntity.ok(service.updateStudent(id, s));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        service.deleteStudent(id);
        return ResponseEntity.ok("Deleted Successfully");
    }
}