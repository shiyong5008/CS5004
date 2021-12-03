/**
 * This is going to create the link list. For CS5004/5 lab5.
 *
 * @author  Yong Shi
 * @version 1.0
 * @since   2021-06-16
 */
public interface TList {
    boolean add(String val);
    String get(int index);
    boolean isEmpty();
    String remove(int index);
    int size();
    String oddWords(); // Returns list of odd numbered words only
    String evenWords(); // Returns list of even numbered words only
}
