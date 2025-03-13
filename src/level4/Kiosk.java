package level4;

import io.Output;


import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;


public class Kiosk {
  // start 라는 함수
  List<Menu> menus;

  // 리스트를 받게 합니다.
  Kiosk(List<Menu> menus) {
    this.menus = menus;
  }

  public void start() {
    Scanner sc = new Scanner(System.in);
    int orderCategory;
    Menu menu;
    while (true) {
      // 리스트와 Menu 클래스 활용하여, 상위 카테고리 메뉴를 출력해야하는 겁니다.
      Output.printOutput("[ Burger King MAIN MENU ]");
      for (int i = 1; i <= menus.size(); i++) {
        System.out.printf("%d. %s\n", i, menus.get(i - 1).getCategoryName());
      }
      Output.printOutput("0. 종료");

      // 값을 받아야한다.
      try {
        orderCategory = sc.nextInt();
        if (orderCategory == 0) {
          break;
        }
        menu = menus.get(orderCategory - 1);
      } catch (InputMismatchException e) {
        Output.printOutput("잘못입력했습니다.");
        sc.nextLine();
        continue;
      } catch (RuntimeException e) {
        Output.printOutput("번호 내에서 입력부탁드립니다.");
        sc.nextLine();
        continue;
      }


      Output.printOutput("[ " + menu.getCategoryName() + " ]");
      menu.viewMenuItems();
      Output.printOutput("0. 뒤로가기.");
      int subExit = 1;
      while (subExit != 0) {
        // int 값 받고 !
        int orderMenuItem;
        try {
          // 이상 없을 경우 출력
          orderMenuItem = sc.nextInt();
          if (orderMenuItem == 0) {
            Output.printLineDivider();
            Output.printOutput("메인 메뉴로 이동합니다.");
          } else {
            // 번호를 받으면 menu.items Get
            List<MenuItem> itemList = menu.getMenuItems();
            System.out.printf("선택한 메뉴: %s | %s | %s \n", itemList.get(orderMenuItem - 1).menuName, itemList.get(orderMenuItem - 1).menuPrice, itemList.get(orderMenuItem - 1).menuDescription);
          }
          break;
        } catch (Exception e) { // 값이 이상할 경우 오류 출력
          System.out.println("값이 이상합니다.");
          sc.nextLine();
        }
      }
      Output.printStepDivider();
    }
    Output.printOutput("종료되었습니다.");
  }
}
