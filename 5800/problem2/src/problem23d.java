public class problem23d {

    public static double fac(double f) {
        if (f<=1) return 1;
        else return f * fac(f-1);
    }

    public static double cnm(double n, double m) {
        double up = n;
        for (int i = 1; i < m; i++) {
            up = up * (n-i);
        }
        double dn = m;
        for (int i = 1; i < m; i++) {
            dn = dn * (m-i);
        }
        return up/dn;
    }

    public static double fn(double in) {
        double out = 0;
        if (in == 1) out = 0;
        else if (in == 2) out = 1;
        else out = (in-1) * (fn(in-1) + fn(in-2));
        return out;
    }

    public static double pnk(double n, double k) {
        double pnk = cnm(n, k) * fn(n-k);
        return pnk;
    }

    public static double ave(double n) {
        double sum = n;
        for (double i = 1; i <= n-2; i++) {
            sum = sum + i * pnk(n, i);
        }
        double ave;
        ave = sum/fac(n);
        return ave;
    }

    public static void main(String[] args) {

        double in = 10;
        for (double i = 1; i <= in; i++) {
            double out = ave(i);
            System.out.println(i + " persons average " + out);
        }
        
    }
}
