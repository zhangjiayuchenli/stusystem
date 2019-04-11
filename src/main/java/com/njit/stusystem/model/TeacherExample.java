package com.njit.stusystem.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class TeacherExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Long offset;

    public TeacherExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setOffset(Long offset) {
        this.offset = offset;
    }

    public Long getOffset() {
        return offset;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andTeacherNameIsNull() {
            addCriterion("teacher_name is null");
            return (Criteria) this;
        }

        public Criteria andTeacherNameIsNotNull() {
            addCriterion("teacher_name is not null");
            return (Criteria) this;
        }

        public Criteria andTeacherNameEqualTo(String value) {
            addCriterion("teacher_name =", value, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherNameNotEqualTo(String value) {
            addCriterion("teacher_name <>", value, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherNameGreaterThan(String value) {
            addCriterion("teacher_name >", value, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherNameGreaterThanOrEqualTo(String value) {
            addCriterion("teacher_name >=", value, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherNameLessThan(String value) {
            addCriterion("teacher_name <", value, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherNameLessThanOrEqualTo(String value) {
            addCriterion("teacher_name <=", value, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherNameLike(String value) {
            addCriterion("teacher_name like", value, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherNameNotLike(String value) {
            addCriterion("teacher_name not like", value, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherNameIn(List<String> values) {
            addCriterion("teacher_name in", values, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherNameNotIn(List<String> values) {
            addCriterion("teacher_name not in", values, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherNameBetween(String value1, String value2) {
            addCriterion("teacher_name between", value1, value2, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherNameNotBetween(String value1, String value2) {
            addCriterion("teacher_name not between", value1, value2, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherPasswordIsNull() {
            addCriterion("teacher_password is null");
            return (Criteria) this;
        }

        public Criteria andTeacherPasswordIsNotNull() {
            addCriterion("teacher_password is not null");
            return (Criteria) this;
        }

        public Criteria andTeacherPasswordEqualTo(String value) {
            addCriterion("teacher_password =", value, "teacherPassword");
            return (Criteria) this;
        }

        public Criteria andTeacherPasswordNotEqualTo(String value) {
            addCriterion("teacher_password <>", value, "teacherPassword");
            return (Criteria) this;
        }

        public Criteria andTeacherPasswordGreaterThan(String value) {
            addCriterion("teacher_password >", value, "teacherPassword");
            return (Criteria) this;
        }

        public Criteria andTeacherPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("teacher_password >=", value, "teacherPassword");
            return (Criteria) this;
        }

        public Criteria andTeacherPasswordLessThan(String value) {
            addCriterion("teacher_password <", value, "teacherPassword");
            return (Criteria) this;
        }

        public Criteria andTeacherPasswordLessThanOrEqualTo(String value) {
            addCriterion("teacher_password <=", value, "teacherPassword");
            return (Criteria) this;
        }

        public Criteria andTeacherPasswordLike(String value) {
            addCriterion("teacher_password like", value, "teacherPassword");
            return (Criteria) this;
        }

        public Criteria andTeacherPasswordNotLike(String value) {
            addCriterion("teacher_password not like", value, "teacherPassword");
            return (Criteria) this;
        }

        public Criteria andTeacherPasswordIn(List<String> values) {
            addCriterion("teacher_password in", values, "teacherPassword");
            return (Criteria) this;
        }

        public Criteria andTeacherPasswordNotIn(List<String> values) {
            addCriterion("teacher_password not in", values, "teacherPassword");
            return (Criteria) this;
        }

        public Criteria andTeacherPasswordBetween(String value1, String value2) {
            addCriterion("teacher_password between", value1, value2, "teacherPassword");
            return (Criteria) this;
        }

        public Criteria andTeacherPasswordNotBetween(String value1, String value2) {
            addCriterion("teacher_password not between", value1, value2, "teacherPassword");
            return (Criteria) this;
        }

        public Criteria andTeacherSexIsNull() {
            addCriterion("teacher_sex is null");
            return (Criteria) this;
        }

        public Criteria andTeacherSexIsNotNull() {
            addCriterion("teacher_sex is not null");
            return (Criteria) this;
        }

        public Criteria andTeacherSexEqualTo(String value) {
            addCriterion("teacher_sex =", value, "teacherSex");
            return (Criteria) this;
        }

        public Criteria andTeacherSexNotEqualTo(String value) {
            addCriterion("teacher_sex <>", value, "teacherSex");
            return (Criteria) this;
        }

        public Criteria andTeacherSexGreaterThan(String value) {
            addCriterion("teacher_sex >", value, "teacherSex");
            return (Criteria) this;
        }

        public Criteria andTeacherSexGreaterThanOrEqualTo(String value) {
            addCriterion("teacher_sex >=", value, "teacherSex");
            return (Criteria) this;
        }

        public Criteria andTeacherSexLessThan(String value) {
            addCriterion("teacher_sex <", value, "teacherSex");
            return (Criteria) this;
        }

        public Criteria andTeacherSexLessThanOrEqualTo(String value) {
            addCriterion("teacher_sex <=", value, "teacherSex");
            return (Criteria) this;
        }

        public Criteria andTeacherSexLike(String value) {
            addCriterion("teacher_sex like", value, "teacherSex");
            return (Criteria) this;
        }

        public Criteria andTeacherSexNotLike(String value) {
            addCriterion("teacher_sex not like", value, "teacherSex");
            return (Criteria) this;
        }

        public Criteria andTeacherSexIn(List<String> values) {
            addCriterion("teacher_sex in", values, "teacherSex");
            return (Criteria) this;
        }

        public Criteria andTeacherSexNotIn(List<String> values) {
            addCriterion("teacher_sex not in", values, "teacherSex");
            return (Criteria) this;
        }

        public Criteria andTeacherSexBetween(String value1, String value2) {
            addCriterion("teacher_sex between", value1, value2, "teacherSex");
            return (Criteria) this;
        }

        public Criteria andTeacherSexNotBetween(String value1, String value2) {
            addCriterion("teacher_sex not between", value1, value2, "teacherSex");
            return (Criteria) this;
        }

        public Criteria andTeacherPhoneIsNull() {
            addCriterion("teacher_phone is null");
            return (Criteria) this;
        }

        public Criteria andTeacherPhoneIsNotNull() {
            addCriterion("teacher_phone is not null");
            return (Criteria) this;
        }

        public Criteria andTeacherPhoneEqualTo(String value) {
            addCriterion("teacher_phone =", value, "teacherPhone");
            return (Criteria) this;
        }

        public Criteria andTeacherPhoneNotEqualTo(String value) {
            addCriterion("teacher_phone <>", value, "teacherPhone");
            return (Criteria) this;
        }

        public Criteria andTeacherPhoneGreaterThan(String value) {
            addCriterion("teacher_phone >", value, "teacherPhone");
            return (Criteria) this;
        }

        public Criteria andTeacherPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("teacher_phone >=", value, "teacherPhone");
            return (Criteria) this;
        }

        public Criteria andTeacherPhoneLessThan(String value) {
            addCriterion("teacher_phone <", value, "teacherPhone");
            return (Criteria) this;
        }

        public Criteria andTeacherPhoneLessThanOrEqualTo(String value) {
            addCriterion("teacher_phone <=", value, "teacherPhone");
            return (Criteria) this;
        }

        public Criteria andTeacherPhoneLike(String value) {
            addCriterion("teacher_phone like", value, "teacherPhone");
            return (Criteria) this;
        }

        public Criteria andTeacherPhoneNotLike(String value) {
            addCriterion("teacher_phone not like", value, "teacherPhone");
            return (Criteria) this;
        }

        public Criteria andTeacherPhoneIn(List<String> values) {
            addCriterion("teacher_phone in", values, "teacherPhone");
            return (Criteria) this;
        }

        public Criteria andTeacherPhoneNotIn(List<String> values) {
            addCriterion("teacher_phone not in", values, "teacherPhone");
            return (Criteria) this;
        }

        public Criteria andTeacherPhoneBetween(String value1, String value2) {
            addCriterion("teacher_phone between", value1, value2, "teacherPhone");
            return (Criteria) this;
        }

        public Criteria andTeacherPhoneNotBetween(String value1, String value2) {
            addCriterion("teacher_phone not between", value1, value2, "teacherPhone");
            return (Criteria) this;
        }

        public Criteria andTeacherBrithdayIsNull() {
            addCriterion("teacher_brithday is null");
            return (Criteria) this;
        }

        public Criteria andTeacherBrithdayIsNotNull() {
            addCriterion("teacher_brithday is not null");
            return (Criteria) this;
        }

        public Criteria andTeacherBrithdayEqualTo(Date value) {
            addCriterionForJDBCDate("teacher_brithday =", value, "teacherBrithday");
            return (Criteria) this;
        }

        public Criteria andTeacherBrithdayNotEqualTo(Date value) {
            addCriterionForJDBCDate("teacher_brithday <>", value, "teacherBrithday");
            return (Criteria) this;
        }

        public Criteria andTeacherBrithdayGreaterThan(Date value) {
            addCriterionForJDBCDate("teacher_brithday >", value, "teacherBrithday");
            return (Criteria) this;
        }

        public Criteria andTeacherBrithdayGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("teacher_brithday >=", value, "teacherBrithday");
            return (Criteria) this;
        }

        public Criteria andTeacherBrithdayLessThan(Date value) {
            addCriterionForJDBCDate("teacher_brithday <", value, "teacherBrithday");
            return (Criteria) this;
        }

        public Criteria andTeacherBrithdayLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("teacher_brithday <=", value, "teacherBrithday");
            return (Criteria) this;
        }

        public Criteria andTeacherBrithdayIn(List<Date> values) {
            addCriterionForJDBCDate("teacher_brithday in", values, "teacherBrithday");
            return (Criteria) this;
        }

        public Criteria andTeacherBrithdayNotIn(List<Date> values) {
            addCriterionForJDBCDate("teacher_brithday not in", values, "teacherBrithday");
            return (Criteria) this;
        }

        public Criteria andTeacherBrithdayBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("teacher_brithday between", value1, value2, "teacherBrithday");
            return (Criteria) this;
        }

        public Criteria andTeacherBrithdayNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("teacher_brithday not between", value1, value2, "teacherBrithday");
            return (Criteria) this;
        }

        public Criteria andTeacherEmailIsNull() {
            addCriterion("teacher_email is null");
            return (Criteria) this;
        }

        public Criteria andTeacherEmailIsNotNull() {
            addCriterion("teacher_email is not null");
            return (Criteria) this;
        }

        public Criteria andTeacherEmailEqualTo(String value) {
            addCriterion("teacher_email =", value, "teacherEmail");
            return (Criteria) this;
        }

        public Criteria andTeacherEmailNotEqualTo(String value) {
            addCriterion("teacher_email <>", value, "teacherEmail");
            return (Criteria) this;
        }

        public Criteria andTeacherEmailGreaterThan(String value) {
            addCriterion("teacher_email >", value, "teacherEmail");
            return (Criteria) this;
        }

        public Criteria andTeacherEmailGreaterThanOrEqualTo(String value) {
            addCriterion("teacher_email >=", value, "teacherEmail");
            return (Criteria) this;
        }

        public Criteria andTeacherEmailLessThan(String value) {
            addCriterion("teacher_email <", value, "teacherEmail");
            return (Criteria) this;
        }

        public Criteria andTeacherEmailLessThanOrEqualTo(String value) {
            addCriterion("teacher_email <=", value, "teacherEmail");
            return (Criteria) this;
        }

        public Criteria andTeacherEmailLike(String value) {
            addCriterion("teacher_email like", value, "teacherEmail");
            return (Criteria) this;
        }

        public Criteria andTeacherEmailNotLike(String value) {
            addCriterion("teacher_email not like", value, "teacherEmail");
            return (Criteria) this;
        }

        public Criteria andTeacherEmailIn(List<String> values) {
            addCriterion("teacher_email in", values, "teacherEmail");
            return (Criteria) this;
        }

        public Criteria andTeacherEmailNotIn(List<String> values) {
            addCriterion("teacher_email not in", values, "teacherEmail");
            return (Criteria) this;
        }

        public Criteria andTeacherEmailBetween(String value1, String value2) {
            addCriterion("teacher_email between", value1, value2, "teacherEmail");
            return (Criteria) this;
        }

        public Criteria andTeacherEmailNotBetween(String value1, String value2) {
            addCriterion("teacher_email not between", value1, value2, "teacherEmail");
            return (Criteria) this;
        }

        public Criteria andTeacherAddressIsNull() {
            addCriterion("teacher_address is null");
            return (Criteria) this;
        }

        public Criteria andTeacherAddressIsNotNull() {
            addCriterion("teacher_address is not null");
            return (Criteria) this;
        }

        public Criteria andTeacherAddressEqualTo(String value) {
            addCriterion("teacher_address =", value, "teacherAddress");
            return (Criteria) this;
        }

        public Criteria andTeacherAddressNotEqualTo(String value) {
            addCriterion("teacher_address <>", value, "teacherAddress");
            return (Criteria) this;
        }

        public Criteria andTeacherAddressGreaterThan(String value) {
            addCriterion("teacher_address >", value, "teacherAddress");
            return (Criteria) this;
        }

        public Criteria andTeacherAddressGreaterThanOrEqualTo(String value) {
            addCriterion("teacher_address >=", value, "teacherAddress");
            return (Criteria) this;
        }

        public Criteria andTeacherAddressLessThan(String value) {
            addCriterion("teacher_address <", value, "teacherAddress");
            return (Criteria) this;
        }

        public Criteria andTeacherAddressLessThanOrEqualTo(String value) {
            addCriterion("teacher_address <=", value, "teacherAddress");
            return (Criteria) this;
        }

        public Criteria andTeacherAddressLike(String value) {
            addCriterion("teacher_address like", value, "teacherAddress");
            return (Criteria) this;
        }

        public Criteria andTeacherAddressNotLike(String value) {
            addCriterion("teacher_address not like", value, "teacherAddress");
            return (Criteria) this;
        }

        public Criteria andTeacherAddressIn(List<String> values) {
            addCriterion("teacher_address in", values, "teacherAddress");
            return (Criteria) this;
        }

        public Criteria andTeacherAddressNotIn(List<String> values) {
            addCriterion("teacher_address not in", values, "teacherAddress");
            return (Criteria) this;
        }

        public Criteria andTeacherAddressBetween(String value1, String value2) {
            addCriterion("teacher_address between", value1, value2, "teacherAddress");
            return (Criteria) this;
        }

        public Criteria andTeacherAddressNotBetween(String value1, String value2) {
            addCriterion("teacher_address not between", value1, value2, "teacherAddress");
            return (Criteria) this;
        }

        public Criteria andTeacherClassnameIsNull() {
            addCriterion("teacher_classname is null");
            return (Criteria) this;
        }

        public Criteria andTeacherClassnameIsNotNull() {
            addCriterion("teacher_classname is not null");
            return (Criteria) this;
        }

        public Criteria andTeacherClassnameEqualTo(String value) {
            addCriterion("teacher_classname =", value, "teacherClassname");
            return (Criteria) this;
        }

        public Criteria andTeacherClassnameNotEqualTo(String value) {
            addCriterion("teacher_classname <>", value, "teacherClassname");
            return (Criteria) this;
        }

        public Criteria andTeacherClassnameGreaterThan(String value) {
            addCriterion("teacher_classname >", value, "teacherClassname");
            return (Criteria) this;
        }

        public Criteria andTeacherClassnameGreaterThanOrEqualTo(String value) {
            addCriterion("teacher_classname >=", value, "teacherClassname");
            return (Criteria) this;
        }

        public Criteria andTeacherClassnameLessThan(String value) {
            addCriterion("teacher_classname <", value, "teacherClassname");
            return (Criteria) this;
        }

        public Criteria andTeacherClassnameLessThanOrEqualTo(String value) {
            addCriterion("teacher_classname <=", value, "teacherClassname");
            return (Criteria) this;
        }

        public Criteria andTeacherClassnameLike(String value) {
            addCriterion("teacher_classname like", value, "teacherClassname");
            return (Criteria) this;
        }

        public Criteria andTeacherClassnameNotLike(String value) {
            addCriterion("teacher_classname not like", value, "teacherClassname");
            return (Criteria) this;
        }

        public Criteria andTeacherClassnameIn(List<String> values) {
            addCriterion("teacher_classname in", values, "teacherClassname");
            return (Criteria) this;
        }

        public Criteria andTeacherClassnameNotIn(List<String> values) {
            addCriterion("teacher_classname not in", values, "teacherClassname");
            return (Criteria) this;
        }

        public Criteria andTeacherClassnameBetween(String value1, String value2) {
            addCriterion("teacher_classname between", value1, value2, "teacherClassname");
            return (Criteria) this;
        }

        public Criteria andTeacherClassnameNotBetween(String value1, String value2) {
            addCriterion("teacher_classname not between", value1, value2, "teacherClassname");
            return (Criteria) this;
        }

        public Criteria andTeacherAvatarIsNull() {
            addCriterion("teacher_avatar is null");
            return (Criteria) this;
        }

        public Criteria andTeacherAvatarIsNotNull() {
            addCriterion("teacher_avatar is not null");
            return (Criteria) this;
        }

        public Criteria andTeacherAvatarEqualTo(String value) {
            addCriterion("teacher_avatar =", value, "teacherAvatar");
            return (Criteria) this;
        }

        public Criteria andTeacherAvatarNotEqualTo(String value) {
            addCriterion("teacher_avatar <>", value, "teacherAvatar");
            return (Criteria) this;
        }

        public Criteria andTeacherAvatarGreaterThan(String value) {
            addCriterion("teacher_avatar >", value, "teacherAvatar");
            return (Criteria) this;
        }

        public Criteria andTeacherAvatarGreaterThanOrEqualTo(String value) {
            addCriterion("teacher_avatar >=", value, "teacherAvatar");
            return (Criteria) this;
        }

        public Criteria andTeacherAvatarLessThan(String value) {
            addCriterion("teacher_avatar <", value, "teacherAvatar");
            return (Criteria) this;
        }

        public Criteria andTeacherAvatarLessThanOrEqualTo(String value) {
            addCriterion("teacher_avatar <=", value, "teacherAvatar");
            return (Criteria) this;
        }

        public Criteria andTeacherAvatarLike(String value) {
            addCriterion("teacher_avatar like", value, "teacherAvatar");
            return (Criteria) this;
        }

        public Criteria andTeacherAvatarNotLike(String value) {
            addCriterion("teacher_avatar not like", value, "teacherAvatar");
            return (Criteria) this;
        }

        public Criteria andTeacherAvatarIn(List<String> values) {
            addCriterion("teacher_avatar in", values, "teacherAvatar");
            return (Criteria) this;
        }

        public Criteria andTeacherAvatarNotIn(List<String> values) {
            addCriterion("teacher_avatar not in", values, "teacherAvatar");
            return (Criteria) this;
        }

        public Criteria andTeacherAvatarBetween(String value1, String value2) {
            addCriterion("teacher_avatar between", value1, value2, "teacherAvatar");
            return (Criteria) this;
        }

        public Criteria andTeacherAvatarNotBetween(String value1, String value2) {
            addCriterion("teacher_avatar not between", value1, value2, "teacherAvatar");
            return (Criteria) this;
        }
    }

    /**
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}