public class HorizontalScrollBarDecoratedWindow implements Window {
  private Window w;

  public HorizontalScrollBarDecoratedWindow(Window w) {
    this.w = w;
  }

  @Override
  public void draw() {
    w.draw();
    System.out.println("Drawing a horizontal scroll bar");
  }
}
