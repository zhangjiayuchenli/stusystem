package com.njit.stusystem.model;

import java.util.ArrayList;
import java.util.List;

public class ClassroomcheckExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Long offset;

    public ClassroomcheckExample() {
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

        public Criteria andSchoolYearIsNull() {
            addCriterion("school_year is null");
            return (Criteria) this;
        }

        public Criteria andSchoolYearIsNotNull() {
            addCriterion("school_year is not null");
            return (Criteria) this;
        }

        public Criteria andSchoolYearEqualTo(String value) {
            addCriterion("school_year =", value, "schoolYear");
            return (Criteria) this;
        }

        public Criteria andSchoolYearNotEqualTo(String value) {
            addCriterion("school_year <>", value, "schoolYear");
            return (Criteria) this;
        }

        public Criteria andSchoolYearGreaterThan(String value) {
            addCriterion("school_year >", value, "schoolYear");
            return (Criteria) this;
        }

        public Criteria andSchoolYearGreaterThanOrEqualTo(String value) {
            addCriterion("school_year >=", value, "schoolYear");
            return (Criteria) this;
        }

        public Criteria andSchoolYearLessThan(String value) {
            addCriterion("school_year <", value, "schoolYear");
            return (Criteria) this;
        }

        public Criteria andSchoolYearLessThanOrEqualTo(String value) {
            addCriterion("school_year <=", value, "schoolYear");
            return (Criteria) this;
        }

        public Criteria andSchoolYearLike(String value) {
            addCriterion("school_year like", value, "schoolYear");
            return (Criteria) this;
        }

        public Criteria andSchoolYearNotLike(String value) {
            addCriterion("school_year not like", value, "schoolYear");
            return (Criteria) this;
        }

        public Criteria andSchoolYearIn(List<String> values) {
            addCriterion("school_year in", values, "schoolYear");
            return (Criteria) this;
        }

        public Criteria andSchoolYearNotIn(List<String> values) {
            addCriterion("school_year not in", values, "schoolYear");
            return (Criteria) this;
        }

        public Criteria andSchoolYearBetween(String value1, String value2) {
            addCriterion("school_year between", value1, value2, "schoolYear");
            return (Criteria) this;
        }

        public Criteria andSchoolYearNotBetween(String value1, String value2) {
            addCriterion("school_year not between", value1, value2, "schoolYear");
            return (Criteria) this;
        }

        public Criteria andWeekIsNull() {
            addCriterion("week is null");
            return (Criteria) this;
        }

        public Criteria andWeekIsNotNull() {
            addCriterion("week is not null");
            return (Criteria) this;
        }

        public Criteria andWeekEqualTo(String value) {
            addCriterion("week =", value, "week");
            return (Criteria) this;
        }

        public Criteria andWeekNotEqualTo(String value) {
            addCriterion("week <>", value, "week");
            return (Criteria) this;
        }

        public Criteria andWeekGreaterThan(String value) {
            addCriterion("week >", value, "week");
            return (Criteria) this;
        }

        public Criteria andWeekGreaterThanOrEqualTo(String value) {
            addCriterion("week >=", value, "week");
            return (Criteria) this;
        }

        public Criteria andWeekLessThan(String value) {
            addCriterion("week <", value, "week");
            return (Criteria) this;
        }

        public Criteria andWeekLessThanOrEqualTo(String value) {
            addCriterion("week <=", value, "week");
            return (Criteria) this;
        }

        public Criteria andWeekLike(String value) {
            addCriterion("week like", value, "week");
            return (Criteria) this;
        }

        public Criteria andWeekNotLike(String value) {
            addCriterion("week not like", value, "week");
            return (Criteria) this;
        }

        public Criteria andWeekIn(List<String> values) {
            addCriterion("week in", values, "week");
            return (Criteria) this;
        }

        public Criteria andWeekNotIn(List<String> values) {
            addCriterion("week not in", values, "week");
            return (Criteria) this;
        }

        public Criteria andWeekBetween(String value1, String value2) {
            addCriterion("week between", value1, value2, "week");
            return (Criteria) this;
        }

        public Criteria andWeekNotBetween(String value1, String value2) {
            addCriterion("week not between", value1, value2, "week");
            return (Criteria) this;
        }

        public Criteria andCreatTimeIsNull() {
            addCriterion("creat_time is null");
            return (Criteria) this;
        }

        public Criteria andCreatTimeIsNotNull() {
            addCriterion("creat_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreatTimeEqualTo(String value) {
            addCriterion("creat_time =", value, "creatTime");
            return (Criteria) this;
        }

        public Criteria andCreatTimeNotEqualTo(String value) {
            addCriterion("creat_time <>", value, "creatTime");
            return (Criteria) this;
        }

        public Criteria andCreatTimeGreaterThan(String value) {
            addCriterion("creat_time >", value, "creatTime");
            return (Criteria) this;
        }

        public Criteria andCreatTimeGreaterThanOrEqualTo(String value) {
            addCriterion("creat_time >=", value, "creatTime");
            return (Criteria) this;
        }

        public Criteria andCreatTimeLessThan(String value) {
            addCriterion("creat_time <", value, "creatTime");
            return (Criteria) this;
        }

        public Criteria andCreatTimeLessThanOrEqualTo(String value) {
            addCriterion("creat_time <=", value, "creatTime");
            return (Criteria) this;
        }

        public Criteria andCreatTimeLike(String value) {
            addCriterion("creat_time like", value, "creatTime");
            return (Criteria) this;
        }

        public Criteria andCreatTimeNotLike(String value) {
            addCriterion("creat_time not like", value, "creatTime");
            return (Criteria) this;
        }

        public Criteria andCreatTimeIn(List<String> values) {
            addCriterion("creat_time in", values, "creatTime");
            return (Criteria) this;
        }

        public Criteria andCreatTimeNotIn(List<String> values) {
            addCriterion("creat_time not in", values, "creatTime");
            return (Criteria) this;
        }

        public Criteria andCreatTimeBetween(String value1, String value2) {
            addCriterion("creat_time between", value1, value2, "creatTime");
            return (Criteria) this;
        }

        public Criteria andCreatTimeNotBetween(String value1, String value2) {
            addCriterion("creat_time not between", value1, value2, "creatTime");
            return (Criteria) this;
        }

        public Criteria andStuIdIsNull() {
            addCriterion("stu_id is null");
            return (Criteria) this;
        }

        public Criteria andStuIdIsNotNull() {
            addCriterion("stu_id is not null");
            return (Criteria) this;
        }

        public Criteria andStuIdEqualTo(Integer value) {
            addCriterion("stu_id =", value, "stuId");
            return (Criteria) this;
        }

        public Criteria andStuIdNotEqualTo(Integer value) {
            addCriterion("stu_id <>", value, "stuId");
            return (Criteria) this;
        }

        public Criteria andStuIdGreaterThan(Integer value) {
            addCriterion("stu_id >", value, "stuId");
            return (Criteria) this;
        }

        public Criteria andStuIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("stu_id >=", value, "stuId");
            return (Criteria) this;
        }

        public Criteria andStuIdLessThan(Integer value) {
            addCriterion("stu_id <", value, "stuId");
            return (Criteria) this;
        }

        public Criteria andStuIdLessThanOrEqualTo(Integer value) {
            addCriterion("stu_id <=", value, "stuId");
            return (Criteria) this;
        }

        public Criteria andStuIdIn(List<Integer> values) {
            addCriterion("stu_id in", values, "stuId");
            return (Criteria) this;
        }

        public Criteria andStuIdNotIn(List<Integer> values) {
            addCriterion("stu_id not in", values, "stuId");
            return (Criteria) this;
        }

        public Criteria andStuIdBetween(Integer value1, Integer value2) {
            addCriterion("stu_id between", value1, value2, "stuId");
            return (Criteria) this;
        }

        public Criteria andStuIdNotBetween(Integer value1, Integer value2) {
            addCriterion("stu_id not between", value1, value2, "stuId");
            return (Criteria) this;
        }

        public Criteria andPositiveDegreeIsNull() {
            addCriterion("positive_degree is null");
            return (Criteria) this;
        }

        public Criteria andPositiveDegreeIsNotNull() {
            addCriterion("positive_degree is not null");
            return (Criteria) this;
        }

        public Criteria andPositiveDegreeEqualTo(Integer value) {
            addCriterion("positive_degree =", value, "positiveDegree");
            return (Criteria) this;
        }

        public Criteria andPositiveDegreeNotEqualTo(Integer value) {
            addCriterion("positive_degree <>", value, "positiveDegree");
            return (Criteria) this;
        }

        public Criteria andPositiveDegreeGreaterThan(Integer value) {
            addCriterion("positive_degree >", value, "positiveDegree");
            return (Criteria) this;
        }

        public Criteria andPositiveDegreeGreaterThanOrEqualTo(Integer value) {
            addCriterion("positive_degree >=", value, "positiveDegree");
            return (Criteria) this;
        }

        public Criteria andPositiveDegreeLessThan(Integer value) {
            addCriterion("positive_degree <", value, "positiveDegree");
            return (Criteria) this;
        }

        public Criteria andPositiveDegreeLessThanOrEqualTo(Integer value) {
            addCriterion("positive_degree <=", value, "positiveDegree");
            return (Criteria) this;
        }

        public Criteria andPositiveDegreeIn(List<Integer> values) {
            addCriterion("positive_degree in", values, "positiveDegree");
            return (Criteria) this;
        }

        public Criteria andPositiveDegreeNotIn(List<Integer> values) {
            addCriterion("positive_degree not in", values, "positiveDegree");
            return (Criteria) this;
        }

        public Criteria andPositiveDegreeBetween(Integer value1, Integer value2) {
            addCriterion("positive_degree between", value1, value2, "positiveDegree");
            return (Criteria) this;
        }

        public Criteria andPositiveDegreeNotBetween(Integer value1, Integer value2) {
            addCriterion("positive_degree not between", value1, value2, "positiveDegree");
            return (Criteria) this;
        }

        public Criteria andLaterIsNull() {
            addCriterion("later is null");
            return (Criteria) this;
        }

        public Criteria andLaterIsNotNull() {
            addCriterion("later is not null");
            return (Criteria) this;
        }

        public Criteria andLaterEqualTo(Integer value) {
            addCriterion("later =", value, "later");
            return (Criteria) this;
        }

        public Criteria andLaterNotEqualTo(Integer value) {
            addCriterion("later <>", value, "later");
            return (Criteria) this;
        }

        public Criteria andLaterGreaterThan(Integer value) {
            addCriterion("later >", value, "later");
            return (Criteria) this;
        }

        public Criteria andLaterGreaterThanOrEqualTo(Integer value) {
            addCriterion("later >=", value, "later");
            return (Criteria) this;
        }

        public Criteria andLaterLessThan(Integer value) {
            addCriterion("later <", value, "later");
            return (Criteria) this;
        }

        public Criteria andLaterLessThanOrEqualTo(Integer value) {
            addCriterion("later <=", value, "later");
            return (Criteria) this;
        }

        public Criteria andLaterIn(List<Integer> values) {
            addCriterion("later in", values, "later");
            return (Criteria) this;
        }

        public Criteria andLaterNotIn(List<Integer> values) {
            addCriterion("later not in", values, "later");
            return (Criteria) this;
        }

        public Criteria andLaterBetween(Integer value1, Integer value2) {
            addCriterion("later between", value1, value2, "later");
            return (Criteria) this;
        }

        public Criteria andLaterNotBetween(Integer value1, Integer value2) {
            addCriterion("later not between", value1, value2, "later");
            return (Criteria) this;
        }

        public Criteria andWorkIsNull() {
            addCriterion("`work` is null");
            return (Criteria) this;
        }

        public Criteria andWorkIsNotNull() {
            addCriterion("`work` is not null");
            return (Criteria) this;
        }

        public Criteria andWorkEqualTo(Integer value) {
            addCriterion("`work` =", value, "work");
            return (Criteria) this;
        }

        public Criteria andWorkNotEqualTo(Integer value) {
            addCriterion("`work` <>", value, "work");
            return (Criteria) this;
        }

        public Criteria andWorkGreaterThan(Integer value) {
            addCriterion("`work` >", value, "work");
            return (Criteria) this;
        }

        public Criteria andWorkGreaterThanOrEqualTo(Integer value) {
            addCriterion("`work` >=", value, "work");
            return (Criteria) this;
        }

        public Criteria andWorkLessThan(Integer value) {
            addCriterion("`work` <", value, "work");
            return (Criteria) this;
        }

        public Criteria andWorkLessThanOrEqualTo(Integer value) {
            addCriterion("`work` <=", value, "work");
            return (Criteria) this;
        }

        public Criteria andWorkIn(List<Integer> values) {
            addCriterion("`work` in", values, "work");
            return (Criteria) this;
        }

        public Criteria andWorkNotIn(List<Integer> values) {
            addCriterion("`work` not in", values, "work");
            return (Criteria) this;
        }

        public Criteria andWorkBetween(Integer value1, Integer value2) {
            addCriterion("`work` between", value1, value2, "work");
            return (Criteria) this;
        }

        public Criteria andWorkNotBetween(Integer value1, Integer value2) {
            addCriterion("`work` not between", value1, value2, "work");
            return (Criteria) this;
        }

        public Criteria andHelpClassmatesIsNull() {
            addCriterion("help_classmates is null");
            return (Criteria) this;
        }

        public Criteria andHelpClassmatesIsNotNull() {
            addCriterion("help_classmates is not null");
            return (Criteria) this;
        }

        public Criteria andHelpClassmatesEqualTo(Integer value) {
            addCriterion("help_classmates =", value, "helpClassmates");
            return (Criteria) this;
        }

        public Criteria andHelpClassmatesNotEqualTo(Integer value) {
            addCriterion("help_classmates <>", value, "helpClassmates");
            return (Criteria) this;
        }

        public Criteria andHelpClassmatesGreaterThan(Integer value) {
            addCriterion("help_classmates >", value, "helpClassmates");
            return (Criteria) this;
        }

        public Criteria andHelpClassmatesGreaterThanOrEqualTo(Integer value) {
            addCriterion("help_classmates >=", value, "helpClassmates");
            return (Criteria) this;
        }

        public Criteria andHelpClassmatesLessThan(Integer value) {
            addCriterion("help_classmates <", value, "helpClassmates");
            return (Criteria) this;
        }

        public Criteria andHelpClassmatesLessThanOrEqualTo(Integer value) {
            addCriterion("help_classmates <=", value, "helpClassmates");
            return (Criteria) this;
        }

        public Criteria andHelpClassmatesIn(List<Integer> values) {
            addCriterion("help_classmates in", values, "helpClassmates");
            return (Criteria) this;
        }

        public Criteria andHelpClassmatesNotIn(List<Integer> values) {
            addCriterion("help_classmates not in", values, "helpClassmates");
            return (Criteria) this;
        }

        public Criteria andHelpClassmatesBetween(Integer value1, Integer value2) {
            addCriterion("help_classmates between", value1, value2, "helpClassmates");
            return (Criteria) this;
        }

        public Criteria andHelpClassmatesNotBetween(Integer value1, Integer value2) {
            addCriterion("help_classmates not between", value1, value2, "helpClassmates");
            return (Criteria) this;
        }

        public Criteria andDiscussionDegreeIsNull() {
            addCriterion("discussion_degree is null");
            return (Criteria) this;
        }

        public Criteria andDiscussionDegreeIsNotNull() {
            addCriterion("discussion_degree is not null");
            return (Criteria) this;
        }

        public Criteria andDiscussionDegreeEqualTo(Integer value) {
            addCriterion("discussion_degree =", value, "discussionDegree");
            return (Criteria) this;
        }

        public Criteria andDiscussionDegreeNotEqualTo(Integer value) {
            addCriterion("discussion_degree <>", value, "discussionDegree");
            return (Criteria) this;
        }

        public Criteria andDiscussionDegreeGreaterThan(Integer value) {
            addCriterion("discussion_degree >", value, "discussionDegree");
            return (Criteria) this;
        }

        public Criteria andDiscussionDegreeGreaterThanOrEqualTo(Integer value) {
            addCriterion("discussion_degree >=", value, "discussionDegree");
            return (Criteria) this;
        }

        public Criteria andDiscussionDegreeLessThan(Integer value) {
            addCriterion("discussion_degree <", value, "discussionDegree");
            return (Criteria) this;
        }

        public Criteria andDiscussionDegreeLessThanOrEqualTo(Integer value) {
            addCriterion("discussion_degree <=", value, "discussionDegree");
            return (Criteria) this;
        }

        public Criteria andDiscussionDegreeIn(List<Integer> values) {
            addCriterion("discussion_degree in", values, "discussionDegree");
            return (Criteria) this;
        }

        public Criteria andDiscussionDegreeNotIn(List<Integer> values) {
            addCriterion("discussion_degree not in", values, "discussionDegree");
            return (Criteria) this;
        }

        public Criteria andDiscussionDegreeBetween(Integer value1, Integer value2) {
            addCriterion("discussion_degree between", value1, value2, "discussionDegree");
            return (Criteria) this;
        }

        public Criteria andDiscussionDegreeNotBetween(Integer value1, Integer value2) {
            addCriterion("discussion_degree not between", value1, value2, "discussionDegree");
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