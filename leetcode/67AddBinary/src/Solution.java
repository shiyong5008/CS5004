class Solution {
    public String addBinary(String a, String b) {

        int m = a.length() - 1;
        int n = b.length() - 1;

        StringBuilder str = new StringBuilder();
        // StringBuffer str = new StringBuffer();

        int up = 0;
        int x, y;
        while (m >= 0 || n >= 0) {
            if (m >= 0) {
                x = a.charAt(m) - '0';
            } else {
                x = 0;
            }
            if (n >= 0) {
                y = b.charAt(n) - '0';
            } else {
                y = 0;
            }
            int sum = (x + y + up) % 2;
            up = (x + y + up) / 2;
            str.append(sum);
            --m;
            --n;
        }
        if (up > 0) {
            str.append(up);
        }

        return str.reverse().toString();

    }
}
