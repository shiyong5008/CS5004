public class q24 {

    public static void main(String[] args) {

        double n = 267751;
        double res = 0.0;

        for (double i = 1; i <= 19; ++i) {
            res = res + 1 * 1/(n/(Math.pow(2,i-1)));
            System.out.println(i+","+res);

        }

        double sum = 0.0;
        for (double i = 1; i <= 19; ++i) {
            sum = sum + i;
        }

    }
}
