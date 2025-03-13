package level6.Cart;

import io.Output;
import level6.Menu.MenuItem;

import java.util.*;

public class Cart {
  private final List<CartItem> cartItems = new ArrayList<>();

  public void addCartItems(MenuItem menuItem) {
    CartItem c = new CartItem(menuItem);

    if (cartItems.isEmpty()) {
      cartItems.add(c);
      Output.printfStringOutput(c.getCartMenuName(), "해당 음식이 장바구니에 추가 되었습니다.");
      return;
    }

    cartItems.stream()
            .filter(cartItem ->
                    cartItem.getCartMenuName().trim().equals(menuItem.getMenuName().trim()))
            .findFirst()
            .ifPresentOrElse((cartItem -> {
              cartItem.addCartItemQuantity();
              Output.printfStringOutput(c.getCartMenuName(), "수량이 추가 되었습니다.");
            }), () -> {
              cartItems.add(c);
              Output.printfStringOutput(c.getCartMenuName(), "해당 음식이 장바구니에 추가 되었습니다.");
            });
  }

  // Output name, price, quantity for each menu
  public void showCartItems() {
    Output.printLineDivider();
    Output.printOutput("아래와 같이 주문하겠습니까? \n");
    Output.printOutput("[Orders]");
    cartItems.forEach(item -> item.showAllCartItems());
    Output.printOutput("\n[Total]");
    Output.printOutput(Integer.toString(getTotalPrice()));
    Output.printLineDivider();
  }

  // Add all the prices on the list
  public int getTotalPrice() {
    return cartItems.stream()
            .map(item -> item.getMenuItem().getMenuPrice() * item.getItemQuantity())
            .reduce(0, Integer::sum);
  }

  // Check with boolean whether the list is empty or not
  public boolean cartItemsNotEmpty() {
    return !cartItems.isEmpty();
  }

  // Initialize the list
  public void clearCartItems() {
    cartItems.clear();
  }
}
