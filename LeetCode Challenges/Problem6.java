// https://leetcode.com/problems/group-anagrams/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

class Problem6Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // Sort strings into map
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String string : strs) {
            char stringSorted[] = string.toCharArray();
            Arrays.sort(stringSorted);
            String newString = new String(stringSorted);
            if (map.get(newString) == null) {
                List<String> list = new ArrayList<String>();
                list.add(string);
                map.put(newString, list);
            } else {
                map.get(newString).add(string);
            }
        }
        // Return list of anagrams
        List<List<String>> anagrams = new ArrayList<List<String>>(map.values());
        return anagrams;
    }

    public static void main(String[] args) {
        Problem6Solution sol = new Problem6Solution();
        String[] strs = new String[] {"eat","tea","tan","ate","nat","bat"};
        //String[] strs = new String[] {"a"};
        System.out.println(sol.groupAnagrams(strs));
    }
}
