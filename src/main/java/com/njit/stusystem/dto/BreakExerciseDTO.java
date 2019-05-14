package com.njit.stusystem.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * @author ZJY
 * @version 1.0
 * @date 2019/5/8 16:33
 */
@Setter
@Getter
@Accessors(chain = true)
public class BreakExerciseDTO {
    private Integer id;

    /**
     * 当前学期
     */
    private String schoolYear;

    /**
     * 当前周
     */
    private String week;

    /**
     * 创建时间
     */
    private String createTime;

    /**
     * 对应学生学号
     */
    private Integer stuId;
    private String studentName;

    /**
     * 准时到达
     */
    private Integer later;

    /**
     * 眼保健操
     */
    private Integer eyeExercises;

    /**
     * 操前活动
     */
    private Integer preExercises;

    /**
     * 队列整齐
     */
    private Integer queueNeat;

    /**
     * 动作标准
     */
    private Integer actionStandard;
}
