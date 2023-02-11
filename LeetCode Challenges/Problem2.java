// https://leetcode.com/problems/zigzag-conversion/

class Problem2Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;
        final int sLength = s.length();
        final int buffer = (numRows - 1) * 2;
        String converted = "";
        for (int i = 0; i < numRows && i < sLength; ++i) {
            converted += s.charAt(i);
            final int buffer1 = buffer - i * 2;
            final int buffer2 = i * 2;
            int lastBuffer = (buffer1 != 0 ? buffer1 : buffer2);
            int currIdx = i + lastBuffer;
            while (currIdx < sLength) {
                converted += s.charAt(currIdx);
                if (buffer1 != 0 && buffer2 != 0) {
                    lastBuffer = (lastBuffer == buffer1 ? buffer2 : buffer1);
                }
                currIdx += lastBuffer;
            }
        }
        return converted;
    }

    public static void main(String[] args) {
        Problem2Solution sol = new Problem2Solution();
        System.out.println(sol.convert("P", 2));
    }
}

/* Notes

3 -> 4
4 -> 6
5 -> 8
6 -> 10

numRows = 5
P        H
A      S I
Y    I   R
P  L     I  G
A        N

numRows = 6
P          R
A        I I
Y      H   N
P    S     G
A  I
L

*/
