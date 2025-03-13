package level2;

import java.awt.*;
import java.util.*;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    // List 선언 및 초기화
    List<MenuItem> menuItems = new ArrayList<>();

    // add 함수를 통해 new MenuItem() List 에 삽입
    menuItems.add(new MenuItem("Whopper™", 7100, "버거킹의 대표 메뉴로, 두툼한 패티와 신선한 채소가 어우러져 클래식한 맛을 제공하는 와퍼"));
    menuItems.add(new MenuItem("Quattro Cheese Whopper", 7900, "네 가지 치즈가 어우러져 진한 치즈 풍미를 느낄 수 있는 와퍼"));
    menuItems.add(new MenuItem("Monster Whopper", 9300, "두툼한 더블 패티와 바삭한 베이컨, 매콤한 소스로 강렬한 맛을 자랑하는 와퍼"));
    menuItems.add(new MenuItem("Whole Shrimp Whopper", 7900, "탱글탱글한 통새우와 신선한 야채가 어우러져 해산물의 풍미를 느낄 수 있는 버거"));
    menuItems.add(new MenuItem("Whopper Jr", 4700, "클래식 와퍼의 맛을 그대로 담은 작은 사이즈의 버거"));

    // Scanner 선언, 변수 선언
    Scanner sc = new Scanner(System.in);
    int exit = 1;
    int inputNumber;

    // 반복문을 활용해 List 안에 있는 Menu Item 하나씩 출력
    while (exit != 0) {
      System.out.println("[ Burger King Menu ]");
      int i = 1;
      for (MenuItem a : menuItems) {
        System.out.printf("%-25s | %d원 | %s\n", i + ". " + a.menuName, a.menuPrice, a.menuDescription);
        i++;
      }
      System.out.printf("%s | %s", "0. 종료", "0\n");
      System.out.println("주문을 입력해주세요.");

      inputNumber = sc.nextInt();

      System.out.print("선택한 메뉴: ");
      switch (inputNumber) {
        case 1 ->
                System.out.printf("%s | 가격: %d | 설명: %s\n", menuItems.get(0).menuName, menuItems.get(0).menuPrice, menuItems.get(0).menuDescription);
        case 2 ->
                System.out.printf("%s | 가격: %d | 설명: %s\n", menuItems.get(1).menuName, menuItems.get(1).menuPrice, menuItems.get(1).menuDescription);
        case 3 ->
                System.out.printf("%s | 가격: %d | 설명: %s\n", menuItems.get(2).menuName, menuItems.get(2).menuPrice, menuItems.get(2).menuDescription);
        case 4 ->
                System.out.printf("%s | 가격: %d | 설명: %s\n", menuItems.get(3).menuName, menuItems.get(3).menuPrice, menuItems.get(3).menuDescription);
        case 5 ->
                System.out.printf("%s | 가격: %d | 설명: %s\n", menuItems.get(4).menuName, menuItems.get(4).menuPrice, menuItems.get(4).menuDescription);
        case 0 -> exit = 0;
        default -> System.out.println("잘못입력하셨습니다.");
      }
    }
    System.out.println("주문이 종료되었습니다. ");
  }
}
