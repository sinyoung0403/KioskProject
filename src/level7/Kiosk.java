package level7;

import io.Input;
import io.Output;
import level7.Menu.Menu;
import level7.Menu.MenuItem;
import level7.cart.Cart;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;


public class Kiosk {
  /* field */
  private final List<Menu> menus;

  /* Constructor */
  public Kiosk(){
    this.menus = initMenus();
  }

  // init Menu & MenuItems
  private List<Menu> initMenus() {
    // Menu 카테고리 이름 설정
    Menu burger = new Menu("Burger \uD83C\uDF54");
    Menu drink = new Menu("Drink \uD83E\uDD64");
    Menu desert = new Menu("Desert \uD83C\uDF5F");

    /* Burger */
    burger.addMenuItems(new MenuItem("Whopper",7100,"버거킹의 대표 메뉴로, 두툼한 패티와 신선한 채소가 어우러져 클래식한 맛을 제공하는 와퍼"));
    burger.addMenuItems(new MenuItem("Quattro Cheese Whopper",7900,"네 가지 치즈가 어우러져 진한 치즈 풍미를 느낄 수 있는 와퍼"));
    burger.addMenuItems(new MenuItem("Monster Whopper",9300,"두툼한 더블 패티와 바삭한 베이컨, 매콤한 소스로 강렬한 맛을 자랑하는 와퍼"));
    burger.addMenuItems(new MenuItem("Whole Shrimp Whopper",7900,"탱글탱글한 통새우와 신선한 야채가 어우러져 해산물의 풍미를 느낄 수 있는 버거"));
    burger.addMenuItems(new MenuItem("Whopper Jr",4700,"클래식 와퍼의 맛을 그대로 담은 작은 사이즈의 버거"));

    /* Drink */
    drink.addMenuItems(new MenuItem("Americano",1500,"진하고 깔끔한 커피 본연의 맛을 즐길 수 있는 음료"));
    drink.addMenuItems(new MenuItem("Vanilla Sundae Ice Cream",2000,"부드러운 바닐라 아이스크림"));
    drink.addMenuItems(new MenuItem("Choco Sundae Ice Cream",2200,"진한 초콜릿 아이스크림에 달콤한 초콜릿 시럽을 더한 디저트"));
    drink.addMenuItems(new MenuItem("Soft Drink",2000,"시원하고 청량감 넘치는 탄산이 가득한 음료"));

    /* Desert */
    desert.addMenuItems(new MenuItem("French Fries",2100,"바삭하고 황금빛으로 튀겨진 감자"));
    desert.addMenuItems(new MenuItem("21cm Cheese Sticks",2500,"길고 바삭한 치즈스틱 속에 쭉 늘어나는 고소한 치즈가 가득"));
    desert.addMenuItems(new MenuItem("Nugget King(4ea)",2200,"바삭하고 황금빛으로 튀겨진 맛있는 치킨 너겟"));
    desert.addMenuItems(new MenuItem("Coconut Shrimp(3ea)",3900," 코코넛 튀김옷을 입혀 바삭하게 튀긴 새우로, 달콤하고 고소한 맛이 특징"));

    return new ArrayList<>(Arrays.asList(drink,burger,desert));
  }

  // main start
  public void start() {
    Cart cart = new Cart();
    Menu menu = null;
    boolean isMainLoopRunning = true;
    while (isMainLoopRunning){
      Output.printStepDivider();
      showMainMenu(cart,menu);
      try {
        // process MainMenuSelection
        int orderCategory = Input.getInput();
        switch (orderCategory) {
          case 0 -> {
            isMainLoopRunning = false;
            continue;
          }
          case 4 -> {
            confirmOrReturn(cart);
            continue;
          }
          case 5 -> {
            if(cart.cartItemsNotEmpty()) {
              cart.clearCartItems();
              Output.printOutput("장바구니를 취소했습니다.");
              Output.printMainBack();
            } else {
              throw new IndexOutOfBoundsException();
            }
            continue;
          }
          default -> menu = getSpecificMenus(orderCategory-1);
        }

        showSubMenu(menu);
        processSubMenuSelection(menu,cart);

      } catch (IndexOutOfBoundsException e) { // Range Error
        Output.printOutput("번호 내에서 입력부탁드립니다. \n");
      } catch (RuntimeException e) { // Input Error - Print error message in input.java
      }
    }
    Output.printOutput("종료되었습니다.");
  }

  /* Getter Start */
  // Get all categories
  public void showAllCategory(){
    for (int i=1; i <= menus.size(); i++){
      Output.printfCategoryOutput(i,menus.get(i-1).getCategoryName());
    }
  }

  // Get specific menus
  public Menu getSpecificMenus(Integer index) {
    return menus.get(index);
  }

