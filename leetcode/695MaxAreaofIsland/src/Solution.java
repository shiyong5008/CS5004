
/*
class Solution {
    public int maxAreaOfIsland(int[][] grid) {


        int r = grid.length;
        int c = grid[0].length;
        int max = 0;
        for (int i = 0; i < r; ++i) {
            for (int j = 0; j < c; ++j) {
                max = Math.max(max, dfs(grid, i, j));
            }
        }
        return max;

    }

    public int dfs(int[][] grid, int i, int j) {

        int r = grid.length;
        int c = grid[0].length;

        if (grid[i][j] != 1) return 0;
        else grid[i][j] = -1;
        int area = 1;

        if (i-1>=0 && grid[i-1][j] == 1) {
            area = dfs(grid, i-1, j) + area;
        }
        if (i+1<r && grid[i+1][j] == 1) {
            area = dfs(grid, i+1, j) + area;
        }
        if (j-1>=0 && grid[i][j-1] == 1) {
            area = dfs(grid, i, j-1) + area;
        }
        if (j+1<c && grid[i][j+1] == 1) {
            area = dfs(grid, i, j+1) + area;
        }

        return area;

    }
}
*/



class Solution {
    public int maxAreaOfIsland(int[][] grid) {

        int r = grid.length;
        int c = grid[0].length;
        int max = 0;
        int area = 1;
        for (int i = 0; i < r; ++i) {
            for (int j = 0; j < c; ++j) {
                max = Math.max(max, dfs(grid, i, j, area));
            }
        }
        return max;

    }

    public int dfs(int[][] grid, int i, int j, int area) {

        int r = grid.length;
        int c = grid[0].length;

        if (grid[i][j] != 1) return 0;
        else {grid[i][j] = -1;}


        if (i-1>=0 && grid[i-1][j] == 1) {
            area = dfs(grid, i-1, j, area)+1;
        }
        if (i+1<r && grid[i+1][j] == 1) {
            area = dfs(grid, i+1, j, area)+1;
        }
        if (j-1>=0 && grid[i][j-1] == 1) {
            area = dfs(grid, i, j-1, area)+1;
        }
        if (j+1<c && grid[i][j+1] == 1) {
            area = dfs(grid, i, j+1, area)+1;
        }

        return area;

    }
}

