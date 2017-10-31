/**
 * Represents Guitar Type
 */
enum GuitarType {
  ACOUSTIC ("Acoustic"), ELECTRIC ("Electric");
  String name;
  GuitarType (String s) {
    name = s;
  }
  /**
   * Overrides toString representation
   */
  public String toString() {
    return name;
  }
}
