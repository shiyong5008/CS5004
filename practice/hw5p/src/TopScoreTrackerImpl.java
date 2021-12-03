public class TopScoreTrackerImpl implements TopScoreTracker {
  public OrderedListRun<Run> M1, M2, M3, M4, M5, M6, M7, M8, M9, M10, M11, M12;
  public OrderedListRun<Run> year;
  public int N;
  public int M;

  public TopScoreTrackerImpl(int monthlyTopN, int yearlyTopM) {
    this.M1 = new OrderedListImplRun(monthlyTopN);
    this.M2 = new OrderedListImplRun(monthlyTopN);
    this.M3 = new OrderedListImplRun(monthlyTopN);
    this.M4 = new OrderedListImplRun(monthlyTopN);
    this.M5 = new OrderedListImplRun(monthlyTopN);
    this.M6 = new OrderedListImplRun(monthlyTopN);
    this.M7 = new OrderedListImplRun(monthlyTopN);
    this.M8 = new OrderedListImplRun(monthlyTopN);
    this.M9 = new OrderedListImplRun(monthlyTopN);
    this.M10 = new OrderedListImplRun(monthlyTopN);
    this.M11 = new OrderedListImplRun(monthlyTopN);
    this.M12 = new OrderedListImplRun(monthlyTopN);
    this.year= new OrderedListImplRun(yearlyTopM);
    this.N = monthlyTopN;
    this.M = yearlyTopM;
  }

  @Override
  public void addRun(int m, Run r) {
    switch (m) {
      case 1:
        M1.addRunHelp(r);
      case 2:
        M2.addRunHelp(r);
      case 3:
        M3.addRunHelp(r);
      case 4:
        M4.addRunHelp(r);
      case 5:
        M5.addRunHelp(r);
      case 6:
        M6.addRunHelp(r);
      case 7:
        M7.addRunHelp(r);
      case 8:
        M8.addRunHelp(r);
      case 9:
        M9.addRunHelp(r);
      case 10:
        M10.addRunHelp(r);
      case 11:
        M11.addRunHelp(r);
      case 12:
        M12.addRunHelp(r);
    }
  }

  @Override
  public String annualReport() {
    OrderedListRun year = M1.merge(M2.merge(M3.merge(M4.merge(M5.merge(M6.merge(M7.merge(M8.merge(M9.merge(M10.merge(M11.merge(M12)))))))))));
    year.resize(M);
    String annualR=year.toString();
    return annualR;
  }


}
