package level6;

import io.Output;

import java.util.*;

// Cart List 를 만들거임.
public class Cart {
  // 나중에 이 리스트를 final 로 두는게 맞는지 확인해보기
  // >> 1. 불변성 왜 지켜나가야하는지 . 새로운 리스트로 재할당이 안된다.
  // 2. final 객체에 final을 stack 스택에 쌓인 걸 heap 저장된거는ㄴ수정이가능한데 stack
  private final List<CartItem> cartItems = new ArrayList<>();

  public void addCartItems(MenuItem menuItem){
    CartItem c = new CartItem(menuItem.getMenuName(), menuItem.getMenuPrice(),menuItem.getMenuDescription());
    boolean isAddable = true;
    if(cartItems.isEmpty()){
      cartItems.add(c);
      Output.printfStringOutput(c.getCartItemName(),"해당 음식이 장바구니에 추가 되었습니다.");
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
      Output.printfStringOutput(c.getCartItemName(),"해당 음식이 장바구니에 추가 되었습니다.");
    }
  }

  // Output name, price, quantity for each menu
  public void showCartItems(){
    Output.printLineDivider();
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
      System.out.println("값이 비어있습니다.");
      throw new RuntimeException(); // 아마 null 에러가 뜰 것임. 근데 애초에 아닐 거라서 안 뜰거긴 한데 !!..
    }
  }

}
