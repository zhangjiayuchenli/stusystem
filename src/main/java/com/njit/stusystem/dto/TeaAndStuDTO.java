package com.njit.stusystem.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Setter
@Getter
@Accessors(chain = true)
public class TeaAndStuDTO {
    private String teacherName;

    private String teacherClassname;

    private Integer id;

    private String studentName;

    private String studentPassword;

    private String studentBirthday;

    private String studentSex;

    private String studentPhone;

    private String studentAddress;

    private String studentEmail;
}
