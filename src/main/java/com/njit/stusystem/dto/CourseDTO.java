package com.njit.stusystem.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Setter
@Getter
@Accessors(chain = true)
public class CourseDTO {
    /* 等级 */
    private String grade;
    /* 数量 */
    private Integer numbers;
}
