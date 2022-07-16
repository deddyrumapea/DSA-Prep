public class Solution {
    /*
     * @param strs: a list of strings
     * @return: encodes a list of strings to a single string.
     */
    public String encode(List<String> strs) {
        // write your code here
        StringBuilder result = new StringBuilder();
        for (String str : strs) result.append(str.length() + "#" + str);
        return result.toString();
    }

    /*
     * @param str: A string
     * @return: dcodes a single string to a list of strings
     */
    public List<String> decode(String str) {
        // write your code here
        List result = new ArrayList<String>();
        int i = 0;
        int j = 0;

        while (i < str.length()) {
            j = i;
            while (str.charAt(j) != '#') ++j;
            int wordLength = Integer.valueOf(str.substring(i, j));
            int startIndex = j + 1;
            String word = str.substring(startIndex, startIndex + wordLength);
            result.add(word);
            i = startIndex + wordLength;
        }

        return result;
    }
}