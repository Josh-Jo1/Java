// https://leetcode.com/problems/single-number/

class Problem5Solution {
    // Time limit exceeded
    public int maxArea(int[] height) {
        final int n = height.length;
        int maxArea = 0;
        for (int left = 0; left < n - 1; ++left) {
            for (int right = left + 1; right < n; ++right) {
                int containerHeight = (height[left] < height[right] ? height[left] : height[right]);
                int area = (right - left) * containerHeight;
                if (area > maxArea) maxArea = area;
            }
        }
        return maxArea;
    }

    // Time limit exceeded
    public int maxArea1(int[] height) {
        final int n = height.length;
        int idxMaxHeight = 0;
        for (int i = 0; i < n; ++i) {
            if (height[i] >= height[idxMaxHeight]) idxMaxHeight = i;
        }
        int idxMax2Height = 0;
        for (int i = 0; i < n; ++i) {
            if (i != idxMaxHeight && height[i] >= height[idxMax2Height]) idxMax2Height = i;
        }

        int leftHeight, rightHeight;
        if (idxMaxHeight < idxMax2Height) {
            leftHeight = idxMaxHeight;
            rightHeight = idxMax2Height;
        } else {
            leftHeight = idxMax2Height;
            rightHeight = idxMaxHeight;
        }
        int maxArea = 0;
        for (int left = leftHeight; left > -1; --left) {
            for (int right = rightHeight; right < n; ++right) {
                int containerHeight = (height[left] < height[right] ? height[left] : height[right]);
                int area = (right - left) * containerHeight;
                if (area > maxArea) maxArea = area;
            }
        }
        return maxArea;
    }

    // Accepted
    public int maxArea2(int[] height) {
        int maxArea = 0;
        int leftIdx = 0;
        int rightIdx = height.length - 1;
        while (leftIdx != rightIdx) {
            final int left = height[leftIdx];
            final int right = height[rightIdx];
            // Check area
            int containerHeight = (left < right ? left : right);
            int area = (rightIdx - leftIdx) * containerHeight;
            if (area > maxArea) maxArea = area;
            // Iterate
            if (left < right) ++leftIdx;
            else --rightIdx;
        }
        return maxArea;
    }

    public static void main(String[] args) {
        Problem5Solution sol = new Problem5Solution();
        int[] nums = new int[] {1,8,6,2,5,4,8,3,7};
        System.out.println(sol.maxArea2(nums));
    }
}
