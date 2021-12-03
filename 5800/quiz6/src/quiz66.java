import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

public class quiz66 {

    /*
    static class Hash {

        HashMap<Integer, Integer> map;

        public Hash() {
            this.map = new HashMap<Integer, Integer>();
            for (int i = 1; i <= 11; ++i) {
                this.map.put(i, 1);
            }
        }

        public static HashMap<Integer, Integer> getMap() {
            return this.map;
        }

     */

    /*

        public static int[] lookForNumber(int n) {

            int cntX = 0, cntY = 0;
            int[] list = new int[67];
            int j = 0;

            for (int i = 0; i <= 66; ++i) {
                int x = 0, y = 0, z = 0;
                while (z < i) {
                    x = pickCard();
                    z = z + x;
                    ++cntX;
                    if (z < i) {
                        y = pickCard();
                        z = z + y;
                        ++cntY;
                    }
                }
                if (cntY == cntX && j < 67) {
                    list[j] = i;
                    ++j;
                }
            }
            return list;
        }

        public static void main(String[] args) {
            System.out.println(Arrays.toString(lookForNumber(10)));
        }


        public static int pickCard(HashMap<Integer, Integer> map) {

            int k = 0;
            boolean flag = true;
            while (flag) {
                Random rand = new Random();
                int p = rand.nextInt(12);

                int sum = 0;
                for (int val : map.values()) {
                    sum = sum + val;
                }

                if (map.get(p) == 0 && sum > 0) {
                    flag = true;
                } else {
                    k = p;
                    map.put(p, 0);
                    flag = false;
                }
            }
            return k;
        }

     */


    public static int[] ran(int n) {

        int[] list = new int[n];

        for (int i = 0; i < n; ++i) {

            int l = 0;

            boolean flag = true;
            while (flag) {
                Random rand = new Random();
                int p = rand.nextInt(11) + 1;
                for (int j = 0; j < n; ++j) {
                    flag = false;
                    if (p == list[j]) {
                        flag = true;
                        break;
                    }
                }
                l = p;
            }
            list[i] = l;
        }
        return list;
    }

    public static void main(String[] args) {
        int[] list1 = ran(11);
        System.out.println(Arrays.toString(list1));
        int[] list2 = ran(11);
        System.out.println(Arrays.toString(list2));
    }



}
