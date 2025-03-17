package level7.cart;

import io.Input;
import io.Output;
import level7.Menu.MenuItem;

import java.util.*;

public class Cart {
  private final Map<String, CartItem> cartItemMap = new HashMap<>();

  // CartItems add new Cart
  public void addCartItems(MenuItem menuItem) {
    CartItem c = new CartItem(menuItem);

    // 1. key 가 있으면 CartItem 의 수량을 추가 저장.
    if (cartItemMap.containsKey(menuItem.getMenuName())) {
      cartItemMap.get(menuItem.getMenuName()).addCartItemQuantity();
    } else {
      // 2. key 가 없으면 key 와 value 저장.
      cartItemMap.put(menuItem.getMenuName(), c);
    }
  }

  /* ✔ Requirements 람다 활용한 장바구니 조회 기능
   * CartItem 의 Private 한 속성들을 Cart 에서 하나씩 값을 가져오는 것 보다는
   * CartItem 의 Private 한 속성은 CartItem 에서 출력만 해주는 형식으로 접근(Getter 를 활용)하는 것이
   * 더 객체지향적이라고 생각했습니다.
   * 그리하여 해당 부분은 Stream 을 활용하여 각각의 값을 접근하는 것보다는
   * forEach 에 간략화된된 람다표현식을 활용하여 출력했습니다. */
  // Output name, price, quantity for each menu
  public void showCartItems() {
    Output.printLineDivider();
    Output.printOutput("아래와 같이 주문하겠습니까? \n");
    Output.printOutput("[Orders]");

    cartItemMap.values().forEach(CartItem::showAllCartItems);

    Output.printOutput("\n[Total]");
    Output.printOutput(Integer.toString(getTotalPrice()));
    Output.printLineDivider();
  }

  // Add all the prices on the list
  public int getTotalPrice() {
    return cartItemMap.values().stream()
            .mapToInt(cartItem -> cartItem.getMenuItem().getMenuPrice() * cartItem.getItemQuantity())
            .sum();
  }

  // Check with boolean whether the list is empty or not
  public boolean isCartEmpty() {
    return cartItemMap.isEmpty();
  }

  // Initialize the list
  public void clearCartItems() {
    cartItemMap.clear();
  }

  /** Requirements: 기존 장바구니에서 특정 메뉴 빼기 기능을 통한 스트림 활용 **/
  // remove a specific menu in Cart
  public void removeCartItems() {
    String text = Input.getString().trim();

    if (text.trim().equals("0")) {
      Output.printOutput("삭제를 취소합니다.");
      return;
    }

    if (cartItemMap.containsKey(text)) {
      Output.printOutput(text + " | 해당 메뉴를 장바구니에서 삭제했습니다.");
      cartItemMap.remove(text);
    } else {
      Output.printOutput("장바구니에 있는 메뉴를 입력하셔야 합니다. 재입력 부탁드립니다.");
      removeCartItems();
    }
  }
}