import java.util.ArrayList;
import java.util.List;

class MyHashMap {
    int key;
    int value;
    List<int[]> lists;

    public MyHashMap() {
        this.lists = new ArrayList<>();
    }

    public void put(int key, int value) {
        int flag = 0;
        for (int i = 0; i < lists.size(); ++i) {
            if (lists.get(i)[0] == key) {
                lists.get(i)[1] = value;
                break;
            } else {
                ++flag;
            }
        }
        if (flag == lists.size()) {
            lists.add(new int[]{key, value});
        }
    }

    public int get(int key) {
        int val = -1;
        for (int i = 0; i < lists.size(); ++i) {
            if (lists.get(i)[0] == key) {
                 val = lists.get(i)[1];
                break;
            }
        }
        return val;
    }

    public void remove(int key) {
        for (int i = 0; i < lists.size(); ++i) {
            if (lists.get(i)[0] == key) {
                lists.remove(lists.get(i));
                break;
            }
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
