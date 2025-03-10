package level4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    // Menu 카테고리 이름 설정
    Menu burger = new Menu("Burger");
    Menu drink = new Menu("Drink");
    Menu desert = new Menu("Desert");

    // Burger
    burger.menuItems.add(new MenuItem("Whopper™",7100,"버거킹의 대표 메뉴로, 두툼한 패티와 신선한 채소가 어우러져 클래식한 맛을 제공하는 와퍼"));
    burger.menuItems.add(new MenuItem("Quattro Cheese Whopper",7900,"네 가지 치즈가 어우러져 진한 치즈 풍미를 느낄 수 있는 와퍼"));
    burger.menuItems.add(new MenuItem("Monster Whopper",9300,"두툼한 더블 패티와 바삭한 베이컨, 매콤한 소스로 강렬한 맛을 자랑하는 와퍼"));
    burger.menuItems.add(new MenuItem("Whole Shrimp Whopper",7900,"탱글탱글한 통새우와 신선한 야채가 어우러져 해산물의 풍미를 느낄 수 있는 버거"));
    burger.menuItems.add(new MenuItem("Whopper Jr",4700,"클래식 와퍼의 맛을 그대로 담은 작은 사이즈의 버거"));

    // Drink
    drink.menuItems.add(new MenuItem("Americano",1500,"진하고 깔끔한 커피 본연의 맛을 즐길 수 있는 음료"));
    drink.menuItems.add(new MenuItem("Vanilla Sundae Ice Cream",2000,"부드러운 바닐라 아이스크림"));
    drink.menuItems.add(new MenuItem("Choco Sundae Ice Cream",2200,"진한 초콜릿 아이스크림에 달콤한 초콜릿 시럽을 더한 디저트"));
    drink.menuItems.add(new MenuItem("Soft Drink",2000,"시원하고 청량감 넘치는 탄산이 가득한 음료"));

    // Desert
    desert.menuItems.add(new MenuItem("French Fries",2100,"클래식 와퍼의 맛을 그대로 담은 작은 사이즈의 버거"));
    desert.menuItems.add(new MenuItem("21cm Cheese Sticks",2500,"클래식 와퍼의 맛을 그대로 담은 작은 사이즈의 버거"));
    desert.menuItems.add(new MenuItem("Nugget King 4ea",2200,"클래식 와퍼의 맛을 그대로 담은 작은 사이즈의 버거"));
    desert.menuItems.add(new MenuItem("Coconut Shrimp 3ea",3900,"클래식 와퍼의 맛을 그대로 담은 작은 사이즈의 버거"));

    List<Menu> menus = new ArrayList<>(Arrays.asList(drink,burger,desert));

    // 키오스크 실행
    Kiosk kiosk = new Kiosk(menus);
    kiosk.start();
  }
}
