package com.njit.stusystem.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class CourseAndYearsDTO {

    //学年
    private String schoolYear;
    //学生总分
    private Integer totalScore;
}
