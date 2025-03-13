package level6.Cart;

import io.Output;
import level6.Menu.MenuItem;

public class CartItem {
  // Field
  private final MenuItem menuItem;
  private Integer itemQuantity = 1;

  // Constructor
  CartItem(MenuItem menuItem) {
    this.menuItem = menuItem;
  }

  /* Getter Start*/
  public Integer getItemQuantity() {
    return itemQuantity;
  }

  public MenuItem getMenuItem() {
    return menuItem;
  }

  public String getCartMenuName() {
    return menuItem.getMenuName();
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
    // Orders
    Output.printOutput("[총 수량: " + getItemQuantity() + menuItem.menuFormatString(false));
  }
}
