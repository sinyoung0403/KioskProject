package level7;

import java.util.*;

public class DiscountType {
  public enum Discount {
    GENERAL(4,1.0),
    STUDENT(3,0.97),
    SOLDIER(2,0.95),
    Veteran(1,0.9);

    private final int type;
    private final Double rate;

    Discount(int type, Double rate) {
      this.type = type;
      this.rate = rate;
    }

    // discount on the price
    public static int getDiscountPrice(int price, int userType){
      Discount a = Arrays.stream(values()) // 열거 타입의 모든 열거 객체들을 배열로 만들어 리턴
              .filter(discount -> discount.type == (userType))
              .findAny().orElseThrow(); // Error: NoSuchElementException
      return (int) (a.rate * price) ;
    }
  }
}
