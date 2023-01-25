package com.kahara.sms.controller;

import com.kahara.sms.dto.StudentDto;
import com.kahara.sms.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<StudentDto>> getAllStudents() {
        return ResponseEntity.status(HttpStatus.OK).body(studentService.getAllStudents());
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<StudentDto> getStudentById(@PathVariable("id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(studentService.getStudentById(id));
    }

    @PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<StudentDto> addStudent(@RequestBody StudentDto studentDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(studentService.addStudent(studentDto));
    }

    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<StudentDto> updateStudent(@RequestBody StudentDto studentDto, @PathVariable("id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(studentService.updateStudent(studentDto, id));
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<String> deleteStudent(@PathVariable("id") Long id) {
        studentService.deleteStudent(id);
        return ResponseEntity.status(HttpStatus.OK).body("Student with id " + id + " deleted succesfully.");
    }
}
