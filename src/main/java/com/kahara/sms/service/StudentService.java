package com.kahara.sms.service;

import com.kahara.sms.dto.StudentDto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface StudentService {

    // Read
    List<StudentDto> getAllStudents();

    StudentDto getStudentById(Long id);

    // Create
    StudentDto addStudent(StudentDto studentDto);

    // Update
    StudentDto updateStudent(StudentDto studentDto, Long id);

    void deleteStudent(Long id);
}
