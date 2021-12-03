public class ExecutionEngine {
  public void execute(Command c) {
    c.run();
  }

  static private ExecutionEngine singletonEngine = new ExecutionEngine();

  static public ExecutionEngine getSingletonEngine() {
    return singletonEngine;
  }

  // make the constructor private so that no one can
  // create an object of this class directly
  private ExecutionEngine() {

  }

  // non-ood
  /*
  static void nonOODExecute(Command c) {
    switch(c.getType()) {
      case "move":
        move(d,m);
        break;
      case "turn":
        turn(d,m);
        break;
    }
  }
   */
}
