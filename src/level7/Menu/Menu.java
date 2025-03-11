package level7.Menu;

import io.Output;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Menu {
  // Field
  private final String categoryName;
  private final List<MenuItem> menuItems = new ArrayList<>();

  // Constructor
  public Menu(String categoryName){
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

  // Show list sequentially > 이거를 스트림으로 하라는 거 아녀 'ㅡ' ... 변환 가능..한 숫자를 해야한다네
  public void showMenuItems(){
    AtomicInteger index = new AtomicInteger(1);
    menuItems.stream()
            .map(item -> String.format("%d. %-25s | %s원 | %s",index.getAndIncrement(),item.getMenuName(),item.getMenuPrice(),item.getMenuDescription()))
            .forEach(System.out::println);
  }

  // Show Choice Menu
  public void displaySelectedMenu(Integer index){
    Output.printfChoice(menuItems.get(index).getMenuName(),menuItems.get(index).getMenuPrice().toString(),menuItems.get(index).getMenuDescription());
  }
  /* Getter Finish */

  /* Setter Start */
  public void addMenuItems(MenuItem menuItem){
    menuItems.add(menuItem);
  }
  /* Setter Finish */

}

