package com.ohgiraffers.section02.provider;

import com.ohgiraffers.common.MenuDTO;
import org.apache.ibatis.session.SqlSession;

import static com.ohgiraffers.common.Template.getSqlSession;

public class SqlBuilderService {

    private SqlBuilderMapper mapper;

    public void registMenu(MenuDTO menu) {

        SqlSession sqlSession = getSqlSession();
        mapper = sqlSession.getMapper(SqlBuilderMapper.class);

        int result = mapper.registMenu(menu);
        
        if(result > 0) {
            sqlSession.commit();
            System.out.println("신규 메뉴 등록 성공");
        } else {
            sqlSession.rollback();
            System.out.println("신규 메뉴 등록 실패");
        }
        
        sqlSession.close();

    }

    public void modifyMenu(MenuDTO menu) {

        SqlSession sqlSession = getSqlSession();
        mapper = sqlSession.getMapper(SqlBuilderMapper.class);

        int result = mapper.modifyMenu(menu);

        if(result > 0) {
            sqlSession.commit();
            System.out.println("메뉴 수정 성공");
        } else {
            sqlSession.rollback();
            System.out.println("메뉴 수정 실패");
        }

        sqlSession.close();

    }

    public void deleteMenu(int code) {

        SqlSession sqlSession = getSqlSession();
        mapper = sqlSession.getMapper(SqlBuilderMapper.class);

        int result = mapper.deleteMenu(code);

        if(result > 0) {
            sqlSession.commit();
            System.out.println("메뉴 삭제 성공");
        } else {
            sqlSession.rollback();
            System.out.println("메뉴 삭제 실패");
        }

        sqlSession.close();
    }
}
