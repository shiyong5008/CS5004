public class VerticalScrollBarDecoratedWindow implements Window {
  Window w;

  public VerticalScrollBarDecoratedWindow(Window w) {
    this.w = w;
  }

  @Override
  public void draw() {
    w.draw();
    System.out.println("Drawing a vertical scroll bar");
  }
}
