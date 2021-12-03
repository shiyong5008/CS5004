public class CommandFactory {
  static Command newCommand(String input) {
    switch(input) {
      case "move":
        return new MoveCommand();
      case "turn":
        return new TurnCommand();
      default:
        return new NoopCommand();
    }
  }
}
