package com.njit.stusystem.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.Date;

@Getter
@Setter
@Accessors(chain = true)
public class TeacherDTO {
    private Integer id;

    private String teacherName;

    private String teacherPassword;

    private String teacherSex;

    private String teacherPhone;

    private String teacherBrithday;

    private String teacherEmail;

    private String teacherAddress;

    private String teacherClassname;

    private String teacherAvatar;
}
