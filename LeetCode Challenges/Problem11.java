// https://leetcode.com/problems/house-robber-ii/
// Solution based on Problem 10

class Problem11 {

    boolean[][] visited = new boolean[101][2];
    int[] max = new int[101];

    // DP
    public int rob(int[] nums, int i, boolean considerLast) {
        if (i >= nums.length || (!considerLast && i == nums.length - 1)) return 0;
        if (visited[i][considerLast ? 1 : 0]) return max[i];
        int robCurrent = nums[i] + rob(nums, i + 2, considerLast);
        int robNext = rob(nums, i + 1, considerLast);
        visited[i][considerLast ? 1 : 0] = true;
        max[i] = Math.max(robCurrent, robNext);
        return max[i];
    }

    public int rob(int[] nums) {
        int robFirst = nums[0] + rob(nums, 2, false);
        int notRobFirst = rob(nums, 1, true);
        return Math.max(robFirst, notRobFirst);
    }

    public static void main(String[] args) {
        Problem11 sol = new Problem11();
        // int[] test1 = {2, 3, 2};
        // int[] test2 = {1, 2, 3, 1};
        // int[] test3 = {1, 2, 3};
        int[] test4 = {1, 3, 1, 3, 100};
        System.out.println(sol.rob(test4));
    }
}
