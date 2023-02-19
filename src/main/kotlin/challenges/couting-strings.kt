import java.io.*
import java.math.*
import java.security.*
import java.text.*
import java.util.*
import java.util.concurrent.*
import java.util.function.*
import java.util.regex.*
import java.util.stream.*
import kotlin.collections.*
import kotlin.comparisons.*
import kotlin.io.*
import kotlin.jvm.*
import kotlin.jvm.functions.*
import kotlin.jvm.internal.*
import kotlin.ranges.*
import kotlin.sequences.*
import kotlin.text.*

/*
 * Complete the 'repeatedString' function below.
 *
 * The function is expected to return a LONG_INTEGER.
 * The function accepts following parameters:
 *  1. STRING s
 *  2. LONG_INTEGER n
 */

fun repeatedString(s: String, n: Long): Long {
    // Write your code here
    var repeatCount:Long=0;
    for(count in 0..s.length-1){
        if(s[count]=='a'){
            repeatCount+=1;
        }
    }
    var unitCount=repeatCount/s.length;
    var rem=n%s.length;
    val sRemainingCount = s.substring(0, rem.toInt())
    val aInRemains = sRemainingCount.length - sRemainingCount.replace("a", "").length
    return (n/s.length * repeatCount) + aInRemains
}

fun main(args: Array<String>) {
    val s = readLine()!!

    val n = readLine()!!.trim().toLong()

    val result = repeatedString(s, n)

    println(result)
}
