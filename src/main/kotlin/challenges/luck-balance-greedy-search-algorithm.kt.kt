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
    var sum: Int = 0 //initialize a variable `sum` to keep track of total luck obtained
    var count: Int = 0 //initialize a variable `count` to keep track of the number of important contests lost
    val sortedArray =
        contests.sortedByDescending { it.first() } //sort the 2D array in descending order based on the first element of each sub-array
    for (i in sortedArray.indices) { //iterate through the sorted array
        if (sortedArray[i][1] == 1) { //if the contest is important
            if (count < k) { //if the number of important contests lost so far is less than k
                sum += sortedArray[i][0]; //add the luck value of the contest to sum
                count++
            } else { //if the number of important contests lost so far is greater than or equal to k
                sum -= sortedArray[i][0]; //subtract the luck value of the contest from sum
            }
        } else { //if the contest is not important
            sum += sortedArray[i][0]; //add the luck value of the contest to sum
        }
    }
    return sum; //return the total luck value
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
