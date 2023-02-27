package challenges

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
 * Complete the 'luckBalance' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts following parameters:
 *  1. INTEGER k
 *  2. 2D_INTEGER_ARRAY contests
 */

fun luckBalance(k: Int, contests: Array<Array<Int>>): Int {
    // Write your code here
    var sum: Int = 0
    //count to check the iteration of k as k is increased
    //if contests[i][1]==1
    var count: Int = 0
    val sortedArray = contests.sortedByDescending { it.first() }
    for (i in sortedArray.indices) {
        if (sortedArray[i][1] == 1) {
            if (count < k) {
                sum += sortedArray[i][0];
                count++
            } else {
                sum -= sortedArray[i][0];
            }
        } else {
            sum += sortedArray[i][0];
        }
    }
    return sum;
}

fun main(args: Array<String>) {
    val first_multiple_input = readLine()!!.trimEnd().split(" ")

    val n = first_multiple_input[0].toInt()

    val k = first_multiple_input[1].toInt()

    val contests = Array<Array<Int>>(n, { Array<Int>(2, { 0 }) })

    for (i in 0 until n) {
        contests[i] = readLine()!!.trimEnd().split(" ").map { it.toInt() }.toTypedArray()
    }

    val result = luckBalance(k, contests)

    println(result)
}
