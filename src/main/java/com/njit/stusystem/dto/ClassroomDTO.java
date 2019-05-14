package com.njit.stusystem.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * @author ZJY
 * @version 1.0
 * @date 2019/5/7 13:42
 */
@Setter
@Getter
@Accessors(chain = true)
public class ClassroomDTO {
    private Integer id;

    /**
     * 学期
     */
    private String schoolYear;

    /**
     * 当前周
     */
    private String week;

    /**
     * 创建时间
     */
    private String creatTime;

    /**
     * 对应学生id
     */
    private Integer stuId;

    private String studentName;

    /**
     * 上课积极回答问题
     */
    private Integer positiveDegree;

    /**
     * 上课迟到
     */
    private Integer later;

    /**
     * 课堂作业
     */
    private Integer work;

    /**
     * 帮助同学
     */
    private Integer helpClassmates;

    /**
     * 小组讨论活跃度
     */
    private Integer discussionDegree;
}
