package level5;

import io.Input;
import io.Output;

import java.util.Scanner;
import java.util.*;

public class Kiosk {
  private final List<Menu> menus;

  // Constructor
  Kiosk(List<Menu> menus){
    this.menus = menus;
  }

  public void start() {
    Scanner sc = new Scanner(System.in);
    int orderCategory;
    Menu menu;
    while (true){
      Output.printOutput("[ Burger King | MAIN MENU ]");
      showAllCategory();
      Output.printOutput("0. 종료");
      try {
        orderCategory = Input.getInput();
        if(orderCategory==0){ // Exit on input 0
          break;
        }
        menu = getSpecificMenus(orderCategory-1);
      } catch (IndexOutOfBoundsException e) { // Range Error
        Output.printOutput("번호 내에서 입력부탁드립니다.");
        sc.nextLine();
        continue;
      } catch (RuntimeException e){ // Input Error - Print error message in input.java
        continue;
      }

      Output.printOutput("[ "+menu.getCategoryName()+" ] 를 선택했습니다. \n");
      Output.printLineDivider();
      Output.printOutput("[ "+menu.getCategoryName()+" ]");

      menu.showMenuItems();
      Output.printOutput("0. 뒤로가기.");

      while(true){
        int orderMenuItem;
        try { // Back or print Menu List
          orderMenuItem = Input.getInput();
          if (orderMenuItem == 0) {
            Output.printLineDivider();
            Output.printOutput("메인 메뉴로 이동합니다. \n");
          } else {
            // Show Choice Menu
            menu.displaySelectedMenu(orderMenuItem-1);
          }
          break;
        } catch (IndexOutOfBoundsException e) {// Range Error
          Output.printOutput("번호 내에서 입력부탁드립니다.");
          sc.nextLine();
        } catch (RuntimeException e) { // Input Error - Print error message in input.java
          sc.nextLine();
        }
      }
      Output.printStepDivider();
    }
    Output.printOutput("종료되었습니다.");
  }

  // Function to show all categories
  public void showAllCategory(){
    for (int i=1; i <= menus.size(); i++){
      Output.printfCategoryOutput(i,menus.get(i-1).getCategoryName());
    }
  }

  // Get specific menus
  public Menu getSpecificMenus(Integer index) {
    return menus.get(index);
  }
}
