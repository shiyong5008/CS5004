
/*
import java.util.List;

class Solution {

    int m;
    boolean[] flag;

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {

        int n = rooms.size();
        flag = new boolean[n];
        m = 0;
        dfs(rooms, 0);
        return m == n;

    }

    public void dfs(List<List<Integer>> rooms, int r) {

        flag[r] = true;
        ++m;
        for (int x : rooms.get(r)) {
            if (!flag[x]) {
                dfs(rooms, x);
            }
        }

    }
}

 */

// DFS
// BFS

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {

        int n = rooms.size();
        boolean[] flag = new boolean[n];
        int m = 0;

        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        flag[0] = true;

        while (!q.isEmpty()) {
            int r = q.poll();
            ++m;

            for (int x : rooms.get(r)) {
                if (!flag[x]) {
                    q.add(x);
                    flag[x] = true;
                }
            }
        }
        return m == n;
    }
}


