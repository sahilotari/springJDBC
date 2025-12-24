package com.sahil.springjdbcdemo;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.sahil.springjdbcdemo.model.Student;
import com.sahil.springjdbcdemo.service.StudentService;

//This class acts as client in this case
@SpringBootApplication
public class SpringjdbcdemoApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringjdbcdemoApplication.class, args);
		Student sahil = context.getBean(Student.class);
		sahil.setRollNo(104);
		sahil.setName("Sahil");
		sahil.setMarks(98);

		StudentService service = context.getBean(StudentService.class);
		service.addStudent(sahil);


		// Get all students
		List<Student> students = service.getAllStudents();
		System.out.println(students);

	}

}
