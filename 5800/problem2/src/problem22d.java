import java.util.Random;

public class problem22d {


    public static int count(int n) {

        int cnt = 1;

        int pre = (int)(Math.random() * n);
        for (int i = 0; i < n; i++) {
            int next = (int)(Math.random() * n);
            if (next > pre) {
                cnt++;
                pre = next;
            } else {
                break;
            }
        }
        return cnt;
    }


    public static void main(String[] args) {

        int n = 1000000;
        int test = 1000000;
        double out = 0;

        for (int i = 0; i < test; i++) {
            out = out + count(n);
        }

        double ave = out/test;
        System.out.println(ave);
    }

}
