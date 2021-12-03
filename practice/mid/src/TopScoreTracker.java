import java.util.LinkedList;

public interface TopScoreTracker {
  // Tries to add Run `r` to month `m`'s top-N list.
  LinkedList<Run> addRun(int m, Run r);

  // Merge 12 months' top-N lists and generate a top-M list.
  String annualReport();
}
