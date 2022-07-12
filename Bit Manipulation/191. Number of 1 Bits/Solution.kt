class Solution {
    // you need treat n as an unsigned value
    fun hammingWeight(n: Int): Int {
        var result = 0
        var num = n

        while (num != 0) {
            result += num and 1
            num = num ushr 1
        }

        return result
    }
}

class Solution {
    // you need treat n as an unsigned value
    fun hammingWeight(n:Int):Int {
        var num = n
        var result = 0
        
        while(num != 0){
            num = num and (num - 1)
            ++result
        }
        
        return result
    }
}

class Solution {
    // you need treat n as an unsigned value
    fun hammingWeight(n: Int): Int {
        return Integer.bitCount(n)
    }
}

class Solution {
    // you need treat n as an unsigned value
    fun hammingWeight(n:Int):Int {
        return Integer
            .toBinaryString(n)
            .toCharArray()
            .toList()
            .filter { it == '1'}
            .size
    }
}