class Solution {
    fun reverseWords(s: String): String {
        val words = s.split(regex = " ".toRegex())
        var result = ""
        words.forEachIndexed { idx, str ->
            val word = str.toCharArray()
            for (i in 0..(word.lastIndex / 2)) {
                word[i] = word[word.lastIndex - i].also {
                    word[word.lastIndex - i] = word[i]
                }
            }
            if (idx > 0) result += " "
            result += String(word)
        }
        return result
    }
}