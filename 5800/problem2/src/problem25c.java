public class problem25c {

    public static void main(String[] args) {

        double cx = 0, cy = 0, qx = 0, qy = 1, px = 0, py = 0, x, y;
        double pc, pq;
        // System.out.println(cy);


        double sides = 1000000000;
        double degrees = 360/sides/2;
        double radians = Math.toRadians(degrees);
        double sin = Math.sin(radians);
        double cos = Math.cos(radians);
        double tan = Math.tan(radians);
        double a = 1 / tan;
        double b = 0;

        double hits = 0; // counter of: hit pc<pq
        double inside = 0; // counter of: random point hit inside triangle
        double attempt = 1000000;

        for (int i = 0; i < attempt; i++) {
            x = (Math.random()-0.5) * 2 * tan;
            y = Math.random();

            // these are the points inside the triangle
            if (y < 1 && y > -a * x && y > a * x) {
                inside++;

                px = x;
                py = y;

                pq = (1-py) * cos;
                pc = Math.sqrt(px*px + py*py);

                if (pc < pq) {
                    hits++;
                }
            }
        }

        double probability = hits/inside;
        System.out.println(probability);

    }
}
