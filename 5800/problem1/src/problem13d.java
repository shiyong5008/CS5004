public class problem13d {

    public static void main(String[] args) {
        double in = 2048;
        double k = Math.log(in)/Math.log(2);

        double sum = 0;
        double ave = 0;
        double nodes = 0;

        for (int i = 1; i <= k; i++) {
            sum = sum + i * Math.pow(2, i-1);
            nodes = nodes + Math.pow(2, i-1);
            System.out.println(i + "-" + String.format("%.0f", Math.pow(2, i-1)) +
                    "-" + String.format("%.0f", nodes) +  " : " + String.format("%.0f", sum));
        }
        double n = Math.pow(2, k) - 1;
        ave = sum / n;

        System.out.println("sum: " + sum);
        System.out.println("n=" + String.format("%.0f", n) + " ave=" + ave);
    }
}
