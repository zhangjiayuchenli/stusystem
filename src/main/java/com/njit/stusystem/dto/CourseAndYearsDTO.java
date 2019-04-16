package com.njit.stusystem.dto;

import lombok.Data;
import lombok.experimental.Accessors;
/**
 * @author ZJY
 * @version 1.0
 * @date 2019/4/15 17:38
 */
@Data
@Accessors(chain = true)
public class CourseAndYearsDTO {

    /**
     * 学年
     */
    private String schoolYear;

    /**
     * 学生总分
     */
    private Integer totalScore;
}
