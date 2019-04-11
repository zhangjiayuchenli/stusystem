package com.njit.stusystem.model;

import java.io.Serializable;
import java.util.Date;

/**
 * tb_teacher
 * @author 
 */
public class Teacher implements Serializable {
    private Integer id;

    private String teacherName;

    private String teacherPassword;

    private String teacherSex;

    private String teacherPhone;

    private Date teacherBrithday;

    private String teacherEmail;

    private String teacherAddress;

    private String teacherClassname;

    private String teacherAvatar;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getTeacherPassword() {
        return teacherPassword;
    }

    public void setTeacherPassword(String teacherPassword) {
        this.teacherPassword = teacherPassword;
    }

    public String getTeacherSex() {
        return teacherSex;
    }

    public void setTeacherSex(String teacherSex) {
        this.teacherSex = teacherSex;
    }

    public String getTeacherPhone() {
        return teacherPhone;
    }

    public void setTeacherPhone(String teacherPhone) {
        this.teacherPhone = teacherPhone;
    }

    public Date getTeacherBrithday() {
        return teacherBrithday;
    }

    public void setTeacherBrithday(Date teacherBrithday) {
        this.teacherBrithday = teacherBrithday;
    }

    public String getTeacherEmail() {
        return teacherEmail;
    }

    public void setTeacherEmail(String teacherEmail) {
        this.teacherEmail = teacherEmail;
    }

    public String getTeacherAddress() {
        return teacherAddress;
    }

    public void setTeacherAddress(String teacherAddress) {
        this.teacherAddress = teacherAddress;
    }

    public String getTeacherClassname() {
        return teacherClassname;
    }

    public void setTeacherClassname(String teacherClassname) {
        this.teacherClassname = teacherClassname;
    }

    public String getTeacherAvatar() {
        return teacherAvatar;
    }

    public void setTeacherAvatar(String teacherAvatar) {
        this.teacherAvatar = teacherAvatar;
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
        Teacher other = (Teacher) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getTeacherName() == null ? other.getTeacherName() == null : this.getTeacherName().equals(other.getTeacherName()))
            && (this.getTeacherPassword() == null ? other.getTeacherPassword() == null : this.getTeacherPassword().equals(other.getTeacherPassword()))
            && (this.getTeacherSex() == null ? other.getTeacherSex() == null : this.getTeacherSex().equals(other.getTeacherSex()))
            && (this.getTeacherPhone() == null ? other.getTeacherPhone() == null : this.getTeacherPhone().equals(other.getTeacherPhone()))
            && (this.getTeacherBrithday() == null ? other.getTeacherBrithday() == null : this.getTeacherBrithday().equals(other.getTeacherBrithday()))
            && (this.getTeacherEmail() == null ? other.getTeacherEmail() == null : this.getTeacherEmail().equals(other.getTeacherEmail()))
            && (this.getTeacherAddress() == null ? other.getTeacherAddress() == null : this.getTeacherAddress().equals(other.getTeacherAddress()))
            && (this.getTeacherClassname() == null ? other.getTeacherClassname() == null : this.getTeacherClassname().equals(other.getTeacherClassname()))
            && (this.getTeacherAvatar() == null ? other.getTeacherAvatar() == null : this.getTeacherAvatar().equals(other.getTeacherAvatar()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getTeacherName() == null) ? 0 : getTeacherName().hashCode());
        result = prime * result + ((getTeacherPassword() == null) ? 0 : getTeacherPassword().hashCode());
        result = prime * result + ((getTeacherSex() == null) ? 0 : getTeacherSex().hashCode());
        result = prime * result + ((getTeacherPhone() == null) ? 0 : getTeacherPhone().hashCode());
        result = prime * result + ((getTeacherBrithday() == null) ? 0 : getTeacherBrithday().hashCode());
        result = prime * result + ((getTeacherEmail() == null) ? 0 : getTeacherEmail().hashCode());
        result = prime * result + ((getTeacherAddress() == null) ? 0 : getTeacherAddress().hashCode());
        result = prime * result + ((getTeacherClassname() == null) ? 0 : getTeacherClassname().hashCode());
        result = prime * result + ((getTeacherAvatar() == null) ? 0 : getTeacherAvatar().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", teacherName=").append(teacherName);
        sb.append(", teacherPassword=").append(teacherPassword);
        sb.append(", teacherSex=").append(teacherSex);
        sb.append(", teacherPhone=").append(teacherPhone);
        sb.append(", teacherBrithday=").append(teacherBrithday);
        sb.append(", teacherEmail=").append(teacherEmail);
        sb.append(", teacherAddress=").append(teacherAddress);
        sb.append(", teacherClassname=").append(teacherClassname);
        sb.append(", teacherAvatar=").append(teacherAvatar);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}