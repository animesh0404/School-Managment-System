package com.kahara.sms.controller;

import com.kahara.sms.dto.StudentDto;
import com.kahara.sms.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<StudentDto>> getAllStudents() {
        return new ResponseEntity<>(studentService.getAllStudents(),
                HttpStatus.OK);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<StudentDto> getStudentById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(studentService.getStudentById(id),
                HttpStatus.OK);
    }

}
