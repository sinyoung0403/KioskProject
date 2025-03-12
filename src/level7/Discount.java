package level7;

// enum 만 분리.
public enum Discount {
    GENERAL(4,1.0),
    STUDENT(3,0.97),
    SOLDIER(2,0.95),
    VETERAN(1,0.9);

    private final int type;
    private final Double rate;

    Discount(int type, Double rate) {
      this.type = type;
      this.rate = rate;
    }

    public Double getRate() {
      return rate;
    }

    public int getType() {
      return type;
    }

    public int getPercent() {
      return (int) Math.round((1-rate)*100);
    }
}

