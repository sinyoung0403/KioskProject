package level6;
import io.Input;
import io.Output;

import java.util.*;

public class Kiosk {
  private final List<Menu> menus;

  // Constructor
  Kiosk(List<Menu> menus){
    this.menus = menus;
  }

  public void start() {
    Cart cart = new Cart();
    int orderCategory;
    Menu menu;
    boolean isMainLoopRunning = true;
    while (isMainLoopRunning){ // while Start
      Output.printOutput("[ Burger King | MAIN MENU ]");
      showAllCategory();
      if (cart.cartItemsNotEmpty()) {
        Output.printOutput("4. Orders     | 장바구니를 확인 후 주문합니다.");
        Output.printOutput("5. Cancel     | 진행중인 주문을 취소합니다.");
      }
      Output.printOutput("0. Exit       | 종료합니다.");
      try {
        orderCategory = Input.getInput();
        Input.printNextLine();
        switch (orderCategory) {
          case 0 -> {
            isMainLoopRunning = false;
            continue;
          }
          case 4 -> {
            if (!cart.cartItemsNotEmpty()) {
              throw new IndexOutOfBoundsException();
            }
            cart.showCartItems();
            Output.printOutput("1. 주문하기     | 2. 메뉴판으로 돌아가기");
            int orderConfirmation = Input.getInput();
            switch (orderConfirmation) {
              case 1 -> {
                Output.printfStringOutput("주문이 완료되었습니다.", "총 금액: " + Integer.toString(cart.getTotalPrice()));
                cart.clearCartItems();
                Output.printOutput("메뉴판으로 돌아갑니다. \n");
                continue;
              }
               case 2 -> {
                System.out.println("메뉴판으로 돌아갑니다.");
                continue;
              }
              default -> throw new IndexOutOfBoundsException();
            }
          }
          case 5 -> {
            if(cart.cartItemsNotEmpty()) {
              cart.clearCartItems();
              Output.printOutput("장바구니를 취소했습니다. \n메뉴판으로 돌아갑니다.");
              Output.printStepDivider();
            } else {
              throw new IndexOutOfBoundsException();
            }
            continue;
          }
          default -> menu = getSpecificMenus(orderCategory-1);
        }
      } catch (IndexOutOfBoundsException e) { // Range Error
        Output.printOutput("번호 내에서 입력부탁드립니다.");
        Input.printNextLine();
        continue;
      } catch (RuntimeException e) { // Input Error - Print error message in input.java
        continue;
      }

      Output.printOutput("[ "+menu.getCategoryName()+" ] 를 선택했습니다. \n");
      Output.printLineDivider();
      Output.printOutput("[ Burger King | "+menu.getCategoryName()+" Menu ]");

      menu.showMenuItems();
      Output.printOutput("0. 뒤로가기.");
      boolean isSubLoopRunning = true;
      while(isSubLoopRunning){
        int orderMenuItem;
        try { // Back or print Menu List
          orderMenuItem = Input.getInput();
          if (orderMenuItem == 0) {
            Output.printLineDivider();
            Output.printOutput("메인 메뉴로 이동합니다. \n");
          } else {
            menu.displaySelectedMenu(orderMenuItem-1);
            Output.printOutput("위 메뉴를 장바구니에 추가하시겠습니까?"+
                                "\n1. 확인        | 2. 취소");
            int categoryStatus = Input.getInput();
            switch (categoryStatus){
              case 1 -> {
                // Show Choice Menu
                cart.addCartItems(getSpecificMenuItem(menu, orderMenuItem-1));
                isSubLoopRunning = false;
              }
              case 2 -> {
                Output.printOutput("장바구니에 담지 않았습니다. \n[ Main Menu ] 로 돌아갑니다.\n");
                Input.printNextLine();
                isSubLoopRunning = false;
              }
              default -> {
                throw new IndexOutOfBoundsException();
              }
            }
          }
        } catch (IndexOutOfBoundsException e) {// Range Error
          Output.printOutput("번호 내에서 입력부탁드립니다. \n[ Main Menu ] 로 돌아갑니다.\n");
          break;
        } catch (RuntimeException e) { // Input Error - Print error message in input.java
          Output.printOutput("[ Main Menu ] 로 돌아갑니다.\n ");
          break;
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

  public MenuItem getSpecificMenuItem (Menu menu, Integer index){
    return menu.getMenuItems().get(index);
  }
}
