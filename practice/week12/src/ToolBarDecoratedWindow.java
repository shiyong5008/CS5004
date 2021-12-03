public class ToolBarDecoratedWindow implements Window {
  private Window w;

  public ToolBarDecoratedWindow(Window w) {
    this.w = w;
  }

  @Override
  public void draw() {
    w.draw();
    System.out.println("Drawing a tool bar");
  }
}
