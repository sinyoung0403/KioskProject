package level6.Menu;

import io.Output;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Menu {
  // Field
  private final String categoryName;
  private final List<MenuItem> menuItems = new ArrayList<>();

  // Constructor
  public Menu(String categoryName) {
    this.categoryName = categoryName;
  }

  /* Getter Start */
  // MenuItems Getter
  public List<MenuItem> getMenuItems() {
    return this.menuItems;
  }

  // Category Getter
  public String getCategoryName() {
    return this.categoryName;
  }

  // Show list sequentially
  public void showMenuItems() {
    AtomicInteger index = new AtomicInteger(1);
    menuItems.forEach(e -> System.out.printf("%d. %s\n", index.getAndIncrement(), e.menuFormatString(true)));
  }

  // Show Choice Menu
  public void displaySelectedMenu(Integer index) {
    Output.printOutput("선택된 메뉴: " + menuItems.get(index).menuFormatString(false));
  }
  /* Getter Finish */

  /* Setter Start */
  public void addMenuItems(MenuItem menuItem) {
    menuItems.add(menuItem);
  }
  /* Setter Finish */
}

