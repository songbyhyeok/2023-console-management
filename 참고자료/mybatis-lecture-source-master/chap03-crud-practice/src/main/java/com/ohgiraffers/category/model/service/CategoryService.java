package com.ohgiraffers.category.model.service;

import com.ohgiraffers.category.model.dto.CategoryDTO;
import com.ohgiraffers.category.model.mapper.CategoryMapper;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.ohgiraffers.category.common.Template.getSqlSession;

public class CategoryService {
    public List<CategoryDTO> selectAllCategory() {

        SqlSession sqlSession = getSqlSession();

        CategoryMapper categoryMapper = sqlSession.getMapper(CategoryMapper.class);

        List<CategoryDTO> categoryList = categoryMapper.selectAllCategory();

        sqlSession.close();

        return categoryList;
    }

    public CategoryDTO selectCategoryByCode(int code) {

        SqlSession sqlSession = getSqlSession();

        CategoryMapper categoryMapper = sqlSession.getMapper(CategoryMapper.class);
        CategoryDTO category = categoryMapper.selectCategoryByCode(code);

        sqlSession.close();

        return category;
    }

    public boolean registCategory(CategoryDTO category) {

        SqlSession sqlSession = getSqlSession();

        CategoryMapper categoryMapper = sqlSession.getMapper(CategoryMapper.class);
        int result = categoryMapper.insertCategory(category);

        if(result > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }

        sqlSession.close();

        return result > 0;
    }

    public boolean modifyCategory(CategoryDTO category) {
        SqlSession sqlSession = getSqlSession();

        CategoryMapper categoryMapper = sqlSession.getMapper(CategoryMapper.class);
        int result = categoryMapper.updateCategory(category);

        if(result > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }

        sqlSession.close();

        return result > 0;
    }

    public boolean deleteCategory(int code) {

        SqlSession sqlSession = getSqlSession();

        CategoryMapper categoryMapper = sqlSession.getMapper(CategoryMapper.class);
        int result = categoryMapper.deleteCategory(code);

        if(result > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }

        sqlSession.close();

        return result > 0;
    }
}
