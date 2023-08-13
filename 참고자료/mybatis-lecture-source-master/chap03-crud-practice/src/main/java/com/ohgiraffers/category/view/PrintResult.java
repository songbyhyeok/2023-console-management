package com.ohgiraffers.category.view;

import com.ohgiraffers.category.model.dto.CategoryDTO;

import java.util.List;

public class PrintResult {

    public void printCategoryList(List<CategoryDTO> categoryList) {

        for (CategoryDTO category : categoryList) {
            System.out.println(category);
        }
    }

    public void printCategory(CategoryDTO category) {

        System.out.println(category);
    }

    public void printSuccessMessage(String successCode) {

        String successMessage = "";

        switch (successCode) {
            case "insert": successMessage = "신규 카테고리 등록을 성공하였습니다."; break;
            case "update": successMessage = "카테고리 수정을 성공하였습니다."; break;
            case "delete": successMessage = "카테고리 삭제를 성공하였습니다."; break;
        }

        System.out.println(successMessage);
    }

    public void printErrorMessage(String errorCode) {

        String errorMessage = "";

        switch (errorCode) {
            case "selectList": errorMessage = "카테고리 목록 조회를 실패하였습니다."; break;
            case "selectOne": errorMessage = "카테고리 조회를 실패하였습니다."; break;
            case "insert": errorMessage = "카테고리 등록을 실패하였습니다."; break;
            case "update": errorMessage = "카테고리 수정을 실패하였습니다."; break;
            case "delete": errorMessage = "카테고리 삭제를 실패하였습니다."; break;
        }

        System.out.println(errorMessage);
    }
}
