package level7.Menu;


public class MenuItem {
  /* field */
  // Name
  private final String menuName;
  // Price
  private final Integer menuPrice;
  // Description
  private final String menuDescription;

  /* Constructor */
  public MenuItem(String menuName, Integer menuPrice, String menuDescription){
    this.menuName = menuName;
    this.menuPrice = menuPrice;
    this.menuDescription = menuDescription;
  }

  /* Getter Start */
  public Integer getMenuPrice() {
    return menuPrice;
  }

  public String getMenuDescription() {
    return menuDescription;
  }

  public String getMenuName() {
    return menuName;
  }
  /* Getter Finish */
}