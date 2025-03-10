package io;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Input {
  static Scanner sc = new Scanner(System.in);

  // Get int input
  public static int getInput(){
    try {
      return sc.nextInt();
    } catch (InputMismatchException e) {
      Output.printOutput("숫자를 입력하셔야 합니다.");
      throw new RuntimeException();
    } catch (NullPointerException e){
      Output.printOutput("입력값이 비어있습니다.");
      throw new RuntimeException();
    } catch (NumberFormatException e) {
      Output.printOutput("유요한 숫자가 아닙니다.");
      throw new RuntimeException();
    }
  }

  // Remove buffer
  public static void printNextLine(){
    sc.nextLine();
  }
}
