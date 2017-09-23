enum GuitarType {
  ACOUSTIC, ELECTRIC
}

enum GuitarWood {
  ROSEWOOD, ALDER, MAHOGANY, CEDAR
}

enum GuitarBrand {
  GIBSON, FENDER, IBANEZ, PAUL_REED_SMITH, EPIPHONE, JACKSON, TAYLOR, MARTIN, YAMAHA, RICKENBACKER
}

public class Guitar {
  static int COUNTER = 0x0;
  int sno;
  GuitarBrand brand;
  String model;
  int price;
  GuitarType type;
  GuitarWood topWood, backWood;

  public Guitar (GuitarBrand b, String m, int p, GuitarType t, GuitarWood tw, GuitarWood bw) {
    sno = ++COUNTER;
    brand = b;
    model = m;
    price = p;
    type = t;
    topWood = tw;
    backWood = bw;
  }

  public int getSno() { return sno; }
  public GuitarBrand getBrand() { return brand; }
  public String getModel() { return model; }
  public int getPrice() { return price; }
  public GuitarType getType() { return type; }
  public GuitarWood getTopWood () { return topWood; }
  public GuitarWood getBackWood () { return backWood; }

  public void setSno ( int value ) { sno = value; }
  public void setBrand ( GuitarBrand value ) { brand = value; }
  public void setModel ( String value ) { model = value; }
  public void setPrice ( int value ) { price = value; }
  public void setType ( GuitarType value ) { type = value; }
  public void setTopWood ( GuitarWood value ) { topWood = value; }
  public void setBackWood ( GuitarWood value ) { backWood = value; }
}