  // Get specific menuItems
  public MenuItem getSpecificMenuItem (Menu menu, Integer index){
    return menu.getMenuItems().get(index);
  }
  /* Getter Finish */

  /* Calculation Logic Function */
  // Show Main Menu
  public void showMainMenu(Cart cart, Menu menu) {
    Output.printOutput("[ Burger King | MAIN MENU ]");
    showAllCategory();
    if (cart.cartItemsNotEmpty()) {
      Output.printOutput("4. Orders     | 장바구니를 확인 후 주문합니다.");
      Output.printOutput("5. Cancel     | 진행중인 주문을 취소합니다.");
    }
    Output.printOutput("0. Exit       | 종료합니다.");
  }

  // Show Sub Menu
  public void showSubMenu(Menu menu){
    Output.printOutput("[ "+ menu.getCategoryName()+" ] 를 선택했습니다. \n");
    Output.printLineDivider();
    Output.printOutput("[ Burger King | "+menu.getCategoryName()+" Menu ]");
    menu.showMenuItems();
    Output.printOutput("0. 뒤로가기.");
  }

  // To ask whether to proceed with the order or return to the menu.
  public void confirmOrReturn(Cart cart) {
    if (!cart.cartItemsNotEmpty()) {
      throw new IndexOutOfBoundsException();
    }
    cart.showCartItems();
    Output.printOutput("1. 주문하기     | 2. 메뉴판으로 돌아가기     | 3. 장바구니 메뉴 삭제");
    int orderConfirmation = Input.getInput();
    switch (orderConfirmation) {
      case 1 -> {
        Output.printfStringOutput("주문이 완료되었습니다.", "총 금액: " + determineDiscount(cart));
        cart.clearCartItems();
        Output.printOutput("메뉴판으로 돌아갑니다. \n");
      }
      case 2 -> Output.printOutput("메뉴판으로 돌아갑니다.");
      case 3 -> {
        // 해당 값을 삭제하는 함수 호출.
        Output.printOutput("삭제할 장바구니 메뉴를 입력해주세요. ");
        String text = Input.getString();
        cart.removeCartItems(text.trim());
      }
      default -> throw new IndexOutOfBoundsException();
    }
  }

  // Determine whether to apply a discount.
  public int determineDiscount(Cart cart) {
    Output.printOutput("""
            할인 정보를 입력해주세요.\s
            1. 국가유공자   :  10%\s
            2. 군인        :  5%\s
            3. 학생        :  3%\s
            4. 일반        :  0%""");
    int orderDiscount = Input.getInput();
    try {
      return getDiscountPrice(orderDiscount, cart.getTotalPrice());
    } catch (NoSuchElementException e) {
      Output.printOutput("정해진 값을 넣어야합니다.");
      throw new RuntimeException();
    }
  }

  // function that calculates the discount amount
  public static int getDiscountPrice(int userType, int price){
    Discount enumDiscount = Arrays.stream(Discount.values()) // Create all listed objects in the list of enumerated objects
            .filter(discount -> discount.getType() == userType)
            .findAny().orElseThrow(); // Error: NoSuchElementException
    Output.printOutput(enumDiscount.name()+"] "+enumDiscount.getPercent()+"% 의 할인율이 적용됩니다.");
    return (int) (enumDiscount.getRate() * price) ;
  }

  // Loop function for the shopping cart processSubMenuSelection
  public void processSubMenuSelection(Menu menu, Cart cart) {
    boolean isSubLoopRunning = true;
    while (isSubLoopRunning) {
      int orderMenuItem;
      try {
        // Back or print Menu List
        orderMenuItem = Input.getInput();
        if (orderMenuItem == 0) {
          Output.printLineDivider();
          Output.printMainBack();
          isSubLoopRunning = false;
        } else {
          menu.displaySelectedMenu(orderMenuItem - 1);
          Output.printOutput("위 메뉴를 장바구니에 추가하시겠습니까?" +
                              "\n1. 확인        | 2. 취소");
          int categoryStatus = Input.getInput();
          switch (categoryStatus) {
            case 1 -> {
              // Show Choice Menu
              cart.addCartItems(getSpecificMenuItem(menu, orderMenuItem - 1));
              isSubLoopRunning = false;
            }
            case 2 -> {
              Output.printOutput("장바구니에 담지 않았습니다.");
              Output.printMainBack();
              isSubLoopRunning = false;
            }
            default -> throw new IndexOutOfBoundsException();
          }
        }
      } catch (IndexOutOfBoundsException e) {// Range Error
        Output.printOutput("번호 내에서 입력부탁드립니다.");
        Output.printMainBack();
        throw new RuntimeException();
      } catch (RuntimeException e) { // Input Error - Print error message in input.java
        Output.printMainBack();
        throw new RuntimeException();
      }
    }
  }
}
