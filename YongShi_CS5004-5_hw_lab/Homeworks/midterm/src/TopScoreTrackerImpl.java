import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

public class TopScoreTrackerImpl implements TopScoreTracker {
  int n;
  int m;
  LinkedList<Run> track = new LinkedList<Run>();

  public TopScoreTrackerImpl(int monthlyTopN, int yearlyTopM) {
    this.n=monthlyTopN;
    this.m=yearlyTopM;
  }

  @Override
  public LinkedList<Run> addRun(int m, Run r) {
    LinkedList<Run> track = new LinkedList<Run>();
    track.add(m, r);
    return track;
  }

  @Override
  public String annualReport() {
    Collections.sort(this.track);
    Iterator<Run> it2 = track.iterator();
    String r = "";
    while (it2.hasNext()) {
      Run p = it2.next();
      r=r+p;
    }
    return "(" + r + ")";
  }

}
