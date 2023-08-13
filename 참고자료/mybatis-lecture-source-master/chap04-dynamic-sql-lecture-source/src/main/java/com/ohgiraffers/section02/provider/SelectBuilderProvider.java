package com.ohgiraffers.section02.provider;

import com.ohgiraffers.common.SearchCriteria;
import org.apache.ibatis.jdbc.SQL;

public class SelectBuilderProvider {

    /* SQL문을 문자열 형태로 반환하도록 return 타입을 지정한다. */
    public String selectAllMenu() {

        return new SQL()
                .SELECT("MENU_CODE")
                .SELECT("MENU_NAME")
                .SELECT("MENU_PRICE")
                .SELECT("CATEGORY_CODE")
                .SELECT("ORDERABLE_STATUS")
                .FROM("TBL_MENU")
                .WHERE("ORDERABLE_STATUS = 'Y'")
                .toString();
    }

    public String searchMenuByCondition(SearchCriteria searchCriteria) {

        SQL sql = new SQL();

        sql.SELECT("MENU_CODE")
            .SELECT("MENU_NAME")
            .SELECT("MENU_PRICE")
            .SELECT("CATEGORY_CODE")
            .SELECT("ORDERABLE_STATUS")
            .FROM("TBL_MENU");

        if("category".equals(searchCriteria.getCondition())) {
            sql.JOIN("TBL_CATEGORY USING(CATEGORY_CODE)")
                    .WHERE("ORDERABLE_STATUS = 'Y'")
                    .AND()
                    .WHERE("CATEGORY_NAME = #{ value }");
        } else if("name".equals(searchCriteria.getCondition())) {
            /* 가변인자를 사용하면 자동적으로 AND로 처리하므로 OR를 사용해야 하는 경우에는 OR()를 사용 */
            sql.WHERE("ORDERABLE_STATUS = 'Y'"
                    , "MENU_NAME LIKE '%' || #{ value } || '%'");
        }

        return sql.toString();
    }













}
