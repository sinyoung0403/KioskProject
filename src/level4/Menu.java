package level4;

import java.util.*;

public class Menu {
  // 필드 선언
  String categoryName;

  List<MenuItem> menuItems = new ArrayList<>();

  // 생성자
  Menu(String categoryName) {
    this.categoryName = categoryName;
  }

  // 리스트를 순차적으로 보여주는 함수
  public void viewMenuItems() {
    for (int i = 0; i < menuItems.size(); i++) {
      System.out.printf("%-30s | %s원 | %s\n", (i + 1) + ". " + menuItems.get(i).menuName, menuItems.get(i).menuPrice, menuItems.get(i).menuDescription);
    }
  }

  // List를 리턴하는 함수
  public List<MenuItem> getMenuItems() {
    return this.menuItems;
  }

  // 카테고리 이름을 반환
  public String getCategoryName() {
    return this.categoryName;
  }

}
