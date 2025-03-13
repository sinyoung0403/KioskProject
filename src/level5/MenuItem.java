package level5;

public class MenuItem {
  // 이름
  private final String menuName;
  // 가격
  private final Integer menuPrice;
  // 설명
  private final String menuDescription;

  MenuItem(String menuName, Integer menuPrice, String menuDescription) {
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

  public String menuFormatString(boolean gap) {
    if (gap) {
      return String.format("%-25s | %d 원 | %s", menuName, menuPrice, menuDescription);
    } else {
      return String.format("%s | %d 원 | %s", menuName, menuPrice, menuDescription);
    }
  }
  /* Getter Finish */
}