package com.njit.stusystem.dto;

import com.njit.stusystem.model.Course;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Setter
@Getter
@Accessors(chain = true)
public class StuAndCourseDTO {

    private Integer id;

    /**
     * 学年
     */
    private Integer schoolYear;

    private Integer physics;

    private Integer math;

    private Integer english;

    private Integer biology;

    private Integer chinese;

    private Integer chemistry;

    private Integer stuId;

    private String studentName;

    private Integer sum;


    private Integer teacherId;
}
