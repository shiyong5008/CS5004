import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int orangesRotting(int[][] grid) {

        /* fail
        int m = grid.length;
        int n = grid[0].length;

        int[][] ans = new int[m][n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 2) ans[i][j] = 0;
                if (grid[i][j] == 1) ans[i][j] = 100000;
                if (grid[i][j] == 0) ans[i][j] = 200000;
            }
        }

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (i - 1 >= 0 && grid[i][j] == 1) ans[i][j] = Math.min(ans[i][j], ans[i-1][j] + 1);
                if (j - 1 >= 0 && grid[i][j] == 1) ans[i][j] = Math.min(ans[i][j], ans[i][j-1] + 1);
            }
        }

        for (int i = 0; i < m; ++i) {
            for (int j = n-1; j >= 0; --j) {
                if (i - 1 >= 0 && grid[i][j] == 1) ans[i][j] = Math.min(ans[i][j], ans[i-1][j] + 1);
                if (j + 1 < n && grid[i][j] == 1) ans[i][j] = Math.min(ans[i][j], ans[i][j+1] + 1);
            }
        }

        for (int i = m-1; i >= 0; --i) {
            for (int j = n-1; j >= 0; --j) {
                if (i + 1 < m && grid[i][j] == 1) ans[i][j] = Math.min(ans[i][j], ans[i+1][j] + 1);
                if (j + 1 < n && grid[i][j] == 1) ans[i][j] = Math.min(ans[i][j], ans[i][j+1] + 1);
            }
        }

        for (int i = m-1; i >= 0; --i) {
            for (int j = 0; j < n; ++j) {
                if (i + 1 < m && grid[i][j] == 1) ans[i][j] = Math.min(ans[i][j], ans[i+1][j] + 1);
                if (j - 1 >= 0 && grid[i][j] == 1) ans[i][j] = Math.min(ans[i][j], ans[i][j-1] + 1);
            }
        }

        int max = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (ans[i][j] == 100000) {
                    return -1;
                } else if (ans[i][j] < 100000) {
                    max = Math.max(max, ans[i][j]);
                }
            }
        }

        return max;

         */

        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
        int count = 0;
        int level = 0;

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                int[] q = new int[]{i, j};
                if (grid[i][j] == 2) {
                    queue.add(q);
                }
                if (grid[i][j] == 1) {
                    ++count;
                }
            }
        }
        if (count == 0) return 0;

        while (!queue.isEmpty()) {
            int ql = queue.size();
            for (int i = 0; i < ql; ++i) {
                int[] q = queue.poll();
                int x = q[0], y = q[1];
                if (x-1 >= 0 && grid[x-1][y] == 1) {
                    queue.add(new int[]{x-1, y});
                    grid[x-1][y] = 2;
                    --count;
                }
                if (y-1 >= 0 && grid[x][y-1] == 1) {
                    queue.add(new int[]{x, y-1});
                    grid[x][y-1] = 2;
                    --count;
                }
                if (x+1 < m && grid[x+1][y] == 1) {
                    queue.add(new int[]{x+1, y});
                    grid[x+1][y] = 2;
                    --count;
                }
                if (y+1 < n && grid[x][y+1] == 1) {
                    queue.add(new int[]{x, y+1});
                    grid[x][y+1] = 2;
                    --count;
                }
            }
            ++level;
        }

        if (count > 0) return -1;
        return level - 1;

    }
}
