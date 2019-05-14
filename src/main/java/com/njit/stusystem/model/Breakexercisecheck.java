package com.njit.stusystem.model;

import java.io.Serializable;

/**
 * tb_breakexercisecheck
 * @author 
 */
public class Breakexercisecheck implements Serializable {
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

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSchoolYear() {
        return schoolYear;
    }

    public void setSchoolYear(String schoolYear) {
        this.schoolYear = schoolYear;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Integer getStuId() {
        return stuId;
    }

    public void setStuId(Integer stuId) {
        this.stuId = stuId;
    }

    public Integer getLater() {
        return later;
    }

    public void setLater(Integer later) {
        this.later = later;
    }

    public Integer getEyeExercises() {
        return eyeExercises;
    }

    public void setEyeExercises(Integer eyeExercises) {
        this.eyeExercises = eyeExercises;
    }

    public Integer getPreExercises() {
        return preExercises;
    }

    public void setPreExercises(Integer preExercises) {
        this.preExercises = preExercises;
    }

    public Integer getQueueNeat() {
        return queueNeat;
    }

    public void setQueueNeat(Integer queueNeat) {
        this.queueNeat = queueNeat;
    }

    public Integer getActionStandard() {
        return actionStandard;
    }

    public void setActionStandard(Integer actionStandard) {
        this.actionStandard = actionStandard;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Breakexercisecheck other = (Breakexercisecheck) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getSchoolYear() == null ? other.getSchoolYear() == null : this.getSchoolYear().equals(other.getSchoolYear()))
            && (this.getWeek() == null ? other.getWeek() == null : this.getWeek().equals(other.getWeek()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getStuId() == null ? other.getStuId() == null : this.getStuId().equals(other.getStuId()))
            && (this.getLater() == null ? other.getLater() == null : this.getLater().equals(other.getLater()))
            && (this.getEyeExercises() == null ? other.getEyeExercises() == null : this.getEyeExercises().equals(other.getEyeExercises()))
            && (this.getPreExercises() == null ? other.getPreExercises() == null : this.getPreExercises().equals(other.getPreExercises()))
            && (this.getQueueNeat() == null ? other.getQueueNeat() == null : this.getQueueNeat().equals(other.getQueueNeat()))
            && (this.getActionStandard() == null ? other.getActionStandard() == null : this.getActionStandard().equals(other.getActionStandard()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getSchoolYear() == null) ? 0 : getSchoolYear().hashCode());
        result = prime * result + ((getWeek() == null) ? 0 : getWeek().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getStuId() == null) ? 0 : getStuId().hashCode());
        result = prime * result + ((getLater() == null) ? 0 : getLater().hashCode());
        result = prime * result + ((getEyeExercises() == null) ? 0 : getEyeExercises().hashCode());
        result = prime * result + ((getPreExercises() == null) ? 0 : getPreExercises().hashCode());
        result = prime * result + ((getQueueNeat() == null) ? 0 : getQueueNeat().hashCode());
        result = prime * result + ((getActionStandard() == null) ? 0 : getActionStandard().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", schoolYear=").append(schoolYear);
        sb.append(", week=").append(week);
        sb.append(", createTime=").append(createTime);
        sb.append(", stuId=").append(stuId);
        sb.append(", later=").append(later);
        sb.append(", eyeExercises=").append(eyeExercises);
        sb.append(", preExercises=").append(preExercises);
        sb.append(", queueNeat=").append(queueNeat);
        sb.append(", actionStandard=").append(actionStandard);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}