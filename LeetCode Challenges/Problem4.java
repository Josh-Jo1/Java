// https://leetcode.com/problems/palindrome-number/
// Follow up asks to solve without converting to string


class Problem4Solution {
    // Requires idx < length of x
    private int getDigit(int x, long place) {
        return (int) (x % place) / (int) (place / 10);
    }

    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        if (x < 10) return true;
        long maxPlace = 1;
        while (x / maxPlace != 0) {
            maxPlace *= 10;
        }
        for (int i = 1; (maxPlace / i) > (i * 10); i *= 10) {
            if (getDigit(x, maxPlace / i) != getDigit(x, i * 10)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Problem4Solution sol = new Problem4Solution();
        System.out.println(sol.isPalindrome(1000000001));
    }
}
