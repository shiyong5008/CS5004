public class T2k {
    public static int T2k(int x) {
        int val = 2;
        if(x==2) {
            return val;
        }
        return 2 * T2k(x/2) + x;
    }

    public static void main(String[] args) {
        int x1 = 4;
        int val1 = T2k(x1);
        System.out.println(val1);
        int x2 = 8;
        int val2 = T2k(x2);
        System.out.println(val2);
        int x = 2048;
        int val = T2k(x);
        System.out.println(val);
    }
}
