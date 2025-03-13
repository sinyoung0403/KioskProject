package io;

public class Output {
  // 기본 출력문
  public static void printOutput(String message) {
    System.out.println(message);
  }

  // level 5 이전 > 선택 메뉴 포맷팅 출력문
  public static void printfChoiceOutput(String a, String b, String c) {
    System.out.printf("선택한 메뉴 : %s | %s 원 | %s \n \n", a, b, c);
    System.out.println("초기 메뉴판으로 돌아갑니다.");
  }

  // 도전과제 출력문 > 선택 메뉴 포맷팅 출력문
  public static void printfChoice(String a, String b, String c) {
    System.out.printf("%s | %s 원 | %s \n \n", a, b, c);
  }

  public static void printMainBack() {
    System.out.println("[ Main Menu ] 로 돌아갑니다. \n");
  }

  public static void printOutOfRange() {
    System.out.println("범위 밖의 값을 입력했습니다.");
  }

  public static void printReturn() {
    System.out.println("재입력부탁드립니다.");
  }

  // 모든 카테고리 포맷팅 출력문
  public static void printfCategoryOutput(Integer a, String b) {
    System.out.printf("%d. %s\n", a, b);
  }

  // S 하나만을 받는 포맷팅 출력문
  public static void printfStringOutput(String a, String b) {
    System.out.printf("%s | %s \n", a, b);
  }

  // 구분선 출력문
  public static void printStepDivider() {
    System.out.println("*****************************");
  }

  // 구분선 출력문
  public static void printLineDivider() {
    System.out.println("-------------------------------");
  }

}
