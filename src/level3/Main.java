package level3;

import java.util.ArrayList;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    // 메인에서는 키오스크 실행만을 만들기
    // ?? 뭘 넣으란걸까
    List<MenuItem> menuItems = new ArrayList<>();

    // add 함수를 통해 new MenuItem() List 에 삽입
    menuItems.add(new MenuItem("Whopper™",7100,"버거킹의 대표 메뉴로, 두툼한 패티와 신선한 채소가 어우러져 클래식한 맛을 제공하는 와퍼"));
    menuItems.add(new MenuItem("Quattro Cheese Whopper",7900,"네 가지 치즈가 어우러져 진한 치즈 풍미를 느낄 수 있는 와퍼"));
    menuItems.add(new MenuItem("Monster Whopper",9300,"두툼한 더블 패티와 바삭한 베이컨, 매콤한 소스로 강렬한 맛을 자랑하는 와퍼"));
    menuItems.add(new MenuItem("Whole Shrimp Whopper",7900,"탱글탱글한 통새우와 신선한 야채가 어우러져 해산물의 풍미를 느낄 수 있는 버거"));
    menuItems.add(new MenuItem("Whopper Jr",4700,"클래식 와퍼의 맛을 그대로 담은 작은 사이즈의 버거"));

    Kiosk kiosk = new Kiosk(menuItems);
    kiosk.start();
  }
}
