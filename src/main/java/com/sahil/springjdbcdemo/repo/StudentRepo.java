package com.sahil.springjdbcdemo.repo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.sahil.springjdbcdemo.model.Student;

@Repository
public class StudentRepo {

    public void save(Student s) {
        System.out.println("DAO: Saving Student: "+ s.toString());        
    }

    public List<Student> findAll() {
        System.out.println("DAO: Finding all students...");
        return new ArrayList();
    }

}
