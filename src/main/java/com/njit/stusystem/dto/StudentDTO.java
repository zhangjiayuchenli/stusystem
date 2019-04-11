package com.njit.stusystem.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
public class StudentDTO {

    private Integer id;

    private String studentName;

    private String studentPassword;

    private String studentBirthday;

    private String studentSex;

    private String studentPhone;

    private String studentAddress;

    private String studentEmail;
    private String studentAvatar;

    /**
     * 与教师id关联
     */
    private Integer teacherId;
}
