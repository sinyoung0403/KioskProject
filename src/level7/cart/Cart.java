package level7.cart;

import io.Output;
import level7.Menu.MenuItem;

import java.util.*;

// Cart List 를 만들거임.
public class Cart {
  private final List<CartItem> cartItems = new ArrayList<>();

  //
  public void addCartItems(MenuItem menuItem){
    CartItem c = new CartItem(menuItem.getMenuName(), menuItem.getMenuPrice(),menuItem.getMenuDescription());
    boolean isAddable = true;
    if(cartItems.isEmpty()){
      cartItems.add(c);
      Output.printfStringOutput(c.getCartItemName()," 해당 음식이 장바구니에 추가 되었습니다.");
      isAddable = false;
    }
    else {
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
    Output.printOutput("메뉴판으로 돌아갑니다. \n");
  }

  // Output name, price, quantity for each menu
  public void showCartItems(){
    Output.printLineDivider();
    Output.printOutput("아래와 같이 주문하겠습니까? \n");
    Output.printOutput("[Orders]");
    int sum = 0;
    for (CartItem items : cartItems) {
      items.showAllCartItems();
      sum += items.getCartItemPrice() * items.getCartItemQuantity();
    }
    Output.printOutput("\n[Total]");
    Output.printOutput(Integer.toString(sum));
    Output.printLineDivider();
  }

  // Add all the prices on the list
  public int getTotalPrice() {
    int sum = 0;
    for (CartItem items : cartItems) {
      sum += items.getCartItemPrice() * items.getCartItemQuantity();
    }
    return sum;
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
      throw new RuntimeException(); // 아마 null 에러가 뜰 것임. 근데 애초에 아닐 거라서 안 뜰거긴 한데 !!..
    }
  }

  // remove a specific menu in Cart
  public void removeCartItems(String text){
    if (!cartItemsNotEmpty()) {
      Output.printOutput("장바구니가 비어 있었습니다. \n");
      throw new RuntimeException();
    } else {
      // 카트에 템이 있으면 그걸 비교해서 없애겠다.
      try{
        CartItem find = cartItems.stream()
                .filter(cartItem -> cartItem.getCartItemName().equals(text)).findAny().orElseThrow();
        cartItems.remove(find);
        Output.printOutput(text+"가 장바구니에서 삭제되었습니다.\n[ Main Menu ] 로 돌아갑니다. \n");
      } catch (Exception e) {
        Output.printOutput("장바구니에 있는 메뉴를 입력하셔야 합니다. \n[ Main Menu ] 로 돌아갑니다. \n");
      }

    }
  }
}
