public class Test {
  public static void main(String[] args) {
    // emitter
    // create a new command
    //Command cmd = new MoveCommand(2);
    //Command cmd = new TurnCommand(4);
    Command cmd = CommandFactory.newCommand("turn");

    // emit the command to the engine
    //new ExecutionEngine().execute(cmd);
    ExecutionEngine engine = ExecutionEngine.getSingletonEngine();

    ExecutionEngine engine1 = ExecutionEngine.getSingletonEngine();
    engine.execute(cmd);

    //Window w = new VerticallyScrollableWindow();
    //Window w = new WindowWithToolBar();
    //Window w = new VerticallyScrollableWindowWithToolBar();
    //w.draw();
    Window w = new BasicWindow();
    Window verticallyScrollableWindowWithToolBar = new ToolBarDecoratedWindow(new VerticalScrollBarDecoratedWindow(w));
    Window myFinalWindow = new HorizontalScrollBarDecoratedWindow(verticallyScrollableWindowWithToolBar);
    //verticallyScrollableWindowWithToolBar.draw();
    myFinalWindow.draw();
  }

  ////////////////////////////////////////////////////////
  // Non-ood approach


}
