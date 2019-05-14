package com.njit.stusystem.model;

import java.util.ArrayList;
import java.util.List;

public class BreakexercisecheckExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Long offset;

    public BreakexercisecheckExample() {
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

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(String value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(String value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(String value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(String value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(String value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(String value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLike(String value) {
            addCriterion("create_time like", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotLike(String value) {
            addCriterion("create_time not like", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<String> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<String> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(String value1, String value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(String value1, String value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
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

        public Criteria andEyeExercisesIsNull() {
            addCriterion("eye_exercises is null");
            return (Criteria) this;
        }

        public Criteria andEyeExercisesIsNotNull() {
            addCriterion("eye_exercises is not null");
            return (Criteria) this;
        }

        public Criteria andEyeExercisesEqualTo(Integer value) {
            addCriterion("eye_exercises =", value, "eyeExercises");
            return (Criteria) this;
        }

        public Criteria andEyeExercisesNotEqualTo(Integer value) {
            addCriterion("eye_exercises <>", value, "eyeExercises");
            return (Criteria) this;
        }

        public Criteria andEyeExercisesGreaterThan(Integer value) {
            addCriterion("eye_exercises >", value, "eyeExercises");
            return (Criteria) this;
        }

        public Criteria andEyeExercisesGreaterThanOrEqualTo(Integer value) {
            addCriterion("eye_exercises >=", value, "eyeExercises");
            return (Criteria) this;
        }

        public Criteria andEyeExercisesLessThan(Integer value) {
            addCriterion("eye_exercises <", value, "eyeExercises");
            return (Criteria) this;
        }

        public Criteria andEyeExercisesLessThanOrEqualTo(Integer value) {
            addCriterion("eye_exercises <=", value, "eyeExercises");
            return (Criteria) this;
        }

        public Criteria andEyeExercisesIn(List<Integer> values) {
            addCriterion("eye_exercises in", values, "eyeExercises");
            return (Criteria) this;
        }

        public Criteria andEyeExercisesNotIn(List<Integer> values) {
            addCriterion("eye_exercises not in", values, "eyeExercises");
            return (Criteria) this;
        }

        public Criteria andEyeExercisesBetween(Integer value1, Integer value2) {
            addCriterion("eye_exercises between", value1, value2, "eyeExercises");
            return (Criteria) this;
        }

        public Criteria andEyeExercisesNotBetween(Integer value1, Integer value2) {
            addCriterion("eye_exercises not between", value1, value2, "eyeExercises");
            return (Criteria) this;
        }

        public Criteria andPreExercisesIsNull() {
            addCriterion("pre_exercises is null");
            return (Criteria) this;
        }

        public Criteria andPreExercisesIsNotNull() {
            addCriterion("pre_exercises is not null");
            return (Criteria) this;
        }

        public Criteria andPreExercisesEqualTo(Integer value) {
            addCriterion("pre_exercises =", value, "preExercises");
            return (Criteria) this;
        }

        public Criteria andPreExercisesNotEqualTo(Integer value) {
            addCriterion("pre_exercises <>", value, "preExercises");
            return (Criteria) this;
        }

        public Criteria andPreExercisesGreaterThan(Integer value) {
            addCriterion("pre_exercises >", value, "preExercises");
            return (Criteria) this;
        }

        public Criteria andPreExercisesGreaterThanOrEqualTo(Integer value) {
            addCriterion("pre_exercises >=", value, "preExercises");
            return (Criteria) this;
        }

        public Criteria andPreExercisesLessThan(Integer value) {
            addCriterion("pre_exercises <", value, "preExercises");
            return (Criteria) this;
        }

        public Criteria andPreExercisesLessThanOrEqualTo(Integer value) {
            addCriterion("pre_exercises <=", value, "preExercises");
            return (Criteria) this;
        }

        public Criteria andPreExercisesIn(List<Integer> values) {
            addCriterion("pre_exercises in", values, "preExercises");
            return (Criteria) this;
        }

        public Criteria andPreExercisesNotIn(List<Integer> values) {
            addCriterion("pre_exercises not in", values, "preExercises");
            return (Criteria) this;
        }

        public Criteria andPreExercisesBetween(Integer value1, Integer value2) {
            addCriterion("pre_exercises between", value1, value2, "preExercises");
            return (Criteria) this;
        }

        public Criteria andPreExercisesNotBetween(Integer value1, Integer value2) {
            addCriterion("pre_exercises not between", value1, value2, "preExercises");
            return (Criteria) this;
        }

        public Criteria andQueueNeatIsNull() {
            addCriterion("queue_neat is null");
            return (Criteria) this;
        }

        public Criteria andQueueNeatIsNotNull() {
            addCriterion("queue_neat is not null");
            return (Criteria) this;
        }

        public Criteria andQueueNeatEqualTo(Integer value) {
            addCriterion("queue_neat =", value, "queueNeat");
            return (Criteria) this;
        }

        public Criteria andQueueNeatNotEqualTo(Integer value) {
            addCriterion("queue_neat <>", value, "queueNeat");
            return (Criteria) this;
        }

        public Criteria andQueueNeatGreaterThan(Integer value) {
            addCriterion("queue_neat >", value, "queueNeat");
            return (Criteria) this;
        }

        public Criteria andQueueNeatGreaterThanOrEqualTo(Integer value) {
            addCriterion("queue_neat >=", value, "queueNeat");
            return (Criteria) this;
        }

        public Criteria andQueueNeatLessThan(Integer value) {
            addCriterion("queue_neat <", value, "queueNeat");
            return (Criteria) this;
        }

        public Criteria andQueueNeatLessThanOrEqualTo(Integer value) {
            addCriterion("queue_neat <=", value, "queueNeat");
            return (Criteria) this;
        }

        public Criteria andQueueNeatIn(List<Integer> values) {
            addCriterion("queue_neat in", values, "queueNeat");
            return (Criteria) this;
        }

        public Criteria andQueueNeatNotIn(List<Integer> values) {
            addCriterion("queue_neat not in", values, "queueNeat");
            return (Criteria) this;
        }

        public Criteria andQueueNeatBetween(Integer value1, Integer value2) {
            addCriterion("queue_neat between", value1, value2, "queueNeat");
            return (Criteria) this;
        }

        public Criteria andQueueNeatNotBetween(Integer value1, Integer value2) {
            addCriterion("queue_neat not between", value1, value2, "queueNeat");
            return (Criteria) this;
        }

        public Criteria andActionStandardIsNull() {
            addCriterion("action_standard is null");
            return (Criteria) this;
        }

        public Criteria andActionStandardIsNotNull() {
            addCriterion("action_standard is not null");
            return (Criteria) this;
        }

        public Criteria andActionStandardEqualTo(Integer value) {
            addCriterion("action_standard =", value, "actionStandard");
            return (Criteria) this;
        }

        public Criteria andActionStandardNotEqualTo(Integer value) {
            addCriterion("action_standard <>", value, "actionStandard");
            return (Criteria) this;
        }

        public Criteria andActionStandardGreaterThan(Integer value) {
            addCriterion("action_standard >", value, "actionStandard");
            return (Criteria) this;
        }

        public Criteria andActionStandardGreaterThanOrEqualTo(Integer value) {
            addCriterion("action_standard >=", value, "actionStandard");
            return (Criteria) this;
        }

        public Criteria andActionStandardLessThan(Integer value) {
            addCriterion("action_standard <", value, "actionStandard");
            return (Criteria) this;
        }

        public Criteria andActionStandardLessThanOrEqualTo(Integer value) {
            addCriterion("action_standard <=", value, "actionStandard");
            return (Criteria) this;
        }

        public Criteria andActionStandardIn(List<Integer> values) {
            addCriterion("action_standard in", values, "actionStandard");
            return (Criteria) this;
        }

        public Criteria andActionStandardNotIn(List<Integer> values) {
            addCriterion("action_standard not in", values, "actionStandard");
            return (Criteria) this;
        }

        public Criteria andActionStandardBetween(Integer value1, Integer value2) {
            addCriterion("action_standard between", value1, value2, "actionStandard");
            return (Criteria) this;
        }

        public Criteria andActionStandardNotBetween(Integer value1, Integer value2) {
            addCriterion("action_standard not between", value1, value2, "actionStandard");
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