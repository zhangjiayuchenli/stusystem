package com.njit.stusystem.model;

import java.io.Serializable;

/**
 * tb_course
 * @author 
 */
public class Course implements Serializable {
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

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSchoolYear() {
        return schoolYear;
    }

    public void setSchoolYear(Integer schoolYear) {
        this.schoolYear = schoolYear;
    }

    public Integer getPhysics() {
        return physics;
    }

    public void setPhysics(Integer physics) {
        this.physics = physics;
    }

    public Integer getMath() {
        return math;
    }

    public void setMath(Integer math) {
        this.math = math;
    }

    public Integer getEnglish() {
        return english;
    }

    public void setEnglish(Integer english) {
        this.english = english;
    }

    public Integer getBiology() {
        return biology;
    }

    public void setBiology(Integer biology) {
        this.biology = biology;
    }

    public Integer getChinese() {
        return chinese;
    }

    public void setChinese(Integer chinese) {
        this.chinese = chinese;
    }

    public Integer getChemistry() {
        return chemistry;
    }

    public void setChemistry(Integer chemistry) {
        this.chemistry = chemistry;
    }

    public Integer getStuId() {
        return stuId;
    }

    public void setStuId(Integer stuId) {
        this.stuId = stuId;
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
        Course other = (Course) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getSchoolYear() == null ? other.getSchoolYear() == null : this.getSchoolYear().equals(other.getSchoolYear()))
            && (this.getPhysics() == null ? other.getPhysics() == null : this.getPhysics().equals(other.getPhysics()))
            && (this.getMath() == null ? other.getMath() == null : this.getMath().equals(other.getMath()))
            && (this.getEnglish() == null ? other.getEnglish() == null : this.getEnglish().equals(other.getEnglish()))
            && (this.getBiology() == null ? other.getBiology() == null : this.getBiology().equals(other.getBiology()))
            && (this.getChinese() == null ? other.getChinese() == null : this.getChinese().equals(other.getChinese()))
            && (this.getChemistry() == null ? other.getChemistry() == null : this.getChemistry().equals(other.getChemistry()))
            && (this.getStuId() == null ? other.getStuId() == null : this.getStuId().equals(other.getStuId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getSchoolYear() == null) ? 0 : getSchoolYear().hashCode());
        result = prime * result + ((getPhysics() == null) ? 0 : getPhysics().hashCode());
        result = prime * result + ((getMath() == null) ? 0 : getMath().hashCode());
        result = prime * result + ((getEnglish() == null) ? 0 : getEnglish().hashCode());
        result = prime * result + ((getBiology() == null) ? 0 : getBiology().hashCode());
        result = prime * result + ((getChinese() == null) ? 0 : getChinese().hashCode());
        result = prime * result + ((getChemistry() == null) ? 0 : getChemistry().hashCode());
        result = prime * result + ((getStuId() == null) ? 0 : getStuId().hashCode());
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
        sb.append(", physics=").append(physics);
        sb.append(", math=").append(math);
        sb.append(", english=").append(english);
        sb.append(", biology=").append(biology);
        sb.append(", chinese=").append(chinese);
        sb.append(", chemistry=").append(chemistry);
        sb.append(", stuId=").append(stuId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}