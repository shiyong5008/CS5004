public interface OrderedListRun<E extends Comparable<E>> {
    // Return the maximum element in the list.
    // It returns null if the list is empty.
    // E getMax();

    // Add `val` to the ordered list.

    // Merge `other` and this list.
    // Returns a new list.
    OrderedListRun merge(OrderedListRun other);

    // Reset the capacity to `newCapacity`.
    // Truncate the smallest elements if length is larger than `newCapacity`.
    void resize(int newCapacity);

    // helper methods
    NodeRun getHead();
    int getCap();
    void addRunHelp(Run val);
}
