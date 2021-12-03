class Solution {
    public boolean backspaceCompare(String s, String t) {

        int ls = s.length() - 1;
        int lt = t.length() - 1;
        int cnts = 0;
        int cntt = 0;

        while (ls >= 0 || lt >= 0) {
            while (ls >= 0) {
                char x = s.charAt(ls);
                if (x == '#') {
                    ++cnts;
                    --ls;
                } else {
                    if (cnts > 0) {
                        --cnts;
                        --ls;
                    } else {
                        break;
                    }
                }
            }

            while (lt >= 0) {
                char y = t.charAt(lt);
                if (y == '#') {
                    ++cntt;
                    --lt;
                } else {
                    if (cntt > 0) {
                        --cntt;
                        --lt;
                    } else {
                        break;
                    }
                }
            }

            if (ls == -1 && lt == -1) {
                return true;
            } else if (ls == -1 && lt != -1) {
                return false;
            } else if (lt == -1 && ls != -1) {
                return false;
            } else {
                if (s.charAt(ls) == t.charAt(lt)) {
                    --ls;
                    --lt;
                } else {
                    return false;
                }
            }
        }

        return true;

    }
}
