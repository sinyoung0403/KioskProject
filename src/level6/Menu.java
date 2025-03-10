package level6;

import io.Output;

import java.util.*;

public class Menu {
  // Field
  private final String categoryName;
  private final List<MenuItem> menuItems = new ArrayList<>();

  // Constructor
  Menu(String categoryName){
    this.categoryName = categoryName;
  }

  /* Getter Start */
  // MenuItems Getter
  public List<MenuItem> getMenuItems(){
    return this.menuItems;
  }
  // Category Getter
  public String getCategoryName(){
    return this.categoryName;
  }
  // Show list sequentially
  public void showMenuItems(){
    for (int i=0; i < menuItems.size(); i++){
      System.out.printf("%-30s | %s원 | %s\n",(i+1)+ ". "+ menuItems.get(i).getMenuName(),menuItems.get(i).getMenuPrice(),menuItems.get(i).getMenuDescription());
    }
  }
  // Show Choice Menu
  public void displaySelectedMenu(Integer index){
    Output.printfChoiceOutput(menuItems.get(index).getMenuName(),menuItems.get(index).getMenuPrice().toString(),menuItems.get(index).getMenuDescription());
  }

  /* Getter Finish */

  /* Setter Start */
  public void addMenuItems(MenuItem menuItem){
    menuItems.add(menuItem);
  }
  /* Setter Finish */

}

