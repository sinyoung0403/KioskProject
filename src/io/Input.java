package io;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Input {
  static Scanner sc = new Scanner(System.in);

  // Get int input
  public static int getInput() {
    try {
      int inputNumber = sc.nextInt();
      sc.nextLine();
      return inputNumber;
    } catch (InputMismatchException e) {
      Output.printOutput("유효한 숫자가 아닙니다.\n재입력해주세요:");
    } catch (NullPointerException e) {
      Output.printOutput("유효한 숫자가 아닙니다.\n재입력해주세요:");
    } catch (NumberFormatException e) {
      Output.printOutput("유효한 숫자가 아닙니다.\n재입력해주세요:");
    }
    sc.nextLine();
    int inputNumber = getInput();
    return inputNumber;
  }

  // Get String
  public static String getString() {
    return sc.nextLine();
  }
}
