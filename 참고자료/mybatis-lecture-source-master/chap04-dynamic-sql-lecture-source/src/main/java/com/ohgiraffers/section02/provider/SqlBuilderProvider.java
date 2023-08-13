package com.ohgiraffers.section02.provider;

import com.ohgiraffers.common.MenuDTO;
import org.apache.ibatis.jdbc.SQL;

public class SqlBuilderProvider {

    public String registMenu(MenuDTO menu) {

        SQL sql = new SQL();

        sql.INSERT_INTO("TBL_MENU")
                .VALUES("MENU_CODE", "SEQ_MENU_CODE.NEXTVAL")
                .VALUES("MENU_NAME", "#{ name }")
                .VALUES("MENU_PRICE", "#{ price }")
                .VALUES("CATEGORY_CODE", "#{ categoryCode }")
                .VALUES("ORDERABLE_STATUS", "#{ orderableStatus }");

        return sql.toString();
    }

    public String modifyMenu(MenuDTO menu) {

        SQL sql = new SQL();

        /* 모든 컬럼을 업데이트 하는 경우 SET() 메소드에 한 번에 가변 인자로 전달 가능하다.
        * 단, 여기에서는 비어있지 않은 값만 업데이트 되는 동적 쿼리를 작성할 예정이므로 별도로 SET() 메소드를 호출한다. */
        sql.UPDATE("TBL_MENU");

        if(menu.getName() != null && !"".equals(menu.getName())) {
            sql.SET("MENU_NAME = #{ name }");
        }

        if(menu.getPrice() > 0) {
            sql.SET("MENU_PRICE = #{ price }");
        }

        if(menu.getCategoryCode() > 0) {
            sql.SET("CATEGORY_CODE = #{ categoryCode }");
        }

        if(menu.getOrderableStatus() != null && !"".equals(menu.getOrderableStatus())) {
            sql.SET("ORDERABLE_STATUS = #{ orderableStatus }");
        }

        sql.WHERE("MENU_CODE = #{ code }");

        return sql.toString();
    }

    public String deleteMenu() {

        SQL sql = new SQL();

        sql.DELETE_FROM("TBL_MENU")
                .WHERE("MENU_CODE = #{ code }");

        return sql.toString();
    }

}









