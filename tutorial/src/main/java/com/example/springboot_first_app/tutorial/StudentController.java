package com.example.springboot_first_app.tutorial;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    
    @GetMapping(path = "/student")
    public Student getStudent(){
        return new Student("Ramesh", "Adhikary");
    }

    @GetMapping(path= "/students")
    public List<Student> getStudents(){
        List<Student> students = new ArrayList<>();
        students.add(new Student("Ramesh", "Adhikary"));
        students.add(new Student("Suresh", "Adhikary"));
        students.add(new Student("Jiggesh", "Adhikary"));

        return students;
    }


    @GetMapping(path="/student/{firstName}/{lastName}")
    public Student studentPathVariable(@PathVariable("firstName") String firstName, @PathVariable("lastName") String lastName){
        return new Student(firstName, lastName);
    }

    //build rest API to handle query parameters
    //http://localhost:8080/student?firstName=Ramesh&lastName=Adhikary
    @GetMapping("/student/query")
    public Student studentQueryParam(@RequestParam(name="firstName") String firstName,@RequestParam(name="lastName") String lastName){
        return new Student(firstName, lastName);
    }
}
