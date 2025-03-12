package level7.cart;

import io.Output;

public class CartItem {
  // Field
  private final String itemName;
  private final Integer itemPrice;
  private Integer itemQuantity = 1;
  private final String itemDescription;

  // Constructor
  public CartItem(String itemName,Integer itemPrice, String itemDescription){
    this.itemName = itemName;
    this.itemPrice = itemPrice;
    this.itemDescription = itemDescription;
  }

  /* Getter Start*/
  public String getItemName() {
    return itemName;
  }

  public Integer getItemPrice() {
    return itemPrice;
  }

  public Integer getItemQuantity() {
    return itemQuantity;
  }

  public String getItemDescription() {
    return itemDescription;
  }
  /* Getter Finish*/

  /* Setter Start */
  // Add in the quantity
  public void addCartItemQuantity(){
    this.itemQuantity ++;
  }
  /* Setter Finish */

  // Show All Cart Items (Name, Price, Description, Quantity)
  public void showAllCartItems(){
    Output.printOutput("[총 수량: " + getItemQuantity() + " ] " + getItemName() + " | " + getItemPrice() + " 원 | " + getItemDescription());
  }
}

