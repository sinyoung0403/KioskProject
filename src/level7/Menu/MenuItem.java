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
  public MenuItem(String menuName, Integer menuPrice, String menuDescription) {
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

  // Give space if gap is "true"
  // Give printout without margin if "false"
  public String menuFormatString(boolean gap) {
    if (gap) {
      return String.format("%-25s | %d 원 | %s", menuName, menuPrice, menuDescription);
    } else {
      return String.format("%s | %d 원 | %s", menuName, menuPrice, menuDescription);
    }
  }
  /* Getter Finish */
}