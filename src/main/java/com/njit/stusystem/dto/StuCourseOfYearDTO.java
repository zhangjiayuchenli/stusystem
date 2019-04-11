package com.njit.stusystem.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class StuCourseOfYearDTO {

    private Integer id;

    private String studentName;

    private Integer schoolYear;
}
