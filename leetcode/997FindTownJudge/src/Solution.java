class Solution {
    public int findJudge(int n, int[][] trust) {

        int[] ticket = new int[n];

        for (int[] x : trust) {

            ticket[x[0]]--;
            ticket[x[1]]++;

        }

        for (int i = 1; i <= n; ++i) {
            if (ticket[i] == n-1) return i;
        }
        return -1;

    }
}
