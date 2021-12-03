public class problem23c {


    public static double fac(double f) {
        if (f<=1) return 1;
        else return f * fac(f-1);
    }

    /*
    public static double res(double n) {
        double out = 1/fac(n-1);

        for (int i = 1; i < n-1; i++) {
            out = out + (1/(n-i));
        }
        return out;
    }


    public static void main(String[] args) {
        double n = 100;
        double out = res(n);
        System.out.println(out);
    }

     */

    /*
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

    public static double pnk(double n, double k) {
        double pnk = 1;

        if ((n-k)%2 == 0) {
            pnk = 1 * cnm(n, n-k);
            for (int i = 3; i < n-k; i=i+2) {
                pnk = pnk * cnm(i, 1) * cnm(i, 1);
            }
        } else if ((n-k)%2 == 1) {
            pnk = 2 * cnm(n, n-k);
            for (int i = 4; i < n-k; i=i+2) {
                pnk = pnk * cnm(i, 1) * cnm(i, 1);
            }
        }

        System.out.println(pnk);
        return pnk;
    }

    public static void main(String[] args) {
        double n = 7;
        double sum = n + 0 + 0;
        for (double k = n-2; k > 0; k--) {
            sum = sum + (k * pnk(n, k));
            double test = k * pnk(n, k);
            System.out.println(test + "--");
        }

        System.out.println(sum);
        System.out.println(fac(n));

    }
    */



}
