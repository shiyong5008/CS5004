public class Circle extends Shape {
  private double radius;

  public Circle(String color, double radius) {
    super(color);
    this.radius = radius;
  }

  @Override
  public double area() {
    // pi * r^2
    return radius * radius * Math.PI;
  }
}
