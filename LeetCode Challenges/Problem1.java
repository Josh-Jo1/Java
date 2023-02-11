// https://leetcode.com/problems/generate-parentheses/

import java.util.ArrayList;
import java.util.List;

class Problem1Solution {
    List<String> allCombs = new ArrayList<String>();
    private void generateAllCombs(int n, String possibility) {
        if (n == 0) {
            allCombs.add(possibility);
            return;
        }
        generateAllCombs(n - 1, possibility + "(");
        generateAllCombs(n - 1, possibility + ")");
    }

    public List<String> generateParenthesis(int n) {
        generateAllCombs(n * 2, "");
        List<String> allParenthesis = new ArrayList<String>();
        for (String comb : allCombs) {
            int openParenthesis = 0;
            for (char c : comb.toCharArray()) {
                if (c == '(') openParenthesis += 1;
                else openParenthesis -= 1;

                if (openParenthesis < 0) break;
            }
            if (openParenthesis == 0) allParenthesis.add(comb);
        }
        return allParenthesis;
    }

    public static void main(String[] args) {
        Problem1Solution sol = new Problem1Solution();
        System.out.println(sol.generateParenthesis(3));
    }
}
