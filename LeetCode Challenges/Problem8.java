// https://leetcode.com/problems/number-of-times-binary-string-is-prefix-aligned/

class Problem8Solution {
    private boolean isPrefixAligned(int[] binary) {
        boolean foundZero = false;
        for (int num : binary) {
            if (num == 1 && foundZero) {
                return false;
            }
            if (num == 0) {
                foundZero = true;
            }
        }
        return true;
    }

    // Time limit exceeded
    public int numTimesAllBlue(int[] flips) {
        final int n = flips.length;
        int timesPrefixAligned = 0;
        int[] binary = new int[n];      // indices initialized to 0
        for (int flip : flips) {
            final int idx = flip - 1;
            binary[idx] = (binary[idx] == 0 ? 1 : 0);
            if (isPrefixAligned(binary)) {
                ++timesPrefixAligned;
            }
        }
        return timesPrefixAligned;
    }

    // Accepted
    public int numTimesAllBlue1(int[] flips) {
        final int n = flips.length;
        boolean currPrefixAligned = false;
        int timesPrefixAligned = 0;
        int[] binary = new int[n];      // indices initialized to 0
        for (int flip : flips) {
            final int idx = flip - 1;
            if (binary[idx] == 0) {
                binary[idx] = 1;
                if (currPrefixAligned) {
                    if (idx - 1 >= 0 && binary[idx - 1] == 1) {
                        ++timesPrefixAligned;
                    } else {
                        currPrefixAligned = false;
                    }
                } else if (isPrefixAligned(binary)) {
                    currPrefixAligned = true;
                    ++timesPrefixAligned;
                }
            } else {
                binary[idx] = 0;
                if (currPrefixAligned) {
                    currPrefixAligned = false;
                } else if (isPrefixAligned(binary)) {
                    currPrefixAligned = true;
                    ++timesPrefixAligned;
                }
            }
        }
        return timesPrefixAligned;
    }

    public static void main(String[] args) {
        Problem8Solution sol = new Problem8Solution();
        //int[] grid = new int[] {3,2,4,1,5};
        //int[] grid = new int[] {4,1,2,3};
        int[] grid = new int[] {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};
        System.out.println(sol.numTimesAllBlue1(grid));
    }
}
