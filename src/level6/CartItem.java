package level6;

import io.Output;

public class CartItem {
  // 메뉴명, 수량, 가격 정보
  // 만약 메뉴명이 동일한게 포함되어 있으면 수량만 ++
  // 일단은 메뉴명, 수량, 가격 정보, 설명 을 가진 CartItems 라는 리스트를 만들 거임.
  // 항목을 동적 추가 및 조회 가능하여야 함.
  // 잘못 선택 했을 경우 예외 처리 해야함.

  // Field
  private final String cartItemName;
  private final Integer cartItemPrice;
  private Integer cartItemQuantity = 1;
  private final String cartItemDescription;

  // Constructor
  CartItem(String cartItemName,Integer cartItemPrice, String cartItemDescription){
    this.cartItemName = cartItemName;
    this.cartItemPrice = cartItemPrice;
    this.cartItemDescription = cartItemDescription;
  }

  public Integer getCartItemPrice() {
    return cartItemPrice;
  }

  /* Getter Start*/
  public Integer getCartItemQuantity() {
    return cartItemQuantity;
  }

  public String getCartItemDescription() {
    return cartItemDescription;
  }

  public String getCartItemName() {
    return cartItemName;
  }
  /* Getter Finish*/

  /* Setter Start */
  // Add in the quantity
  public void addCartItemQuantity(){
    this.cartItemQuantity ++;
  }
  /* Setter Finish */

  // Show All Cart Items (Name, Price, Description, Quantity)
  public void showAllCartItems(){
    // Orders
    Output.printOutput(getCartItemName() + " | " + getCartItemPrice() + " 원 | " + getCartItemDescription() + " <✅ 총 수량: " + getCartItemQuantity() + " >");
  }
}
