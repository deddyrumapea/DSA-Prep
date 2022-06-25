class Solution {
    fun reverseString(s: CharArray): Unit {
        var left = 0
        var right = s.lastIndex
        
        for (i in 0..(s.lastIndex / 2)){
            s[i] = s[s.lastIndex - i].also{
                s[s.lastIndex - i] = s[i]
            }
        }
    }

    fun reverseString2(s: CharArray): Unit {
        val result = CharArray(s.size)
        for (i in s.indices) {
            result[i] = s[s.lastIndex - i]
        }
        
        for (i in result.indices){
            s[i] = result[i]
        }
    }
}