package level6;

import io.Input;
import io.Output;
import level6.Cart.Cart;
import level6.Menu.Menu;
import level6.Menu.MenuItem;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Kiosk {
  private final List<Menu> menus;

  // Constructor
  Kiosk() {
    this.menus = init();
  }

  List<Menu> init() {
    // Menu
    Menu burger = new Menu("Burger \uD83C\uDF54");
    Menu drink = new Menu("Drink \uD83E\uDD64");
    Menu desert = new Menu("Desert \uD83C\uDF5F");

    // Burger
    burger.addMenuItems(new MenuItem("Whopper", 7100, "버거킹의 대표 메뉴로, 두툼한 패티와 신선한 채소가 어우러져 클래식한 맛을 제공하는 와퍼"));
    burger.addMenuItems(new MenuItem("Quattro Cheese Whopper", 7900, "네 가지 치즈가 어우러져 진한 치즈 풍미를 느낄 수 있는 와퍼"));
    burger.addMenuItems(new MenuItem("Monster Whopper", 9300, "두툼한 더블 패티와 바삭한 베이컨, 매콤한 소스로 강렬한 맛을 자랑하는 와퍼"));
    burger.addMenuItems(new MenuItem("Whole Shrimp Whopper", 7900, "탱글탱글한 통새우와 신선한 야채가 어우러져 해산물의 풍미를 느낄 수 있는 버거"));
    burger.addMenuItems(new MenuItem("Whopper Jr", 4700, "클래식 와퍼의 맛을 그대로 담은 작은 사이즈의 버거"));

    // Drink
    drink.addMenuItems(new MenuItem("Americano", 1500, "진하고 깔끔한 커피 본연의 맛을 즐길 수 있는 음료"));
    drink.addMenuItems(new MenuItem("Vanilla Sundae Ice Cream", 2000, "부드러운 바닐라 아이스크림"));
    drink.addMenuItems(new MenuItem("Choco Sundae Ice Cream", 2200, "진한 초콜릿 아이스크림에 달콤한 초콜릿 시럽을 더한 디저트"));
    drink.addMenuItems(new MenuItem("Soft Drink", 2000, "시원하고 청량감 넘치는 탄산이 가득한 음료"));

    // Desert
    desert.addMenuItems(new MenuItem("French Fries", 2100, "바삭하고 황금빛으로 튀겨진 감자"));
    desert.addMenuItems(new MenuItem("21cm Cheese Sticks", 2500, "길고 바삭한 치즈스틱 속에 쭉 늘어나는 고소한 치즈가 가득"));
    desert.addMenuItems(new MenuItem("Nugget King(4ea)", 2200, "바삭하고 황금빛으로 튀겨진 맛있는 치킨 너겟"));
    desert.addMenuItems(new MenuItem("Coconut Shrimp(3ea)", 3900, " 코코넛 튀김옷을 입혀 바삭하게 튀긴 새우로, 달콤하고 고소한 맛이 특징"));

    return new ArrayList<>(Arrays.asList(drink, burger, desert));
  }

  public void start() {
    Cart cart = new Cart();
    int orderCategory;
    Menu menu;
    boolean isMainLoopRunning = true;
    while (isMainLoopRunning) { // while Start
      Output.printOutput("[ Burger King | MAIN MENU ]");
      showAllCategory();
      if (cart.cartItemsNotEmpty()) {
        Output.printOutput("4. Orders     | 장바구니를 확인 후 주문합니다.");
        Output.printOutput("5. Cancel     | 진행중인 주문을 취소합니다.");
      }
      Output.printOutput("0. Exit       | 종료합니다.");
      try {
        orderCategory = Input.getInput();
        switch (orderCategory) {
          case 0 -> {
            isMainLoopRunning = false;
            continue;
          }
          case 4 -> {
            if (!cart.cartItemsNotEmpty()) {
              Output.printOutOfRange();
              continue;
            }

            cart.showCartItems();
            Output.printOutput("1. 주문하기     | 2. 메뉴판으로 돌아가기");

            switch (Input.getInput()) {
              case 1 -> {
                Output.printfStringOutput("주문이 완료되었습니다.", "총 금액: " + Integer.toString(cart.getTotalPrice()));
                cart.clearCartItems();
              }
              case 2 -> {
              }
              default -> Output.printOutOfRange();
            }

            Output.printMainBack();
            continue;
          }
          case 5 -> {
            if (cart.cartItemsNotEmpty()) {
              cart.clearCartItems();
              Output.printOutput("장바구니를 취소했습니다.");
            } else {
              Output.printOutOfRange();
            }
            Output.printMainBack();
            Output.printStepDivider();
            continue;
          }
          default -> menu = getSpecificMenus(orderCategory - 1);
        }

        Output.printOutput("[ " + menu.getCategoryName() + " ] 를 선택했습니다. \n");
        Output.printLineDivider();
        Output.printOutput("[ Burger King | " + menu.getCategoryName() + " Menu ]");
        menu.showMenuItems();
        Output.printOutput("0. 뒤로가기.");

        int orderMenuItem = Input.getInput();

        if (orderMenuItem == 0) {
          Output.printMainBack();
          Output.printLineDivider();
        } else {
          menu.displaySelectedMenu(orderMenuItem - 1);
          Output.printOutput("위 메뉴를 장바구니에 추가하시겠습니까?" + "\n1. 확인        | 2. 취소");
          int categoryStatus = Input.getInput();
          switch (categoryStatus) {
            case 1 -> cart.addCartItems(getSpecificMenuItem(menu, orderMenuItem - 1));
            case 2 -> Output.printOutput("장바구니에 담지 않았습니다.");
            default -> Output.printOutOfRange();
          }
          Output.printMainBack();
        }

      } catch (IndexOutOfBoundsException e) { // Range Error
        Output.printOutput("번호 내에서 입력부탁드립니다.");
        continue;
      } catch (RuntimeException e) { // Input Error - Print error message in input.java
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

  public MenuItem getSpecificMenuItem(Menu menu, Integer index) {
    return menu.getMenuItems().get(index);
  }
}
