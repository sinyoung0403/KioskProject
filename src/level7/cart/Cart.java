package level7.cart;

import io.Output;
import level7.Menu.MenuItem;

import java.util.*;

/**
 *
 */

public class Cart {
  private final List<CartItem> cartItems = new ArrayList<>();

  // CartItems add new Cart
  public void addCartItems(MenuItem menuItem) {
    CartItem c = new CartItem(menuItem);

    // Simple Code - Early Return
    if (cartItems.isEmpty()) {
      cartItems.add(c);
      Output.printfStringOutput(c.getCartItemName(), " 해당 음식이 장바구니에 추가 되었습니다.");
      return;
    }

    cartItems.stream()
            .filter(item ->
                    item.getCartItemName().trim().equals(menuItem.getMenuName().trim()))
            .findFirst()
            .ifPresentOrElse((item) -> {
              item.addCartItemQuantity();
              Output.printfStringOutput(c.getCartItemName(), "수량이 추가 되었습니다.");
            }, () -> {
              cartItems.add(c);
              Output.printfStringOutput(c.getCartItemName(), " 해당 음식이 장바구니에 추가 되었습니다.");
            });
  }

  // Output name, price, quantity for each menu
  public void showCartItems() {
    Output.printLineDivider();
    Output.printOutput("아래와 같이 주문하겠습니까? \n");
    Output.printOutput("[Orders]");

    cartItems.forEach(CartItem::showAllCartItems);

    Output.printOutput("\n[Total]");
    Output.printOutput(Integer.toString(getTotalPrice()));
    Output.printLineDivider();
  }

  // Add all the prices on the list
  public int getTotalPrice() {
    return cartItems.stream()
            .map(cartItem -> cartItem.getMenuItem().getMenuPrice() * cartItem.getItemQuantity())
            .reduce(0, Integer::sum);
  }

  // Check with boolean whether the list is empty or not
  public boolean isCartNotEmpty() {
    return !cartItems.isEmpty();
  }

  // Initialize the list
  public void clearCartItems() {
    cartItems.clear();
  }

  // remove a specific menu in Cart
  public void removeCartItems(String text) {
    if (!isCartNotEmpty()) {
      Output.printOutput("장바구니가 비어 있었습니다. \n");
      return;
    }

//    Optional<CartItem> find = cartItems.stream()
//            .filter(cartItem -> cartItem.getCartItemName().equals(text))
//            .findAny();
//    if (find.isPresent()) {
//      cartItems.remove(find.get());
//      Output.printOutput(text + "가 장바구니에서 삭제되었습니다.\n[ Main Menu ] 로 돌아갑니다. \n");
//    } else {
//      Output.printOutput("장바구니에 있는 메뉴를 입력하셔야 합니다. \n[ Main Menu ] 로 돌아갑니다. \n");
//    }

    cartItems.stream()
            .filter(cartItem -> cartItem.getCartItemName().equals(text.trim()))
            .findAny()
            .ifPresentOrElse((item) -> {
              cartItems.remove(item);
              Output.printOutput(text.trim() + " 가 장바구니에서 삭제되었습니다.");
            }, () -> Output.printOutput("장바구니에 있는 메뉴를 입력하셔야 합니다."));
  }
}