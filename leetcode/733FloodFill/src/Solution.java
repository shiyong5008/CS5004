class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {

        int r = image.length;
        int c = image[0].length;
        int x = image[sr][sc];

        if (x == newColor) {
            return image;
        } else {
            image[sr][sc] = newColor;
        }

        if (sr-1>=0 && image[sr-1][sc] == x) {
            floodFill(image, sr-1, sc, newColor);
        }
        if (sr+1<r && image[sr+1][sc] == x) {
            floodFill(image, sr+1, sc, newColor);
        }
        if (sc-1>=0 && image[sr][sc-1] == x) {
            floodFill(image, sr, sc-1, newColor);
        }
        if (sc+1<c && image[sr][sc+1] == x) {
            floodFill(image, sr, sc+1, newColor);
        }

        return image;

    }
}
