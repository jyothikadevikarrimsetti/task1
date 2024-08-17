package com.example.task1;

import com.example.task1.model.Students;
import com.example.task1.service.StudentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Task1Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Task1Application.class, args);
		StudentService service = context.getBean(StudentService.class);
//		service.addBranch(1,"ECE");
//		service.addBranch(2,"CSE");
//		service.addBranch(3,"MCA");
//		Students students = Students```.builder().studentName("jyo").build();
//		service.addStudent(students,1);


	}


}
