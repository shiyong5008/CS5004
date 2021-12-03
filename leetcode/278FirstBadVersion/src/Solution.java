/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {

        /* ok but not perfect
        if (isBadVersion(1)) return 1;

        int left = 1, right = n;
        while (left <= right) {
            int mid = (right - left)/2 + left;
            if (isBadVersion(mid) && !isBadVersion(mid-1)) {
                return mid;
            } else if (isBadVersion(mid) && isBadVersion(mid-1)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return 0;

         */

        int left = 1, right = n;
        while (left < right) {
            int mid = (right - left) / 2 + left;
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;

    }
}
