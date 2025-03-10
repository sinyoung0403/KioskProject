package level1;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    int exit = 1;
    while(exit!= 0){
      System.out.println("[ Burger King Menu ]");
      System.out.println("1. Whopper               | 7,100원 | 버거킹의 대표 메뉴로, 두툼한 패티와 신선한 채소가 어우러져 클래식한 맛을 제공하는 와퍼");
      System.out.println("2. Quattro Cheese Whopper| 7,900원 | 네 가지 치즈가 어우러져 진한 치즈 풍미를 느낄 수 있는 와퍼");
      System.out.println("3. Monster Whopper       | 9,300원 | 두툼한 더블 패티와 바삭한 베이컨, 매콤한 소스로 강렬한 맛을 자랑하는 와퍼");
      System.out.println("4. Whole Shrimp Whopper  | 7,900원 | 탱글탱글한 통새우와 신선한 야채가 어우러져 해산물의 풍미를 느낄 수 있는 버거");
      System.out.println("5. Whopper Jr            | 4,700원 | 클래식 와퍼의 맛을 그대로 담은 작은 사이즈의 버거");
      System.out.println("0. Exit                  | 종료");
      Scanner sc = new Scanner(System.in);
      int inputNumber = sc.nextInt();

      switch (inputNumber){
        case 1 -> System.out.println("[Whopper] 을/를 선택하셨습니다.");
        case 2 -> System.out.println("[Quattro Cheese Whopper] 을/를 선택하셨습니다.");
        case 3 -> System.out.println("[Monster Whopper] 을/를 선택하셨습니다.");
        case 4 -> System.out.println("[Whole Shrimp Whopper] 을/를 선택하셨습니다.");
        case 5 -> System.out.println("[Whopper Jr] 을/를 선택하셨습니다.");
        case 0 -> exit =0;
        default -> System.out.println("잘못입력하셨습니다.");
      }
      System.out.println("**********************");
    }
    System.out.println("프로그램을 종료합니다.");
  }
}
