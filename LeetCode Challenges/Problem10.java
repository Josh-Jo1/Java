// https://leetcode.com/problems/house-robber/

class Problem10 {

    boolean[] visited = new boolean[101];
    int[] max = new int[101];

    // DP
    public int rob(int[] nums, int i) {
        if (i >= nums.length) return 0;
        if (visited[i]) return max[i];
        int robCurrent = nums[i] + rob(nums, i + 2);
        int robNext = rob(nums, i + 1);
        visited[i] = true;
        max[i] = Math.max(robCurrent, robNext);
        return max[i];
    }

    public int rob(int[] nums) {
        return rob(nums, 0);
    }

    public static void main(String[] args) {
        Problem10 sol = new Problem10();
        // int[] test1 = {1, 2, 3, 1};
        int[] test2 = {2, 7, 9, 3, 1};
        System.out.println(sol.rob(test2));
    }
}
