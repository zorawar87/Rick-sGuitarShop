/**
 * Represents Guitar Wood Type
 */
enum GuitarWood {
  ROSEWOOD ("Rosewood"), ALDER ("Alder"), MAHOGANY ("Mahogany"), CEDAR ("Cedar");
  String name;
  GuitarWood (String s) {
    name = s;
  }
  /**
   * Overrides toString representation
   */
  public String toString() {
    return name;
  }
}
