package io;

public class Output {
  // 기본 출력문
  public static void printOutput(String message) {
    System.out.println(message);
  }

  // 선택 메뉴 포맷팅 출력문
  public static void printfChoiceOutput(String a, String b, String c){
    System.out.printf("선택한 메뉴 : %s | %s 원 | %s \n \n", a,b,c);
    System.out.println("초기 메뉴판으로 돌아갑니다.");
  }

  // 모든 카테고리 포맷팅 출력문
  public static void printfCategoryOutput(Integer a, String b){
    System.out.printf("%d. %s\n", a, b);
  }

  // S 하나만을 받는 포맷팅 출력문
  public static void printfStringOutput(String a, String b){
    System.out.printf("%s | %s \n", a,b);
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
