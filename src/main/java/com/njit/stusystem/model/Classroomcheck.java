package com.njit.stusystem.model;

import java.io.Serializable;

/**
 * tb_classroomcheck
 * @author 
 */
public class Classroomcheck implements Serializable {
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

    public String getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(String creatTime) {
        this.creatTime = creatTime;
    }

    public Integer getStuId() {
        return stuId;
    }

    public void setStuId(Integer stuId) {
        this.stuId = stuId;
    }

    public Integer getPositiveDegree() {
        return positiveDegree;
    }

    public void setPositiveDegree(Integer positiveDegree) {
        this.positiveDegree = positiveDegree;
    }

    public Integer getLater() {
        return later;
    }

    public void setLater(Integer later) {
        this.later = later;
    }

    public Integer getWork() {
        return work;
    }

    public void setWork(Integer work) {
        this.work = work;
    }

    public Integer getHelpClassmates() {
        return helpClassmates;
    }

    public void setHelpClassmates(Integer helpClassmates) {
        this.helpClassmates = helpClassmates;
    }

    public Integer getDiscussionDegree() {
        return discussionDegree;
    }

    public void setDiscussionDegree(Integer discussionDegree) {
        this.discussionDegree = discussionDegree;
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
        Classroomcheck other = (Classroomcheck) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getSchoolYear() == null ? other.getSchoolYear() == null : this.getSchoolYear().equals(other.getSchoolYear()))
            && (this.getWeek() == null ? other.getWeek() == null : this.getWeek().equals(other.getWeek()))
            && (this.getCreatTime() == null ? other.getCreatTime() == null : this.getCreatTime().equals(other.getCreatTime()))
            && (this.getStuId() == null ? other.getStuId() == null : this.getStuId().equals(other.getStuId()))
            && (this.getPositiveDegree() == null ? other.getPositiveDegree() == null : this.getPositiveDegree().equals(other.getPositiveDegree()))
            && (this.getLater() == null ? other.getLater() == null : this.getLater().equals(other.getLater()))
            && (this.getWork() == null ? other.getWork() == null : this.getWork().equals(other.getWork()))
            && (this.getHelpClassmates() == null ? other.getHelpClassmates() == null : this.getHelpClassmates().equals(other.getHelpClassmates()))
            && (this.getDiscussionDegree() == null ? other.getDiscussionDegree() == null : this.getDiscussionDegree().equals(other.getDiscussionDegree()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getSchoolYear() == null) ? 0 : getSchoolYear().hashCode());
        result = prime * result + ((getWeek() == null) ? 0 : getWeek().hashCode());
        result = prime * result + ((getCreatTime() == null) ? 0 : getCreatTime().hashCode());
        result = prime * result + ((getStuId() == null) ? 0 : getStuId().hashCode());
        result = prime * result + ((getPositiveDegree() == null) ? 0 : getPositiveDegree().hashCode());
        result = prime * result + ((getLater() == null) ? 0 : getLater().hashCode());
        result = prime * result + ((getWork() == null) ? 0 : getWork().hashCode());
        result = prime * result + ((getHelpClassmates() == null) ? 0 : getHelpClassmates().hashCode());
        result = prime * result + ((getDiscussionDegree() == null) ? 0 : getDiscussionDegree().hashCode());
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
        sb.append(", creatTime=").append(creatTime);
        sb.append(", stuId=").append(stuId);
        sb.append(", positiveDegree=").append(positiveDegree);
        sb.append(", later=").append(later);
        sb.append(", work=").append(work);
        sb.append(", helpClassmates=").append(helpClassmates);
        sb.append(", discussionDegree=").append(discussionDegree);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}