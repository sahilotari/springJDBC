package com.sahil.springjdbcdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sahil.springjdbcdemo.model.Student;
import com.sahil.springjdbcdemo.repo.StudentRepo;

@Service
public class StudentService {

    private StudentRepo  studentRepo;

    public void addStudent(Student s) {
        System.out.println("Service: Adding Student: " +s.toString());
        studentRepo.save(s);
    }

    public StudentRepo getStudentRepo() {
        return studentRepo;
    }

    @Autowired
    public void setStudentRepo(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    public List<Student> getAllStudents() {
        System.out.println("Service: Get all students...");
        return studentRepo.findAll();
    }
    
}
