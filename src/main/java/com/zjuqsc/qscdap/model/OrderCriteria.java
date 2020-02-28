package com.zjuqsc.qscdap.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrderCriteria() {
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

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
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

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeIsNull() {
            addCriterion("expire_time is null");
            return (Criteria) this;
        }

        public Criteria andExpireTimeIsNotNull() {
            addCriterion("expire_time is not null");
            return (Criteria) this;
        }

        public Criteria andExpireTimeEqualTo(Date value) {
            addCriterion("expire_time =", value, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeNotEqualTo(Date value) {
            addCriterion("expire_time <>", value, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeGreaterThan(Date value) {
            addCriterion("expire_time >", value, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("expire_time >=", value, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeLessThan(Date value) {
            addCriterion("expire_time <", value, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeLessThanOrEqualTo(Date value) {
            addCriterion("expire_time <=", value, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeIn(List<Date> values) {
            addCriterion("expire_time in", values, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeNotIn(List<Date> values) {
            addCriterion("expire_time not in", values, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeBetween(Date value1, Date value2) {
            addCriterion("expire_time between", value1, value2, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeNotBetween(Date value1, Date value2) {
            addCriterion("expire_time not between", value1, value2, "expireTime");
            return (Criteria) this;
        }

        public Criteria andIsTakenIsNull() {
            addCriterion("is_taken is null");
            return (Criteria) this;
        }

        public Criteria andIsTakenIsNotNull() {
            addCriterion("is_taken is not null");
            return (Criteria) this;
        }

        public Criteria andIsTakenEqualTo(Boolean value) {
            addCriterion("is_taken =", value, "isTaken");
            return (Criteria) this;
        }

        public Criteria andIsTakenNotEqualTo(Boolean value) {
            addCriterion("is_taken <>", value, "isTaken");
            return (Criteria) this;
        }

        public Criteria andIsTakenGreaterThan(Boolean value) {
            addCriterion("is_taken >", value, "isTaken");
            return (Criteria) this;
        }

        public Criteria andIsTakenGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_taken >=", value, "isTaken");
            return (Criteria) this;
        }

        public Criteria andIsTakenLessThan(Boolean value) {
            addCriterion("is_taken <", value, "isTaken");
            return (Criteria) this;
        }

        public Criteria andIsTakenLessThanOrEqualTo(Boolean value) {
            addCriterion("is_taken <=", value, "isTaken");
            return (Criteria) this;
        }

        public Criteria andIsTakenIn(List<Boolean> values) {
            addCriterion("is_taken in", values, "isTaken");
            return (Criteria) this;
        }

        public Criteria andIsTakenNotIn(List<Boolean> values) {
            addCriterion("is_taken not in", values, "isTaken");
            return (Criteria) this;
        }

        public Criteria andIsTakenBetween(Boolean value1, Boolean value2) {
            addCriterion("is_taken between", value1, value2, "isTaken");
            return (Criteria) this;
        }

        public Criteria andIsTakenNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_taken not between", value1, value2, "isTaken");
            return (Criteria) this;
        }

        public Criteria andIsConfirmedIsNull() {
            addCriterion("is_confirmed is null");
            return (Criteria) this;
        }

        public Criteria andIsConfirmedIsNotNull() {
            addCriterion("is_confirmed is not null");
            return (Criteria) this;
        }

        public Criteria andIsConfirmedEqualTo(Boolean value) {
            addCriterion("is_confirmed =", value, "isConfirmed");
            return (Criteria) this;
        }

        public Criteria andIsConfirmedNotEqualTo(Boolean value) {
            addCriterion("is_confirmed <>", value, "isConfirmed");
            return (Criteria) this;
        }

        public Criteria andIsConfirmedGreaterThan(Boolean value) {
            addCriterion("is_confirmed >", value, "isConfirmed");
            return (Criteria) this;
        }

        public Criteria andIsConfirmedGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_confirmed >=", value, "isConfirmed");
            return (Criteria) this;
        }

        public Criteria andIsConfirmedLessThan(Boolean value) {
            addCriterion("is_confirmed <", value, "isConfirmed");
            return (Criteria) this;
        }

        public Criteria andIsConfirmedLessThanOrEqualTo(Boolean value) {
            addCriterion("is_confirmed <=", value, "isConfirmed");
            return (Criteria) this;
        }

        public Criteria andIsConfirmedIn(List<Boolean> values) {
            addCriterion("is_confirmed in", values, "isConfirmed");
            return (Criteria) this;
        }

        public Criteria andIsConfirmedNotIn(List<Boolean> values) {
            addCriterion("is_confirmed not in", values, "isConfirmed");
            return (Criteria) this;
        }

        public Criteria andIsConfirmedBetween(Boolean value1, Boolean value2) {
            addCriterion("is_confirmed between", value1, value2, "isConfirmed");
            return (Criteria) this;
        }

        public Criteria andIsConfirmedNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_confirmed not between", value1, value2, "isConfirmed");
            return (Criteria) this;
        }

        public Criteria andIsFinishedIsNull() {
            addCriterion("is_finished is null");
            return (Criteria) this;
        }

        public Criteria andIsFinishedIsNotNull() {
            addCriterion("is_finished is not null");
            return (Criteria) this;
        }

        public Criteria andIsFinishedEqualTo(Boolean value) {
            addCriterion("is_finished =", value, "isFinished");
            return (Criteria) this;
        }

        public Criteria andIsFinishedNotEqualTo(Boolean value) {
            addCriterion("is_finished <>", value, "isFinished");
            return (Criteria) this;
        }

        public Criteria andIsFinishedGreaterThan(Boolean value) {
            addCriterion("is_finished >", value, "isFinished");
            return (Criteria) this;
        }

        public Criteria andIsFinishedGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_finished >=", value, "isFinished");
            return (Criteria) this;
        }

        public Criteria andIsFinishedLessThan(Boolean value) {
            addCriterion("is_finished <", value, "isFinished");
            return (Criteria) this;
        }

        public Criteria andIsFinishedLessThanOrEqualTo(Boolean value) {
            addCriterion("is_finished <=", value, "isFinished");
            return (Criteria) this;
        }

        public Criteria andIsFinishedIn(List<Boolean> values) {
            addCriterion("is_finished in", values, "isFinished");
            return (Criteria) this;
        }

        public Criteria andIsFinishedNotIn(List<Boolean> values) {
            addCriterion("is_finished not in", values, "isFinished");
            return (Criteria) this;
        }

        public Criteria andIsFinishedBetween(Boolean value1, Boolean value2) {
            addCriterion("is_finished between", value1, value2, "isFinished");
            return (Criteria) this;
        }

        public Criteria andIsFinishedNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_finished not between", value1, value2, "isFinished");
            return (Criteria) this;
        }

        public Criteria andIsExpiredIsNull() {
            addCriterion("is_expired is null");
            return (Criteria) this;
        }

        public Criteria andIsExpiredIsNotNull() {
            addCriterion("is_expired is not null");
            return (Criteria) this;
        }

        public Criteria andIsExpiredEqualTo(Boolean value) {
            addCriterion("is_expired =", value, "isExpired");
            return (Criteria) this;
        }

        public Criteria andIsExpiredNotEqualTo(Boolean value) {
            addCriterion("is_expired <>", value, "isExpired");
            return (Criteria) this;
        }

        public Criteria andIsExpiredGreaterThan(Boolean value) {
            addCriterion("is_expired >", value, "isExpired");
            return (Criteria) this;
        }

        public Criteria andIsExpiredGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_expired >=", value, "isExpired");
            return (Criteria) this;
        }

        public Criteria andIsExpiredLessThan(Boolean value) {
            addCriterion("is_expired <", value, "isExpired");
            return (Criteria) this;
        }

        public Criteria andIsExpiredLessThanOrEqualTo(Boolean value) {
            addCriterion("is_expired <=", value, "isExpired");
            return (Criteria) this;
        }

        public Criteria andIsExpiredIn(List<Boolean> values) {
            addCriterion("is_expired in", values, "isExpired");
            return (Criteria) this;
        }

        public Criteria andIsExpiredNotIn(List<Boolean> values) {
            addCriterion("is_expired not in", values, "isExpired");
            return (Criteria) this;
        }

        public Criteria andIsExpiredBetween(Boolean value1, Boolean value2) {
            addCriterion("is_expired between", value1, value2, "isExpired");
            return (Criteria) this;
        }

        public Criteria andIsExpiredNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_expired not between", value1, value2, "isExpired");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(String value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(String value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(String value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(String value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(String value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLike(String value) {
            addCriterion("user_id like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotLike(String value) {
            addCriterion("user_id not like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<String> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<String> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(String value1, String value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(String value1, String value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andExpressStationIsNull() {
            addCriterion("express_station is null");
            return (Criteria) this;
        }

        public Criteria andExpressStationIsNotNull() {
            addCriterion("express_station is not null");
            return (Criteria) this;
        }

        public Criteria andExpressStationEqualTo(String value) {
            addCriterion("express_station =", value, "expressStation");
            return (Criteria) this;
        }

        public Criteria andExpressStationNotEqualTo(String value) {
            addCriterion("express_station <>", value, "expressStation");
            return (Criteria) this;
        }

        public Criteria andExpressStationGreaterThan(String value) {
            addCriterion("express_station >", value, "expressStation");
            return (Criteria) this;
        }

        public Criteria andExpressStationGreaterThanOrEqualTo(String value) {
            addCriterion("express_station >=", value, "expressStation");
            return (Criteria) this;
        }

        public Criteria andExpressStationLessThan(String value) {
            addCriterion("express_station <", value, "expressStation");
            return (Criteria) this;
        }

        public Criteria andExpressStationLessThanOrEqualTo(String value) {
            addCriterion("express_station <=", value, "expressStation");
            return (Criteria) this;
        }

        public Criteria andExpressStationLike(String value) {
            addCriterion("express_station like", value, "expressStation");
            return (Criteria) this;
        }

        public Criteria andExpressStationNotLike(String value) {
            addCriterion("express_station not like", value, "expressStation");
            return (Criteria) this;
        }

        public Criteria andExpressStationIn(List<String> values) {
            addCriterion("express_station in", values, "expressStation");
            return (Criteria) this;
        }

        public Criteria andExpressStationNotIn(List<String> values) {
            addCriterion("express_station not in", values, "expressStation");
            return (Criteria) this;
        }

        public Criteria andExpressStationBetween(String value1, String value2) {
            addCriterion("express_station between", value1, value2, "expressStation");
            return (Criteria) this;
        }

        public Criteria andExpressStationNotBetween(String value1, String value2) {
            addCriterion("express_station not between", value1, value2, "expressStation");
            return (Criteria) this;
        }

        public Criteria andExpressCompanyIsNull() {
            addCriterion("express_company is null");
            return (Criteria) this;
        }

        public Criteria andExpressCompanyIsNotNull() {
            addCriterion("express_company is not null");
            return (Criteria) this;
        }

        public Criteria andExpressCompanyEqualTo(String value) {
            addCriterion("express_company =", value, "expressCompany");
            return (Criteria) this;
        }

        public Criteria andExpressCompanyNotEqualTo(String value) {
            addCriterion("express_company <>", value, "expressCompany");
            return (Criteria) this;
        }

        public Criteria andExpressCompanyGreaterThan(String value) {
            addCriterion("express_company >", value, "expressCompany");
            return (Criteria) this;
        }

        public Criteria andExpressCompanyGreaterThanOrEqualTo(String value) {
            addCriterion("express_company >=", value, "expressCompany");
            return (Criteria) this;
        }

        public Criteria andExpressCompanyLessThan(String value) {
            addCriterion("express_company <", value, "expressCompany");
            return (Criteria) this;
        }

        public Criteria andExpressCompanyLessThanOrEqualTo(String value) {
            addCriterion("express_company <=", value, "expressCompany");
            return (Criteria) this;
        }

        public Criteria andExpressCompanyLike(String value) {
            addCriterion("express_company like", value, "expressCompany");
            return (Criteria) this;
        }

        public Criteria andExpressCompanyNotLike(String value) {
            addCriterion("express_company not like", value, "expressCompany");
            return (Criteria) this;
        }

        public Criteria andExpressCompanyIn(List<String> values) {
            addCriterion("express_company in", values, "expressCompany");
            return (Criteria) this;
        }

        public Criteria andExpressCompanyNotIn(List<String> values) {
            addCriterion("express_company not in", values, "expressCompany");
            return (Criteria) this;
        }

        public Criteria andExpressCompanyBetween(String value1, String value2) {
            addCriterion("express_company between", value1, value2, "expressCompany");
            return (Criteria) this;
        }

        public Criteria andExpressCompanyNotBetween(String value1, String value2) {
            addCriterion("express_company not between", value1, value2, "expressCompany");
            return (Criteria) this;
        }

        public Criteria andShelfNumberIsNull() {
            addCriterion("shelf_number is null");
            return (Criteria) this;
        }

        public Criteria andShelfNumberIsNotNull() {
            addCriterion("shelf_number is not null");
            return (Criteria) this;
        }

        public Criteria andShelfNumberEqualTo(String value) {
            addCriterion("shelf_number =", value, "shelfNumber");
            return (Criteria) this;
        }

        public Criteria andShelfNumberNotEqualTo(String value) {
            addCriterion("shelf_number <>", value, "shelfNumber");
            return (Criteria) this;
        }

        public Criteria andShelfNumberGreaterThan(String value) {
            addCriterion("shelf_number >", value, "shelfNumber");
            return (Criteria) this;
        }

        public Criteria andShelfNumberGreaterThanOrEqualTo(String value) {
            addCriterion("shelf_number >=", value, "shelfNumber");
            return (Criteria) this;
        }

        public Criteria andShelfNumberLessThan(String value) {
            addCriterion("shelf_number <", value, "shelfNumber");
            return (Criteria) this;
        }

        public Criteria andShelfNumberLessThanOrEqualTo(String value) {
            addCriterion("shelf_number <=", value, "shelfNumber");
            return (Criteria) this;
        }

        public Criteria andShelfNumberLike(String value) {
            addCriterion("shelf_number like", value, "shelfNumber");
            return (Criteria) this;
        }

        public Criteria andShelfNumberNotLike(String value) {
            addCriterion("shelf_number not like", value, "shelfNumber");
            return (Criteria) this;
        }

        public Criteria andShelfNumberIn(List<String> values) {
            addCriterion("shelf_number in", values, "shelfNumber");
            return (Criteria) this;
        }

        public Criteria andShelfNumberNotIn(List<String> values) {
            addCriterion("shelf_number not in", values, "shelfNumber");
            return (Criteria) this;
        }

        public Criteria andShelfNumberBetween(String value1, String value2) {
            addCriterion("shelf_number between", value1, value2, "shelfNumber");
            return (Criteria) this;
        }

        public Criteria andShelfNumberNotBetween(String value1, String value2) {
            addCriterion("shelf_number not between", value1, value2, "shelfNumber");
            return (Criteria) this;
        }

        public Criteria andTrackingNumberIsNull() {
            addCriterion("tracking_number is null");
            return (Criteria) this;
        }

        public Criteria andTrackingNumberIsNotNull() {
            addCriterion("tracking_number is not null");
            return (Criteria) this;
        }

        public Criteria andTrackingNumberEqualTo(String value) {
            addCriterion("tracking_number =", value, "trackingNumber");
            return (Criteria) this;
        }

        public Criteria andTrackingNumberNotEqualTo(String value) {
            addCriterion("tracking_number <>", value, "trackingNumber");
            return (Criteria) this;
        }

        public Criteria andTrackingNumberGreaterThan(String value) {
            addCriterion("tracking_number >", value, "trackingNumber");
            return (Criteria) this;
        }

        public Criteria andTrackingNumberGreaterThanOrEqualTo(String value) {
            addCriterion("tracking_number >=", value, "trackingNumber");
            return (Criteria) this;
        }

        public Criteria andTrackingNumberLessThan(String value) {
            addCriterion("tracking_number <", value, "trackingNumber");
            return (Criteria) this;
        }

        public Criteria andTrackingNumberLessThanOrEqualTo(String value) {
            addCriterion("tracking_number <=", value, "trackingNumber");
            return (Criteria) this;
        }

        public Criteria andTrackingNumberLike(String value) {
            addCriterion("tracking_number like", value, "trackingNumber");
            return (Criteria) this;
        }

        public Criteria andTrackingNumberNotLike(String value) {
            addCriterion("tracking_number not like", value, "trackingNumber");
            return (Criteria) this;
        }

        public Criteria andTrackingNumberIn(List<String> values) {
            addCriterion("tracking_number in", values, "trackingNumber");
            return (Criteria) this;
        }

        public Criteria andTrackingNumberNotIn(List<String> values) {
            addCriterion("tracking_number not in", values, "trackingNumber");
            return (Criteria) this;
        }

        public Criteria andTrackingNumberBetween(String value1, String value2) {
            addCriterion("tracking_number between", value1, value2, "trackingNumber");
            return (Criteria) this;
        }

        public Criteria andTrackingNumberNotBetween(String value1, String value2) {
            addCriterion("tracking_number not between", value1, value2, "trackingNumber");
            return (Criteria) this;
        }

        public Criteria andRemarksIsNull() {
            addCriterion("remarks is null");
            return (Criteria) this;
        }

        public Criteria andRemarksIsNotNull() {
            addCriterion("remarks is not null");
            return (Criteria) this;
        }

        public Criteria andRemarksEqualTo(String value) {
            addCriterion("remarks =", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotEqualTo(String value) {
            addCriterion("remarks <>", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksGreaterThan(String value) {
            addCriterion("remarks >", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksGreaterThanOrEqualTo(String value) {
            addCriterion("remarks >=", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLessThan(String value) {
            addCriterion("remarks <", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLessThanOrEqualTo(String value) {
            addCriterion("remarks <=", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLike(String value) {
            addCriterion("remarks like", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotLike(String value) {
            addCriterion("remarks not like", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksIn(List<String> values) {
            addCriterion("remarks in", values, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotIn(List<String> values) {
            addCriterion("remarks not in", values, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksBetween(String value1, String value2) {
            addCriterion("remarks between", value1, value2, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotBetween(String value1, String value2) {
            addCriterion("remarks not between", value1, value2, "remarks");
            return (Criteria) this;
        }

        public Criteria andOrderTakerIdIsNull() {
            addCriterion("order_taker_id is null");
            return (Criteria) this;
        }

        public Criteria andOrderTakerIdIsNotNull() {
            addCriterion("order_taker_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrderTakerIdEqualTo(String value) {
            addCriterion("order_taker_id =", value, "orderTakerId");
            return (Criteria) this;
        }

        public Criteria andOrderTakerIdNotEqualTo(String value) {
            addCriterion("order_taker_id <>", value, "orderTakerId");
            return (Criteria) this;
        }

        public Criteria andOrderTakerIdGreaterThan(String value) {
            addCriterion("order_taker_id >", value, "orderTakerId");
            return (Criteria) this;
        }

        public Criteria andOrderTakerIdGreaterThanOrEqualTo(String value) {
            addCriterion("order_taker_id >=", value, "orderTakerId");
            return (Criteria) this;
        }

        public Criteria andOrderTakerIdLessThan(String value) {
            addCriterion("order_taker_id <", value, "orderTakerId");
            return (Criteria) this;
        }

        public Criteria andOrderTakerIdLessThanOrEqualTo(String value) {
            addCriterion("order_taker_id <=", value, "orderTakerId");
            return (Criteria) this;
        }

        public Criteria andOrderTakerIdLike(String value) {
            addCriterion("order_taker_id like", value, "orderTakerId");
            return (Criteria) this;
        }

        public Criteria andOrderTakerIdNotLike(String value) {
            addCriterion("order_taker_id not like", value, "orderTakerId");
            return (Criteria) this;
        }

        public Criteria andOrderTakerIdIn(List<String> values) {
            addCriterion("order_taker_id in", values, "orderTakerId");
            return (Criteria) this;
        }

        public Criteria andOrderTakerIdNotIn(List<String> values) {
            addCriterion("order_taker_id not in", values, "orderTakerId");
            return (Criteria) this;
        }

        public Criteria andOrderTakerIdBetween(String value1, String value2) {
            addCriterion("order_taker_id between", value1, value2, "orderTakerId");
            return (Criteria) this;
        }

        public Criteria andOrderTakerIdNotBetween(String value1, String value2) {
            addCriterion("order_taker_id not between", value1, value2, "orderTakerId");
            return (Criteria) this;
        }
    }

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