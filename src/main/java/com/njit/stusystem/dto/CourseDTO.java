package com.njit.stusystem.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
/**
 * @author ZJY
 * @version 1.0
 * @date 2019/4/15 17:38
 */
@Setter
@Getter
@Accessors(chain = true)
public class CourseDTO {
    /* 等级 */
    private String grade;
    /* 数量 */
    private Integer numbers;
}
