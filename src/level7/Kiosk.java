package level7;

import io.Input;
import io.Output;
import level7.Menu.Menu;
import level7.Menu.MenuItem;
import level7.cart.Cart;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Kiosk {
  /* field */
  private final List<Menu> menus;

  /* Constructor */
  public Kiosk() {
    this.menus = initMenus();
  }

  // init Menu & MenuItems
  private List<Menu> initMenus() {
    /* Menu */
    Menu burger = new Menu("Burger \uD83C\uDF54");
    Menu drink = new Menu("Drink \uD83E\uDD64");
    Menu desert = new Menu("Desert \uD83C\uDF5F");

    /* Burger */
    burger.addMenuItems(new MenuItem("Whopper", 7100, "버거킹의 대표 메뉴로, 두툼한 패티와 신선한 채소가 어우러져 클래식한 맛을 제공하는 와퍼"));
    burger.addMenuItems(new MenuItem("Quattro Cheese Whopper", 7900, "네 가지 치즈가 어우러져 진한 치즈 풍미를 느낄 수 있는 와퍼"));
    burger.addMenuItems(new MenuItem("Monster Whopper", 9300, "두툼한 더블 패티와 바삭한 베이컨, 매콤한 소스로 강렬한 맛을 자랑하는 와퍼"));
    burger.addMenuItems(new MenuItem("Whole Shrimp Whopper", 7900, "탱글탱글한 통새우와 신선한 야채가 어우러져 해산물의 풍미를 느낄 수 있는 버거"));
    burger.addMenuItems(new MenuItem("Whopper Jr", 4700, "클래식 와퍼의 맛을 그대로 담은 작은 사이즈의 버거"));

    /* Drink */
    drink.addMenuItems(new MenuItem("Americano", 1500, "진하고 깔끔한 커피 본연의 맛을 즐길 수 있는 음료"));
    drink.addMenuItems(new MenuItem("Vanilla Sundae Ice Cream", 2000, "부드러운 바닐라 아이스크림"));
    drink.addMenuItems(new MenuItem("Choco Sundae Ice Cream", 2200, "진한 초콜릿 아이스크림에 달콤한 초콜릿 시럽을 더한 디저트"));
    drink.addMenuItems(new MenuItem("Soft Drink", 2000, "시원하고 청량감 넘치는 탄산이 가득한 음료"));

    /* Desert */
    desert.addMenuItems(new MenuItem("French Fries", 2100, "바삭하고 황금빛으로 튀겨진 감자"));
    desert.addMenuItems(new MenuItem("21cm Cheese Sticks", 2500, "길고 바삭한 치즈스틱 속에 쭉 늘어나는 고소한 치즈가 가득"));
    desert.addMenuItems(new MenuItem("Nugget King(4ea)", 2200, "바삭하고 황금빛으로 튀겨진 맛있는 치킨 너겟"));
    desert.addMenuItems(new MenuItem("Coconut Shrimp(3ea)", 3900, " 코코넛 튀김옷을 입혀 바삭하게 튀긴 새우로, 달콤하고 고소한 맛이 특징"));

    return new ArrayList<>(Arrays.asList(drink, burger, desert));
  }

  // main start
  public void start() {
    Cart cart = new Cart();
    Menu menu = null;
    boolean isMainLoopRunning = true;
    while (isMainLoopRunning) {
      Output.printStepDivider();
      showMainMenu(cart, menu);
      try {
        // process MainMenuSelection
        int orderCategory = Input.getInput();
        switch (orderCategory) {
          case 0 -> {
            isMainLoopRunning = false;
            continue;
          }
          case 4 -> {
            if (cart.isCartEmpty()) {
              Output.printOutOfRange();
            } else {
              confirmOrReturn(cart);
            }
            continue;
          }
          case 5 -> {
            if (!cart.isCartEmpty()) {
              cart.clearCartItems();
              Output.printOutput("장바구니를 취소했습니다.");
              Output.printMainBack();
            } else {
              Output.printOutOfRange();
            }
            continue;
          }
          default -> menu = getSpecificMenus(orderCategory - 1);
        }

        processSubMenuSelection(menu, cart);

      } catch (IndexOutOfBoundsException e) { // Range Error
        Output.printOutput("번호 내에서 입력부탁드립니다. \n");
      } catch (NoSuchElementException e) {
        Output.printOutput("범위 내에서 입력 부탁드립니다.");
      } catch (RuntimeException e) {
        // Input Error - Print error message in input.java
      }
    }
    Output.printOutput("종료되었습니다.");
  }

  /* Getter Start */
  // Get all categories
  public void showAllCategory() {
    AtomicInteger index = new AtomicInteger(1);
    menus.forEach(menu -> System.out.printf("%d. %s\n", index.getAndIncrement(), menu.getCategoryName()));
  }

  // Get specific menus
  public Menu getSpecificMenus(Integer index) {
    return menus.get(index);
  }

  // Get specific menuItems
  public MenuItem getSpecificMenuItem(Menu menu, Integer index) {
    return menu.getMenuItems().get(index);
  }
  /* Getter Finish */

  /* Calculation Logic Function */
  // Show MainMenu
  public void showMainMenu(Cart cart, Menu menu) {
    Output.printOutput("[ Burger King | MAIN MENU ]");
    showAllCategory();
    if (!cart.isCartEmpty()) {
      Output.printOutput("4. Orders     | 장바구니를 확인 후 주문합니다.");
      Output.printOutput("5. Cancel     | 진행중인 주문을 취소합니다.");
    }
    Output.printOutput("0. Exit       | 종료하겠습니다.");
  }

  // Show SubMenu
  public void showSubMenu(Menu menu) {
    Output.printOutput("[ " + menu.getCategoryName() + " ] 를 선택했습니다. \n");
    Output.printLineDivider();
    Output.printOutput("[ Burger King | " + menu.getCategoryName() + " Menu ]");
    menu.showMenuItems();
    Output.printOutput("0. 뒤로가기.");
  }

  /* ✔ Requirements 주문 기능 */
  // Determines whether to finalize the order, remove a specific menu item,
  // or return to the menu screen in the final ordering stage
  // 최종 주문 단계에서 주문을 확정할지, 특정 메뉴를 삭제할지, 메뉴판으로 돌아갈지 결정하는 역할을 하는 함수
  public void confirmOrReturn(Cart cart) {
    cart.showCartItems();
    Output.printOutput("1. 주문하기     | 2. 메뉴판으로 돌아가기     | 3. 장바구니 메뉴 삭제");
    int orderConfirmation = Input.getInput();
    switch (orderConfirmation) {
      case 1 -> {
        int discountPrice = determineDiscount(cart);
        if (discountPrice > 0) {
          Output.printfStringOutput("주문이 완료되었습니다.", "총 금액: " + discountPrice +" | 할인금액: " + (cart.getTotalPrice()-discountPrice));
          cart.clearCartItems();
        }
      }
      case 2 -> {
      }
      case 3 -> {
        Output.printOutput("삭제할 장바구니 메뉴를 입력해주세요. ['0' 입력 시 취소]");
        cart.removeCartItems();
      }
      default -> {
        Output.printOutOfRange();
        Output.printReturn();
        confirmOrReturn(cart);
        return;
      }
    }
    Output.printMainBack();
  }

  /* ✔ Requirements: 주문 시, 사용자 유형에 맞는 할인율 적용해 총 금액 계산 / 장바구니 출력 및 금액 계산 */
  // Determines the applicable discount based on given enumType
  // 할인을 결정해주는 함수
  public int determineDiscount(Cart cart) {
    // Enum 을 통하여 각 Type 별로 포맷팅한 Spring 을 출력
    Output.printLineDivider();
    Output.printOutput("할인 유형을 선택해주세요");
    AtomicInteger index = new AtomicInteger(1);
    Arrays.stream(Discount.values())
            .map(values -> String.format("%d. %s | %d %%", index.getAndIncrement(), values.getUserType(), values.getPercent()))
            .forEach(System.out::println);

    // 입력 값과 같은 Type 을 반환. 같지 않을 경우 예외 처리
    int orderDiscount = Input.getInput();
    Optional<Discount> enumDiscount = Arrays.stream(Discount.values())
            .filter(discount -> discount.getType() == orderDiscount) // 값이 같은 걸 찾기
            .findAny();
    if (enumDiscount.isPresent()) {
      Output.printOutput(enumDiscount.get().getUserType() + " 은/는 " + enumDiscount.get().getPercent() + "% 의 할인율이 적용됩니다.");
      return (int) (enumDiscount.get().getRate() * cart.getTotalPrice());
    } else {
      Output.printOutOfRange();
      Output.printReturn();
      int result = determineDiscount(cart);
      return result;
    }
  }

  // Process the selected menu
  // 선택한 메뉴 보여주는 함수
  public void processSubMenuSelection(Menu menu, Cart cart) {
    showSubMenu(menu);

    int orderMenuItem = Input.getInput();

    if (orderMenuItem == 0) {
      Output.printLineDivider();
      Output.printMainBack();
      return;
    }

    boolean isDisplaySelectedMenu = menu.displaySelectedMenu(orderMenuItem - 1);

    if (!isDisplaySelectedMenu) {
      Output.printReturn();
      processSubMenuSelection(menu, cart);
      return;
    }

    processCartInput(menu, orderMenuItem, cart);
    Output.printMainBack();
  }

  /* ✔ Requirements 장바구니 담기 기능 / 장바구니 생성 및 관리 기능 */
  // Processes the shopping cart based on user input
  //사용자 입력을 받아 장바구니 처리하는 함수 (전반적인 흐름을 담당)
  public void processCartInput(Menu menu, int orderMenuItem, Cart cart) {
    Output.printOutput("위 메뉴를 장바구니에 추가하시겠습니까?" +
            "\n1. 확인        | 2. 취소");

    int categoryStatus = Input.getInput();
    switch (categoryStatus) {
      case 1 -> cart.addCartItems(getSpecificMenuItem(menu, orderMenuItem - 1));
      case 2 -> Output.printOutput("장바구니에 담지 않았습니다.");
      default -> {
        Output.printOutOfRange();
        Output.printReturn();
        processCartInput(menu, orderMenuItem, cart);
      }
    }
  }
}