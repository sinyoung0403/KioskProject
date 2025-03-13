package level3;

public class MenuItem {
  // 이름
  String menuName;
  // 가격
  Integer menuPrice;
  // 설명
  String menuDescription;

  MenuItem(String menuName, Integer menuPrice, String menuDescription) {
    this.menuName = menuName;
    this.menuPrice = menuPrice;
    this.menuDescription = menuDescription;
  }
}
