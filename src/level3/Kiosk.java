package level3;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Kiosk {
  // MenuItem 관리하는 리스트
  List<MenuItem> menuItems;

  // Kiosk 클래스 생성자
  Kiosk(List<MenuItem> menuItems) {
    this.menuItems = menuItems;
  }

  // 입력과 반복문 로직
  public void start() {
    int exit = 1;
    int inputNumber = -1;
    Scanner sc = new Scanner(System.in);
    while (exit != 0) {
      System.out.println("[BBQ Menu]");
      int i = 1;
      for (MenuItem a : menuItems) {
        System.out.printf("%s | %s | %s\n", i + ". " + a.menuName, a.menuPrice, a.menuDescription);
        i++;
      }
      System.out.printf("%s | %s", "0. 종료", "0\n");
      System.out.println("주문을 입력해주세요.");
      try {
        inputNumber = sc.nextInt();
      } catch (InputMismatchException e) { // 숫자 입력이 아닐 시
        System.out.println("숫자를 입력하셔야 합니다.");
        sc.nextLine();
        continue;
      }

      // inputNumber 가 0 일 경우 반복문 탈출
      if (inputNumber == 0) {
        exit = 0;
      } else {
        // 값이 올바를 경우 출력
        try {
          System.out.printf("%s | 가격: %d | 설명: %s\n", menuItems.get(inputNumber - 1).menuName, menuItems.get(inputNumber - 1).menuPrice, menuItems.get(inputNumber - 1).menuDescription);
        } catch (Exception e) { // 번호 밖이면, 오류 출력
          System.out.println("번호 내에서 입력 부탁드립니다.");
        }
      }
    }
    System.out.println("주문이 종료되었습니다. ");
  }
}
