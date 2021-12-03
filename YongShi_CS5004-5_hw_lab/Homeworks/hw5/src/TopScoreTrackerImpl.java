import java.util.ArrayList;
import java.util.List;

public class TopScoreTrackerImpl implements TopScoreTracker {
  public OrderedList<Run> M1, M2, M3, M4, M5, M6, M7, M8, M9, M10, M11, M12; //
//  public OrderedListImpl[] monthTest;
  public OrderedList<Run> year;
  public int N;
  public int M;

//  public List<OrderedList<Run>> month;

  public TopScoreTrackerImpl(int monthlyTopN, int yearlyTopM) {
    this.M1 = new OrderedListImpl<Run>(monthlyTopN); //
    this.M2 = new OrderedListImpl<Run>(monthlyTopN);
    this.M3 = new OrderedListImpl<Run>(monthlyTopN);
    this.M4 = new OrderedListImpl<Run>(monthlyTopN);
    this.M5 = new OrderedListImpl<Run>(monthlyTopN);
    this.M6 = new OrderedListImpl<Run>(monthlyTopN);
    this.M7 = new OrderedListImpl<Run>(monthlyTopN);
    this.M8 = new OrderedListImpl<Run>(monthlyTopN);
    this.M9 = new OrderedListImpl<Run>(monthlyTopN);
    this.M10 = new OrderedListImpl<Run>(monthlyTopN);
    this.M11 = new OrderedListImpl<Run>(monthlyTopN);
    this.M12 = new OrderedListImpl<Run>(monthlyTopN);
    this.year= new OrderedListImpl<Run>(yearlyTopM);
    this.N = monthlyTopN;
    this.M = yearlyTopM;
//    this.month = new OrderedListImpl[12];
//    this.month = new ArrayList<>(12);
//    for (int i=0; i<12; i++) {
//      month.add(new OrderedListImpl<Run>(monthlyTopN));
//    }
  }

  @Override
  public void addRun(int m, Run r) {
//    OrderedList<Run> temp = month.get(m-1);
//    temp.add(r);

    switch (m) {
      case 1:
        M1.add(r);
        break;
      case 2:
        M2.add(r);
        break;
      case 3:
        M3.add(r);
        break;
      case 4:
        M4.add(r);
        break;
      case 5:
        M5.add(r);
        break;
      case 6:
        M6.add(r);
        break;
      case 7:
        M7.add(r);
        break;
      case 8:
        M8.add(r);
        break;
      case 9:
        M9.add(r);
        break;
      case 10:
        M10.add(r);
        break;
      case 11:
        M11.add(r);
        break;
      case 12:
        M12.add(r);
        break;
    }
  }

  @Override
  public String annualReport() {
    OrderedList<Run> year = new OrderedListImpl<Run>(24);
    year = M1.merge(M2.merge(M3.merge(M4.merge(M5.merge(M6.merge(M7.merge(M8.merge(M9.merge(M10.merge(M11.merge(M12)))))))))));
 //   OrderedListImpl temp = new OrderedListImpl(this.N *12);
    year.resize(M);
    String annualR=year.toString();
    return annualR;
  }

//  @Override
//  public String toString() {
//    String out = OrderedListImpl.toString;
//    return out;
//  }


}
