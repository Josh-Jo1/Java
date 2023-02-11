// https://leetcode.com/problems/rotate-image/

import java.util.Arrays;

// Results:
//    Runtime: 0 ms, faster than 100.00% of Java online submissions for Rotate Image.
//    Memory Usage: 42.3 MB, less than 16.34% of Java online submissions for Rotate Image.
class Problem3Solution {
    public void rotate(int[][] matrix) {
        final int n = matrix.length;
        if (n == 0 || n == 1) return;

        int startIdx = 0;
        int endIdx = n - 1;
        while (startIdx < endIdx) {
            for (int i = 0; startIdx+i < endIdx; ++i) {
                int switchNum = matrix[startIdx][startIdx+i];
                int prevNum = matrix[startIdx+i][endIdx];
                // First switch
                matrix[startIdx+i][endIdx] = switchNum;
                switchNum = prevNum;
                prevNum = matrix[endIdx][endIdx-i];
                // Second switch
                matrix[endIdx][endIdx-i] = switchNum;
                switchNum = prevNum;
                prevNum = matrix[endIdx-i][startIdx];
                // Third switch
                matrix[endIdx-i][startIdx] = switchNum;
                // Fourth switch
                matrix[startIdx][startIdx+i] = prevNum;
            }
            // for (int[] row : matrix) {
            //     System.out.println(Arrays.toString(row));
            // }
            ++startIdx;
            --endIdx;
        }
    }

    public static void main(String[] args) {
        Problem3Solution sol = new Problem3Solution();
        //int[][] matrix = new int[][] {{1,2,3},{4,5,6},{7,8,9}};
        int[][] matrix = new int[][] {{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
        sol.rotate(matrix);
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }
}
