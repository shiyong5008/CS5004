public interface SList {
    boolean add(String val);
    String get(int index);
    boolean isEmpty();
    String remove(int index);
    int size();
    String oddWords(); // Returns list of odd numbered words only
    String evenWords(); // Returns list of even numbered words only
}
