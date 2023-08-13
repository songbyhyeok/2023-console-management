package com.ohgiraffers.category.controller;

import com.ohgiraffers.category.model.dto.CategoryDTO;
import com.ohgiraffers.category.model.service.CategoryService;
import com.ohgiraffers.category.view.PrintResult;

import java.util.List;
import java.util.Map;

public class CategoryController {

    private final PrintResult printResult;
    private final CategoryService categoryService;

    public CategoryController() {
        printResult = new PrintResult();
        categoryService = new CategoryService();
    }

    public void selectAllCategory() {

        List<CategoryDTO> categoryList = categoryService.selectAllCategory();

        if(categoryList != null) {
            printResult.printCategoryList(categoryList);
        } else {
            printResult.printErrorMessage("selectList");
        }
    }

    public void selectCategoryByCode(Map<String, String> parameter) {
        int code = Integer.parseInt(parameter.get("code"));

        CategoryDTO category = categoryService.selectCategoryByCode(code);

        if(category != null) {
            printResult.printCategory(category);
        } else {
            printResult.printErrorMessage("selectOne");
        }
    }

    public void registCategory(Map<String, String> parameter) {

        String name = parameter.get("name");
        Integer refCategoryCode = Integer.valueOf(parameter.get("refCategoryCode"));

        CategoryDTO category = new CategoryDTO();
        category.setName(name);
        category.setRefCategoryCode(refCategoryCode);

        if(categoryService.registCategory(category)) {
            printResult.printSuccessMessage("insert");
        } else {
            printResult.printErrorMessage("insert");
        }
    }

    public void modifyCategory(Map<String, String> parameter) {

        int code = Integer.parseInt(parameter.get("code"));
        String name = parameter.get("name");
        Integer refCategoryCode = Integer.valueOf(parameter.get("refCategoryCode"));

        CategoryDTO category = new CategoryDTO();
        category.setCode(code);
        category.setName(name);
        category.setRefCategoryCode(refCategoryCode);

        if(categoryService.modifyCategory(category)) {
            printResult.printSuccessMessage("update");
        } else {
            printResult.printErrorMessage("update");
        }

    }

    public void deleteCategory(Map<String, String> parameter) {

        int code = Integer.parseInt(parameter.get("code"));

        if(categoryService.deleteCategory(code)) {
            printResult.printSuccessMessage("delete");
        } else {
            printResult.printErrorMessage("delete");
        }
    }
}
