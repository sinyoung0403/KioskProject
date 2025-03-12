package level7.cart;

import io.Output;
import level7.Menu.MenuItem;

public class CartItem {
  // Field  /  Menu item List를 주는 걸 고려.
  // 의존성. //
  private final MenuItem menuItem;
  private Integer itemQuantity = 1;

  // Constructor
  public CartItem(MenuItem menuItem) {
    this.menuItem = menuItem;
  }

  /* Getter Start*/

  public MenuItem getMenuItem() {
    return menuItem;
  }

  public String getCartItemName() {
    return menuItem.getMenuName();
  }

  public Integer getItemQuantity() {
    return itemQuantity;
  }

  /* Getter Finish*/

  /* Setter Start */
  // Add in the quantity
  public void addCartItemQuantity() {
    this.itemQuantity++;
  }
  /* Setter Finish */

  // Show All Cart Items (Name, Price, Description, Quantity)
  public void showAllCartItems() {
    Output.printOutput("[ 총 수량: " + getItemQuantity() + " ] " + menuItem.getMenuName() + " | " + menuItem.getMenuPrice() + " 원 | " + menuItem.getMenuDescription());
  }
}

