package com.zjuqsc.qscdap.mapper;

import com.zjuqsc.qscdap.model.Order;
import com.zjuqsc.qscdap.model.OrderCriteria.Criteria;
import com.zjuqsc.qscdap.model.OrderCriteria.Criterion;
import com.zjuqsc.qscdap.model.OrderCriteria;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class OrderSqlProvider {

    public String countByExample(OrderCriteria example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("cls_order");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(OrderCriteria example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("cls_order");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(Order record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("cls_order");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.VALUES("create_time", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            sql.VALUES("update_time", "#{updateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getExpireTime() != null) {
            sql.VALUES("expire_time", "#{expireTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getIsExpired() != null) {
            sql.VALUES("is_expired", "#{isExpired,jdbcType=BIT}");
        }
        
        if (record.getIsFinished() != null) {
            sql.VALUES("is_finished", "#{isFinished,jdbcType=BIT}");
        }
        
        if (record.getUserId() != null) {
            sql.VALUES("user_id", "#{userId,jdbcType=VARCHAR}");
        }
        
        if (record.getExpressStation() != null) {
            sql.VALUES("express_station", "#{expressStation,jdbcType=VARCHAR}");
        }
        
        if (record.getExpressCompany() != null) {
            sql.VALUES("express_company", "#{expressCompany,jdbcType=VARCHAR}");
        }
        
        if (record.getShelfNumber() != null) {
            sql.VALUES("shelf_number", "#{shelfNumber,jdbcType=VARCHAR}");
        }
        
        if (record.getTrackingNumber() != null) {
            sql.VALUES("tracking_number", "#{trackingNumber,jdbcType=VARCHAR}");
        }
        
        if (record.getRemarks() != null) {
            sql.VALUES("remarks", "#{remarks,jdbcType=VARCHAR}");
        }
        
        if (record.getOrderTakerId() != null) {
            sql.VALUES("order_taker_id", "#{orderTakerId,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }

    public String selectByExample(OrderCriteria example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("create_time");
        sql.SELECT("update_time");
        sql.SELECT("expire_time");
        sql.SELECT("is_expired");
        sql.SELECT("is_finished");
        sql.SELECT("user_id");
        sql.SELECT("express_station");
        sql.SELECT("express_company");
        sql.SELECT("shelf_number");
        sql.SELECT("tracking_number");
        sql.SELECT("remarks");
        sql.SELECT("order_taker_id");
        sql.FROM("cls_order");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        Order record = (Order) parameter.get("record");
        OrderCriteria example = (OrderCriteria) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("cls_order");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            sql.SET("update_time = #{record.updateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getExpireTime() != null) {
            sql.SET("expire_time = #{record.expireTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getIsExpired() != null) {
            sql.SET("is_expired = #{record.isExpired,jdbcType=BIT}");
        }
        
        if (record.getIsFinished() != null) {
            sql.SET("is_finished = #{record.isFinished,jdbcType=BIT}");
        }
        
        if (record.getUserId() != null) {
            sql.SET("user_id = #{record.userId,jdbcType=VARCHAR}");
        }
        
        if (record.getExpressStation() != null) {
            sql.SET("express_station = #{record.expressStation,jdbcType=VARCHAR}");
        }
        
        if (record.getExpressCompany() != null) {
            sql.SET("express_company = #{record.expressCompany,jdbcType=VARCHAR}");
        }
        
        if (record.getShelfNumber() != null) {
            sql.SET("shelf_number = #{record.shelfNumber,jdbcType=VARCHAR}");
        }
        
        if (record.getTrackingNumber() != null) {
            sql.SET("tracking_number = #{record.trackingNumber,jdbcType=VARCHAR}");
        }
        
        if (record.getRemarks() != null) {
            sql.SET("remarks = #{record.remarks,jdbcType=VARCHAR}");
        }
        
        if (record.getOrderTakerId() != null) {
            sql.SET("order_taker_id = #{record.orderTakerId,jdbcType=VARCHAR}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("cls_order");
        
        sql.SET("id = #{record.id,jdbcType=VARCHAR}");
        sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        sql.SET("update_time = #{record.updateTime,jdbcType=TIMESTAMP}");
        sql.SET("expire_time = #{record.expireTime,jdbcType=TIMESTAMP}");
        sql.SET("is_expired = #{record.isExpired,jdbcType=BIT}");
        sql.SET("is_finished = #{record.isFinished,jdbcType=BIT}");
        sql.SET("user_id = #{record.userId,jdbcType=VARCHAR}");
        sql.SET("express_station = #{record.expressStation,jdbcType=VARCHAR}");
        sql.SET("express_company = #{record.expressCompany,jdbcType=VARCHAR}");
        sql.SET("shelf_number = #{record.shelfNumber,jdbcType=VARCHAR}");
        sql.SET("tracking_number = #{record.trackingNumber,jdbcType=VARCHAR}");
        sql.SET("remarks = #{record.remarks,jdbcType=VARCHAR}");
        sql.SET("order_taker_id = #{record.orderTakerId,jdbcType=VARCHAR}");
        
        OrderCriteria example = (OrderCriteria) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(Order record) {
        SQL sql = new SQL();
        sql.UPDATE("cls_order");
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            sql.SET("update_time = #{updateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getExpireTime() != null) {
            sql.SET("expire_time = #{expireTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getIsExpired() != null) {
            sql.SET("is_expired = #{isExpired,jdbcType=BIT}");
        }
        
        if (record.getIsFinished() != null) {
            sql.SET("is_finished = #{isFinished,jdbcType=BIT}");
        }
        
        if (record.getUserId() != null) {
            sql.SET("user_id = #{userId,jdbcType=VARCHAR}");
        }
        
        if (record.getExpressStation() != null) {
            sql.SET("express_station = #{expressStation,jdbcType=VARCHAR}");
        }
        
        if (record.getExpressCompany() != null) {
            sql.SET("express_company = #{expressCompany,jdbcType=VARCHAR}");
        }
        
        if (record.getShelfNumber() != null) {
            sql.SET("shelf_number = #{shelfNumber,jdbcType=VARCHAR}");
        }
        
        if (record.getTrackingNumber() != null) {
            sql.SET("tracking_number = #{trackingNumber,jdbcType=VARCHAR}");
        }
        
        if (record.getRemarks() != null) {
            sql.SET("remarks = #{remarks,jdbcType=VARCHAR}");
        }
        
        if (record.getOrderTakerId() != null) {
            sql.SET("order_taker_id = #{orderTakerId,jdbcType=VARCHAR}");
        }
        
        sql.WHERE("id = #{id,jdbcType=VARCHAR}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, OrderCriteria example, boolean includeExamplePhrase) {
        if (example == null) {
            return;
        }
        
        String parmPhrase1;
        String parmPhrase1_th;
        String parmPhrase2;
        String parmPhrase2_th;
        String parmPhrase3;
        String parmPhrase3_th;
        if (includeExamplePhrase) {
            parmPhrase1 = "%s #{example.oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{example.oredCriteria[%d].allCriteria[%d].value} and #{example.oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{example.oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{example.oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{example.oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        } else {
            parmPhrase1 = "%s #{oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{oredCriteria[%d].allCriteria[%d].value} and #{oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        }
        
        StringBuilder sb = new StringBuilder();
        List<Criteria> oredCriteria = example.getOredCriteria();
        boolean firstCriteria = true;
        for (int i = 0; i < oredCriteria.size(); i++) {
            Criteria criteria = oredCriteria.get(i);
            if (criteria.isValid()) {
                if (firstCriteria) {
                    firstCriteria = false;
                } else {
                    sb.append(" or ");
                }
                
                sb.append('(');
                List<Criterion> criterions = criteria.getAllCriteria();
                boolean firstCriterion = true;
                for (int j = 0; j < criterions.size(); j++) {
                    Criterion criterion = criterions.get(j);
                    if (firstCriterion) {
                        firstCriterion = false;
                    } else {
                        sb.append(" and ");
                    }
                    
                    if (criterion.isNoValue()) {
                        sb.append(criterion.getCondition());
                    } else if (criterion.isSingleValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase1, criterion.getCondition(), i, j));
                        } else {
                            sb.append(String.format(parmPhrase1_th, criterion.getCondition(), i, j,criterion.getTypeHandler()));
                        }
                    } else if (criterion.isBetweenValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase2, criterion.getCondition(), i, j, i, j));
                        } else {
                            sb.append(String.format(parmPhrase2_th, criterion.getCondition(), i, j, criterion.getTypeHandler(), i, j, criterion.getTypeHandler()));
                        }
                    } else if (criterion.isListValue()) {
                        sb.append(criterion.getCondition());
                        sb.append(" (");
                        List<?> listItems = (List<?>) criterion.getValue();
                        boolean comma = false;
                        for (int k = 0; k < listItems.size(); k++) {
                            if (comma) {
                                sb.append(", ");
                            } else {
                                comma = true;
                            }
                            if (criterion.getTypeHandler() == null) {
                                sb.append(String.format(parmPhrase3, i, j, k));
                            } else {
                                sb.append(String.format(parmPhrase3_th, i, j, k, criterion.getTypeHandler()));
                            }
                        }
                        sb.append(')');
                    }
                }
                sb.append(')');
            }
        }
        
        if (sb.length() > 0) {
            sql.WHERE(sb.toString());
        }
    }
}