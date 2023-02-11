// https://leetcode.com/problems/minimum-path-sum/

class Problem7Solution {
    // Results:
    //   Runtime: 3 ms, faster than 59.58% of Java online submissions for Minimum Path Sum.
    //   Memory Usage: 46.5 MB, less than 8.39% of Java online submissions for Minimum Path Sum.
    public int minPathSum(int[][] grid) {
        final int m = grid.length;
        final int n = grid[0].length;
        if (m == 1 && n == 1) return grid[0][0];
        
        int[][] minPathSums = new int[m][n];
        for (int r = 0; r < m; ++r) {
            int minPath;
            for (int c = 0; c < n; ++c) {
                if (r == 0 && c == 0) minPath = 0;
                else if (r == 0) minPath = minPathSums[0][c - 1];
                else if (c == 0) minPath = minPathSums[r - 1][c];
                else minPath = (minPathSums[r][c - 1] < minPathSums[r - 1][c] ? minPathSums[r][c - 1] : minPathSums[r - 1][c]);
                
                minPathSums[r][c] = minPath + grid[r][c];
            }
        }
        return minPathSums[m - 1][n - 1];
    }
    
    // Results (best of multiple accepted submissions):
    //   Runtime: 2 ms, faster than 89.66% of Java online submissions for Minimum Path Sum.
    //   Memory Usage: 44.8 MB, less than 42.16% of Java online submissions for Minimum Path Sum.
    public int minPathSum2(int[][] grid) {
        final int m = grid.length;
        final int n = grid[0].length;
        if (m == 1 && n == 1) return grid[0][0];
        
        int[] prevRow = new int[n];
        int[] currRow = new int[n];
        for (int r = 0; r < m; ++r) {
            for (int c = 0; c < n; ++c) {
                if (r == 0 && c == 0) currRow[c] = grid[r][c];
                else if (r == 0) currRow[c] = currRow[c - 1] + grid[r][c];
                else if (c == 0) currRow[c] = prevRow[0] + grid[r][c];
                else currRow[c] = (prevRow[c] < currRow[c - 1] ? prevRow[c] : currRow[c - 1]) + grid[r][c];
            }
            prevRow = currRow;
        }
        return prevRow[n - 1];
    }

    public static void main(String[] args) {
        Problem7Solution sol = new Problem7Solution();
        //int[][] grid = new int[][] {{1,3,1},{1,5,1},{4,2,1}};
        //int[][] grid = new int[][] {{1,2,3},{4,5,6}};
        int[][] grid = new int[][] {{1,2},{1,1}};
        System.out.println(sol.minPathSum2(grid));
    }
}
