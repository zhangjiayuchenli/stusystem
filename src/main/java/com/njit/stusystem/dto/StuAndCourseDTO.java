package com.njit.stusystem.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Setter
@Getter
@Accessors(chain = true)
public class StuAndCourseDTO {
    private Integer id;

    private String studentName;

    private Integer schoolYear;

    private Integer physics;

    private Integer math;

    private Integer english;

    private Integer biology;

    private Integer chinese;

    private Integer chemistry;

    private Integer sum;

    private Integer stuId;

    private Integer teacherId;
}
