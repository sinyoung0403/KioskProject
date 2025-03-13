package level5;

import io.Input;
import io.Output;

import java.util.Scanner;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Kiosk {
  private final List<Menu> menus;

  // Constructor
  Kiosk(List<Menu> menus) {
    this.menus = menus;
  }

  public void start() {
    Scanner sc = new Scanner(System.in);
    int orderCategory;
    Menu menu;
    while (true) {
      Output.printOutput("[ Burger King | MAIN MENU ]");
      showAllCategory();
      Output.printOutput("0. 종료");
      try {
        orderCategory = Input.getInput();
        if (orderCategory == 0) { // Exit on input 0
          break;
        }
        menu = getSpecificMenus(orderCategory - 1);

        Output.printOutput("[ " + menu.getCategoryName() + " ] 를 선택했습니다.");
        Output.printLineDivider();
        Output.printOutput("[ " + menu.getCategoryName() + " ]");

        menu.showMenuItems();
        Output.printOutput("0. 뒤로가기.");

        int orderMenuItem = Input.getInput();
        if (orderMenuItem == 0) {
          Output.printLineDivider();
          Output.printMainBack();
        } else {
          // Show Choice Menu
          menu.displaySelectedMenu(orderMenuItem - 1);
        }
      } catch (IndexOutOfBoundsException e) { // Range Error
        Output.printOutput("번호 내에서 입력부탁드립니다.");
        continue;
      }
      Output.printStepDivider();
    }
    Output.printOutput("종료되었습니다.");
  }

  // Function to show all categories
  public void showAllCategory() {
    AtomicInteger index = new AtomicInteger(1);
    menus.forEach(menu -> Output.printfCategoryOutput(index.getAndIncrement(), menu.getCategoryName()));
  }

  // Get specific menus
  public Menu getSpecificMenus(Integer index) {
    return menus.get(index);
  }
}
