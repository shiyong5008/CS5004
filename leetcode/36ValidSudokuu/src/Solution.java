import java.util.HashMap;

class Solution {
    public boolean isValidSudoku(char[][] board) {

        /*
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i=0; i<9; i++) {
            for (int j=0; j<9; j++) {
                char ch = board[i][j];
                int count;
                if (ch == '.') {
                    count = 0;
                } else {
                    count = map.getOrDefault(ch, 0) + 1;
                }
                map.put(ch, count);
            }
            for (int k = 0; k<9; k++) {
                char ch = board[i][k];
                int check = map.getOrDefault(ch, 0);
                if (check > 1) {
                    return false;
                }
            }
            map.clear();
        }

        for (int i=0; i<9; i++) {
            for (int j=0; j<9; j++) {
                char ch = board[j][i];
                int count;
                if (ch == '.') {
                    count = 0;
                } else {
                    count = map.getOrDefault(ch, 0) + 1;
                }
                map.put(ch, count);
            }
            for (int k = 0; k<9; k++) {
                char ch = board[k][i];
                int check = map.getOrDefault(ch, 0);
                if (check > 1) {
                    return false;
                }
            }
            map.clear();
        }

        for (int i=0; i<9; i++) {
            for (int j = 0; j < 9; j++) {
                char ch = board[i/3 *3 +j/3][i%3 *3 + j%3];
                int count;
                if (ch == '.') {
                    count = 0;
                } else {
                    count = map.getOrDefault(ch, 0) + 1;
                }
                map.put(ch, count);
            }
            for (int k = 0; k<9; k++) {
                char ch = board[i/3 *3 +k/3][i%3 *3 + k%3];
                int check = map.getOrDefault(ch, 0);
                if (check > 1) {
                    return false;
                }
            }
            map.clear();
        }

        return true;

         */





        HashMap<Character, Integer> map = new HashMap<>();

        for (int i=0; i<9; i++) {
            for (int j=0; j<9; j++) {
                char ch = board[i][j];
                int count;
                if (ch == '.') {
                    count = 0;
                } else {
                    count = map.getOrDefault(ch, 0) + 1;

                    if (count > 1) return false;

                }
                map.put(ch, count);
            }

            map.clear();
        }

        for (int i=0; i<9; i++) {
            for (int j=0; j<9; j++) {
                char ch = board[j][i];
                int count;
                if (ch == '.') {
                    count = 0;
                } else {
                    count = map.getOrDefault(ch, 0) + 1;

                    if (count > 1) return false;

                }
                map.put(ch, count);
            }

            map.clear();
        }

        for (int i=0; i<9; i++) {
            for (int j = 0; j < 9; j++) {
                char ch = board[i/3 *3 +j/3][i%3 *3 + j%3];
                int count;
                if (ch == '.') {
                    count = 0;
                } else {
                    count = map.getOrDefault(ch, 0) + 1;

                    if (count > 1) return false;

                }
                map.put(ch, count);
            }

            map.clear();
        }

        return true;

    }
}

/*

class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[][] rows = new int[9][9];
        int[][] columns = new int[9][9];
        int[][][] subboxes = new int[3][3][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c != '.') {
                    int index = c - '0' - 1;
                    rows[i][index]++;
                    columns[j][index]++;
                    subboxes[i / 3][j / 3][index]++;
                    if (rows[i][index] > 1 || columns[j][index] > 1 || subboxes[i / 3][j / 3][index] > 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}

作者：LeetCode-Solution
        链接：https://leetcode-cn.com/problems/valid-sudoku/solution/you-xiao-de-shu-du-by-leetcode-solution-50m6/
        来源：力扣（LeetCode）
        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。


 */