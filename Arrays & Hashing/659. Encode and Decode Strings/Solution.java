public class Solution {
    /*
     * @param strs: a list of strings
     * @return: encodes a list of strings to a single string.
     */
    public static String encode(List<String> strs) {
        StringBuilder result = new StringBuilder();
        for(String s : strs) result.append(s.length() + "#" + s);
        return result.toString();
    }

     /*
     * @param str: A string
     * @return: dcodes a single string to a list of strings
     */
    public static List<String> decode(String str) {
        // Write your code here
        List<String> result = new ArrayList<>();
        StringBuilder item = new StringBuilder();
 
        int i = 0;
        int j;
 
        while (i < str.length()) {
            j = i;
            while(str.charAt(j) != '#') j++;
            int wordLength = Integer.valueOf(str.substring(i,j));
            int startIndex = j + 1; // skipping number+# characters length
            String subStr = str.substring(startIndex, wordLength + startIndex);
            result.add(subStr);
            i = wordLength + startIndex;
        }
        
        return result;
    }
}