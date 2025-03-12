package level7.cart;

import io.Output;
import level7.Menu.MenuItem;

import java.util.*;

public class Cart {
  private final List<CartItem> cartItems = new ArrayList<>();

  // CartItems add new Cart
  public void addCartItems(MenuItem menuItem){
    CartItem c = new CartItem(menuItem.getMenuName(), menuItem.getMenuPrice(),menuItem.getMenuDescription());
    boolean isAddable = true;
    if(cartItems.isEmpty()){
      cartItems.add(c);
      Output.printfStringOutput(c.getCartItemName()," 해당 음식이 장바구니에 추가 되었습니다.");
      isAddable = false;
    } else {
      for (CartItem items : cartItems){
        String current = items.getCartItemName().trim();
        if (current.equalsIgnoreCase(menuItem.getMenuName().trim())) {
          items.addCartItemQuantity();
          Output.printfStringOutput(c.getCartItemName(),"수량이 추가 되었습니다.");
          isAddable = false;
        }
      }
    }
    if (isAddable){
      cartItems.add(c);
      Output.printfStringOutput(c.getCartItemName()," 해당 음식이 장바구니에 추가 되었습니다.");
    }
    Output.printMainBack();
  }

  // Output name, price, quantity for each menu
  public void showCartItems(){
    Output.printLineDivider();
    Output.printOutput("아래와 같이 주문하겠습니까? \n");
    Output.printOutput("[Orders]");
    for (CartItem items : cartItems) {
      items.showAllCartItems();
    }
    Output.printOutput("\n[Total]");
    Output.printOutput(Integer.toString(getTotalPrice()));
    Output.printLineDivider();
  }

  // Add all the prices on the list
  public int getTotalPrice() {
    return cartItems.stream()
            .map(cartItem -> cartItem.getCartItemPrice()*cartItem.getCartItemQuantity())
            .reduce(0, Integer::sum);
  }

  // Check with boolean whether the list is empty or not
  public boolean cartItemsNotEmpty() {
    return !cartItems.isEmpty();
  }

  // Initialize the list
  public void clearCartItems() {
    try {
      cartItems.clear();
    } catch (Exception e) {
      System.out.println("값이 비어있습니다. \n");
      throw new RuntimeException();
      // "null error" occurs when the shopping cart is empty.
      // However, the error does not occur because it is initialized after checking null in the first place.
    }
  }

  // remove a specific menu in Cart
  public void removeCartItems(String text){
    if (!cartItemsNotEmpty()) {
      Output.printOutput("장바구니가 비어 있었습니다. \n");
      throw new RuntimeException();
    } else {
      try{
        CartItem find = cartItems.stream()
                .filter(cartItem -> cartItem.getCartItemName().equals(text))
                .findAny().orElseThrow(); // NoSuchElementException Error -> If there is no equal value, the corresponding error occurs
        Output.printOutput(text+"가 장바구니에서 삭제되었습니다.\n[ Main Menu ] 로 돌아갑니다. \n");
      } catch (NoSuchElementException e) {
        Output.printOutput("장바구니에 있는 메뉴를 입력하셔야 합니다. \n[ Main Menu ] 로 돌아갑니다. \n");
        throw new RuntimeException();
      }
    }
  }
}
