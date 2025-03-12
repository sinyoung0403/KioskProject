package level7;

// enum 만 분리.
public enum Discount {
  VETERAN(1, "국가유공자", 0.9),
  SOLDIER(2, "군인", 0.95),
  STUDENT(3, "학생", 0.97),
  GENERAL(4, "일반인", 1.0);

  private final String userType;
  private final int type;
  private final Double rate;

  Discount(int type, String userType, Double rate) {
    this.userType = userType;
    this.type = type;
    this.rate = rate;
  }

  public String getUserType() {
    return userType;
  }

  public Double getRate() {
    return rate;
  }

  public int getType() {
    return type;
  }

  public int getPercent() {
    return (int) Math.round((1 - rate) * 100);
  }
}

