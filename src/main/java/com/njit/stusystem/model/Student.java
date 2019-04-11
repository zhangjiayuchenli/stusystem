package com.njit.stusystem.model;

import java.io.Serializable;

/**
 * tb_student
 * @author 
 */
public class Student implements Serializable {
    private Integer id;

    private String studentName;

    private String studentPassword;

    private String studentBirthday;

    private String studentSex;

    private String studentPhone;

    private String studentAddress;

    private String studentEmail;

    /**
     * 与教师id关联
     */
    private Integer teacherId;

    /**
     * 学生头像
     */
    private String studentAvatar;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentPassword() {
        return studentPassword;
    }

    public void setStudentPassword(String studentPassword) {
        this.studentPassword = studentPassword;
    }

    public String getStudentBirthday() {
        return studentBirthday;
    }

    public void setStudentBirthday(String studentBirthday) {
        this.studentBirthday = studentBirthday;
    }

    public String getStudentSex() {
        return studentSex;
    }

    public void setStudentSex(String studentSex) {
        this.studentSex = studentSex;
    }

    public String getStudentPhone() {
        return studentPhone;
    }

    public void setStudentPhone(String studentPhone) {
        this.studentPhone = studentPhone;
    }

    public String getStudentAddress() {
        return studentAddress;
    }

    public void setStudentAddress(String studentAddress) {
        this.studentAddress = studentAddress;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public String getStudentAvatar() {
        return studentAvatar;
    }

    public void setStudentAvatar(String studentAvatar) {
        this.studentAvatar = studentAvatar;
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
        Student other = (Student) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getStudentName() == null ? other.getStudentName() == null : this.getStudentName().equals(other.getStudentName()))
            && (this.getStudentPassword() == null ? other.getStudentPassword() == null : this.getStudentPassword().equals(other.getStudentPassword()))
            && (this.getStudentBirthday() == null ? other.getStudentBirthday() == null : this.getStudentBirthday().equals(other.getStudentBirthday()))
            && (this.getStudentSex() == null ? other.getStudentSex() == null : this.getStudentSex().equals(other.getStudentSex()))
            && (this.getStudentPhone() == null ? other.getStudentPhone() == null : this.getStudentPhone().equals(other.getStudentPhone()))
            && (this.getStudentAddress() == null ? other.getStudentAddress() == null : this.getStudentAddress().equals(other.getStudentAddress()))
            && (this.getStudentEmail() == null ? other.getStudentEmail() == null : this.getStudentEmail().equals(other.getStudentEmail()))
            && (this.getTeacherId() == null ? other.getTeacherId() == null : this.getTeacherId().equals(other.getTeacherId()))
            && (this.getStudentAvatar() == null ? other.getStudentAvatar() == null : this.getStudentAvatar().equals(other.getStudentAvatar()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getStudentName() == null) ? 0 : getStudentName().hashCode());
        result = prime * result + ((getStudentPassword() == null) ? 0 : getStudentPassword().hashCode());
        result = prime * result + ((getStudentBirthday() == null) ? 0 : getStudentBirthday().hashCode());
        result = prime * result + ((getStudentSex() == null) ? 0 : getStudentSex().hashCode());
        result = prime * result + ((getStudentPhone() == null) ? 0 : getStudentPhone().hashCode());
        result = prime * result + ((getStudentAddress() == null) ? 0 : getStudentAddress().hashCode());
        result = prime * result + ((getStudentEmail() == null) ? 0 : getStudentEmail().hashCode());
        result = prime * result + ((getTeacherId() == null) ? 0 : getTeacherId().hashCode());
        result = prime * result + ((getStudentAvatar() == null) ? 0 : getStudentAvatar().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", studentName=").append(studentName);
        sb.append(", studentPassword=").append(studentPassword);
        sb.append(", studentBirthday=").append(studentBirthday);
        sb.append(", studentSex=").append(studentSex);
        sb.append(", studentPhone=").append(studentPhone);
        sb.append(", studentAddress=").append(studentAddress);
        sb.append(", studentEmail=").append(studentEmail);
        sb.append(", teacherId=").append(teacherId);
        sb.append(", studentAvatar=").append(studentAvatar);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}