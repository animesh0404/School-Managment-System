package com.kahara.sms.helper;

import com.kahara.sms.dto.StudentDto;
import com.kahara.sms.entity.Student;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

public class StudentHelper {

    public static StudentDto entityToDto(Student entity){
        StudentDto dto = new StudentDto();
        BeanUtils.copyProperties(entity,dto);
        return dto;
    }

    public static Student dtoToEntity(StudentDto dto){
        Student entity = new Student();
        BeanUtils.copyProperties(dto,entity);
        return entity;
    }

    public static List<StudentDto> entityToDto(List<Student> entityList) {
        return entityList.stream().map(StudentHelper::entityToDto).collect(Collectors.toList());
    }

    public static List<Student> dtoToEntity(List<StudentDto> dtoList) {
        return dtoList.stream().map(StudentHelper::dtoToEntity).collect(Collectors.toList());
    }

}
