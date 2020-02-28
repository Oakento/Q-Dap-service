package com.zjuqsc.qscdap.mapper;

import com.zjuqsc.qscdap.model.OrderNotice;
import com.zjuqsc.qscdap.model.OrderNoticeCriteria.Criteria;
import com.zjuqsc.qscdap.model.OrderNoticeCriteria.Criterion;
import com.zjuqsc.qscdap.model.OrderNoticeCriteria;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class OrderNoticeSqlProvider {

    public String countByExample(OrderNoticeCriteria example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("order_notice");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(OrderNoticeCriteria example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("order_notice");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(OrderNotice record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("order_notice");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=VARCHAR}");
        }
        
        if (record.getType() != null) {
            sql.VALUES("type", "#{type,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.VALUES("create_time", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getOrderId() != null) {
            sql.VALUES("order_id", "#{orderId,jdbcType=VARCHAR}");
        }
        
        if (record.getMainUserId() != null) {
            sql.VALUES("main_user_id", "#{mainUserId,jdbcType=VARCHAR}");
        }
        
        if (record.getSubUserId() != null) {
            sql.VALUES("sub_user_id", "#{subUserId,jdbcType=VARCHAR}");
        }
        
        if (record.getIsRead() != null) {
            sql.VALUES("is_read", "#{isRead,jdbcType=BIT}");
        }
        
        return sql.toString();
    }

    public String selectByExample(OrderNoticeCriteria example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("type");
        sql.SELECT("create_time");
        sql.SELECT("order_id");
        sql.SELECT("main_user_id");
        sql.SELECT("sub_user_id");
        sql.SELECT("is_read");
        sql.FROM("order_notice");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        OrderNotice record = (OrderNotice) parameter.get("record");
        OrderNoticeCriteria example = (OrderNoticeCriteria) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("order_notice");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=VARCHAR}");
        }
        
        if (record.getType() != null) {
            sql.SET("type = #{record.type,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getOrderId() != null) {
            sql.SET("order_id = #{record.orderId,jdbcType=VARCHAR}");
        }
        
        if (record.getMainUserId() != null) {
            sql.SET("main_user_id = #{record.mainUserId,jdbcType=VARCHAR}");
        }
        
        if (record.getSubUserId() != null) {
            sql.SET("sub_user_id = #{record.subUserId,jdbcType=VARCHAR}");
        }
        
        if (record.getIsRead() != null) {
            sql.SET("is_read = #{record.isRead,jdbcType=BIT}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("order_notice");
        
        sql.SET("id = #{record.id,jdbcType=VARCHAR}");
        sql.SET("type = #{record.type,jdbcType=VARCHAR}");
        sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        sql.SET("order_id = #{record.orderId,jdbcType=VARCHAR}");
        sql.SET("main_user_id = #{record.mainUserId,jdbcType=VARCHAR}");
        sql.SET("sub_user_id = #{record.subUserId,jdbcType=VARCHAR}");
        sql.SET("is_read = #{record.isRead,jdbcType=BIT}");
        
        OrderNoticeCriteria example = (OrderNoticeCriteria) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(OrderNotice record) {
        SQL sql = new SQL();
        sql.UPDATE("order_notice");
        
        if (record.getType() != null) {
            sql.SET("type = #{type,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getOrderId() != null) {
            sql.SET("order_id = #{orderId,jdbcType=VARCHAR}");
        }
        
        if (record.getMainUserId() != null) {
            sql.SET("main_user_id = #{mainUserId,jdbcType=VARCHAR}");
        }
        
        if (record.getSubUserId() != null) {
            sql.SET("sub_user_id = #{subUserId,jdbcType=VARCHAR}");
        }
        
        if (record.getIsRead() != null) {
            sql.SET("is_read = #{isRead,jdbcType=BIT}");
        }
        
        sql.WHERE("id = #{id,jdbcType=VARCHAR}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, OrderNoticeCriteria example, boolean includeExamplePhrase) {
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