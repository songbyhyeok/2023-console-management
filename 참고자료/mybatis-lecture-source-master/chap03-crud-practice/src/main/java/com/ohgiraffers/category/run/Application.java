package com.ohgiraffers.category.run;

import com.ohgiraffers.category.controller.CategoryController;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        CategoryController categoryController = new CategoryController();

        do {
            System.out.println("=========== 메뉴 관리 ===========");
            System.out.println("1. 카테고리 전체 조회");
            System.out.println("2. 카테고리 코드로 카테고리 조회");
            System.out.println("3. 신규 카테고리 추가");
            System.out.println("4. 카테고리 수정");
            System.out.println("5. 카테고리 삭제");
            System.out.print("카테고리 관리 번호를 입력하세요 : ");
            int no = sc.nextInt();

            switch(no) {
                case 1 : categoryController.selectAllCategory(); break;
                case 2 : categoryController.selectCategoryByCode(inputCategoryCode()); break;
                case 3 : categoryController.registCategory(inputCategory()); break;
                case 4 : categoryController.modifyCategory(inputModifyCategory()); break;
                case 5 : categoryController.deleteCategory(inputCategoryCode()); break;
                default : System.out.println("잘못된 메뉴를 선택하셨습니다."); break;
            }

        } while(true);

    }

    private static Map<String, String> inputCategoryCode() {

        Scanner sc = new Scanner(System.in);
        System.out.print("카테고리 코드를 입력하세요 : ");
        String code = sc.nextLine();

        Map<String, String> parameter = new HashMap<>();
        parameter.put("code", code);

        return parameter;

    }

    private static Map<String, String> inputCategory() {

        Scanner sc = new Scanner(System.in);
        System.out.print("카테고리 이름을 입력하세요 : ");
        String name = sc.nextLine();
        System.out.print("상위 카테고리 코드를 입력하세요 : ");
        String refCategoryCode = sc.nextLine();

        Map<String, String> parameter = new HashMap<>();
        parameter.put("name", name);
        parameter.put("refCategoryCode", refCategoryCode);

        return parameter;

    }

    private static Map<String, String> inputModifyCategory() {

        Scanner sc = new Scanner(System.in);
        System.out.print("수정할 카테고리 코드를 입력하세요 : ");
        String code = sc.nextLine();
        System.out.print("수정할 카테고리 이름을 입력하세요 : ");
        String name = sc.nextLine();
        System.out.print("수정할 상위 카테고리 코드를 입력하세요 : ");
        String refCategoryCode = sc.nextLine();

        Map<String, String> parameter = new HashMap<>();
        parameter.put("code", code);
        parameter.put("name", name);
        parameter.put("refCategoryCode", refCategoryCode);

        return parameter;

    }
}
