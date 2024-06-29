package com.steven.demo.rest;


import com.steven.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    // define the fields
    private List<Student> listStudents;

    @PostConstruct
    public void loadData(){

        listStudents = new ArrayList<>();

        listStudents.add(new Student("Steven","Gerrard"));
        listStudents.add(new Student("Frank","Lampard"));
        listStudents.add(new Student("Leo","Messi"));

    }


    // define an endpoint for Students
    @GetMapping("/students")
    public List<Student> getStudents(){

        return listStudents;

    }

    // define an endpoint for /students/{studentId}
    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId){

        // check the student id again the list size
        if( (studentId >= listStudents.size()) || (studentId < 0) ){
            // Step 2: throw exception
            throw new StudentNotFoundException("Student is not found " + studentId);
        }

        return listStudents.get(studentId);
    }







}
