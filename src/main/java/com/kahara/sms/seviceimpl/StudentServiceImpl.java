package com.kahara.sms.seviceimpl;

import com.kahara.sms.dto.StudentDto;
import com.kahara.sms.entity.Student;
import com.kahara.sms.helper.StudentHelper;
import com.kahara.sms.repo.StudentRepository;
import com.kahara.sms.service.StudentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<StudentDto> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        return StudentHelper.entityToDto(students);
    }

    @Override
    public StudentDto getStudentById(Long id) {
        Optional<Student> studentOptional = studentRepository.findById(id);
        Student student = new Student();
        if (studentOptional.isPresent()) student = studentOptional.get();
        return StudentHelper.entityToDto(student);
    }

    @Override
    public StudentDto addStudent(StudentDto studentDto) {
        Student student = new Student();
        if (studentDto != null) {
            student = StudentHelper.dtoToEntity(studentDto);
            studentRepository.save(student);
        }
        return StudentHelper.entityToDto(student);
    }

    @Override
    public StudentDto updateStudent(StudentDto studentDto, Long id) {
        Optional<Student> studentOptional = studentRepository.findById(id);
        Student studentToSave = new Student();
        if (studentOptional.isPresent()) {
            BeanUtils.copyProperties(studentDto, studentToSave);
            studentToSave.setId(id);
            studentToSave = studentRepository.save(studentToSave);
        }
        return StudentHelper.entityToDto(studentToSave);
    }

}
