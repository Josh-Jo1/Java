// https://leetcode.com/problems/largest-rectangle-in-histogram/

class Problem9Solution {
    private int[] heights;

    // divide and conquer algorithm
    private int maxRectArea(int l, int r) {
        int n = r - l + 1;
        if (n == 1) {
            return heights[l];
        }
        int mid = l + n / 2 - 1;
        // check largest area in middle
        int tmpL = mid, tmpR = mid + 1;
        int h = Math.min(heights[tmpL], heights[tmpR]);
        int maxArea = h * 2;
        while (tmpL > l && tmpR < r) {
            if (heights[tmpL - 1] < heights[tmpR + 1]) {
                tmpR++;
                h = Math.min(h, heights[tmpR]);
            } else {
                tmpL--;
                h = Math.min(h, heights[tmpL]);
            }
            int area = h * (tmpR - tmpL + 1);
            if (area > maxArea) maxArea = area;
        }
        while (tmpL > l) {
            tmpL--;
            h = Math.min(h, heights[tmpL]);
            int area = h * (tmpR - tmpL + 1);
            if (area > maxArea) maxArea = area;
        }
        while (tmpR < r) {
            tmpR++;
            h = Math.min(h, heights[tmpR]);
            int area = h * (tmpR - tmpL + 1);
            if (area > maxArea) maxArea = area;
        }
        // recursively check left and right
        int left = maxRectArea(l, mid);
        int right = maxRectArea(mid + 1, r);
        return Math.max(left, Math.max(right, maxArea));
    }

    public int largestRectangleArea(int[] heights) {
        this.heights = heights;
        return maxRectArea(0, heights.length - 1);
    }

    public static void main(String[] args) {
        Problem9Solution sol = new Problem9Solution();
        // int[] grid = new int[] {2,1,5,6,2,3};  // 10
        // int[] grid = new int[] {2,4};  // 4
        int[] grid = new int[] {4,2,0,3,2,4,3,4};  // 10
        System.out.println(sol.largestRectangleArea(grid));
    }
}
