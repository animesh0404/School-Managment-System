package com.kahara.sms.seviceimpl;

import com.kahara.sms.dto.StudentDto;
import com.kahara.sms.entity.Student;
import com.kahara.sms.helper.StudentHelper;
import com.kahara.sms.repo.StudentRepository;
import com.kahara.sms.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<StudentDto> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        return StudentHelper.entityToDto(students);
    }

}
