public class problem25b {


    public static void main(String[] args) {

        double cx = 0, cy = 0.333333333, qx = 0, qy = 1, px = 0, py = 0, x, y;
        double pc, pq;
        // System.out.println(cy);

        // y = ax + b get the triangle 3 sides and later use it to random points inside
        double degrees = 30;
        double radians = Math.toRadians(degrees);
        double tan = Math.tan(radians);
        double a = 1/tan;
        double b =1;
        // System.out.println(a);

        double hits = 0; // counter of: hit pc<pq
        double inside = 0; // counter of: random point hit inside triangle
        double attempt = 1000000;

        for (int i = 0; i < attempt; i++) {
            x = Math.random();
            y = Math.random();

            // these are the points inside the triangle
            if (y < a * x + b && y < -a * x + b && y > 0) {
                inside++;

                px = x;
                py = y;

                double m = (1-py)/a - px;
                double n = px - (py-1)/a;
                // System.out.println(m);
                // System.out.println(n);

                double pq1 = Math.sqrt(m*m - (m/2)*(m/2));
                double pq2 = Math.sqrt(n*n - (n/2)*(n/2));
                double pq3 = py;

                pq = Math.min(pq1, pq2);
                pq = Math.min(pq, pq3);
                pc = Math.sqrt((px -cx) * (px - cx) + (py - cy) * (py - cy));

                if (pc < pq) {
                    hits++;
                }
            }
        }

        double probability = hits/inside;
        System.out.println(probability);

    }
}
