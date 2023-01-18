package com.kahara.sms.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentDto {
    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private String mobile;

    private Date dateOfBirth;
}


