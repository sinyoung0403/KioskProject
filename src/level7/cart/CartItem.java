package level7.cart;

import io.Output;

public class CartItem {
  // Field
  private final String cartItemName;
  private final Integer cartItemPrice;
  private Integer cartItemQuantity = 1;
  private final String cartItemDescription;

  // Constructor
  public CartItem(String cartItemName,Integer cartItemPrice, String cartItemDescription){
    this.cartItemName = cartItemName;
    this.cartItemPrice = cartItemPrice;
    this.cartItemDescription = cartItemDescription;
  }

  /* Getter Start*/
  public Integer getCartItemPrice() {
    return cartItemPrice;
  }

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
    Output.printOutput("[총 수량: " + getCartItemQuantity() + " ] " +getCartItemName() + " | " + getCartItemPrice() + " 원 | " + getCartItemDescription());
  }
}

