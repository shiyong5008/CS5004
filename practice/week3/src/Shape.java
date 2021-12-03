public abstract class Shape {
  private String color;

  public Shape(String color) {
    this.color = color;
  }

  public String getColor() {
    return this.color;
  }

  // making this abstract to leave the implemention to the child
  // because at the parent level, we don't know how to implement
  // this method
  public abstract double area();
}
