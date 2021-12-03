import java.util.Arrays;

public class quiz85 {

    /*
    public static void main(String[] args) {

        double y;
        double[] out = new double[101];

        for (int x = 0; x <= 100; ++x) {
            y = Math.sqrt(50 * 50 + ((100 - x) * 0.5) * ((100 - x) * 0.5));
            out[x] = x + 4*y;
        }
        Arrays.sort(out);
        System.out.println(Arrays.toString(out));

    }

     */

    public static void main(String[] args) {

        double y;
        double[] out = new double[10201];
        int t = 0;

        for (int x = 0; x <= 100; ++x) {
            for (int z = 0; z <= 100; ++z) {
                y = Math.sqrt(((100 - z) * 0.5) * ((100 - z) * 0.5) + ((100 - x) * 0.5) * ((100 - x) * 0.5));
                out[t] = x + 2 * z + 4 * y;
                ++t;
            }
        }
        Arrays.sort(out);
        System.out.println(Arrays.toString(out));

    }

}
