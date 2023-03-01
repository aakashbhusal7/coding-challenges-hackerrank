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
 * Complete the 'whatFlavors' function below.
 *
 * The function accepts following parameters:
 *  1. INTEGER_ARRAY cost: An array of integers representing the cost of each flavor of ice cream
 *  2. INTEGER money: The amount of money they have to spend
 */

fun whatFlavors(cost: Array<Int>, money: Int): Unit {
    // Create a temporary array to store the result
    val tempArray: Array<Int> = Array(cost.size) { 0 }
    // Create a hash map to store the index of each element in the cost array
    val hashDict = HashMap<Int, Int>()
    // Loop through the cost array
    for (i in cost.indices) {
        // Calculate the complement of the current element
        val complement: Int = money - cost[i];
        // Check if the complement is already in the hash map
        if (!hashDict.containsKey(complement)) {
            // If it is not, add the current element to the hash map with its index as the value
            hashDict[cost[i]] = i
        } else {
            // If it is, update the tempArray with the two indices
            tempArray[0] = hashDict.getOrDefault(complement, 0) + 1
            tempArray[1] = i + 1;
        }
    }
    // Print the two indices separated by a tab character and a new line
    print(tempArray[0])
    print("\t")
    print(tempArray[1])
    print("\n")
}

fun main(args: Array<String>) {
    // Read the number of test cases from standard input
    val t = readLine()!!.trim().toInt()
    // Loop through the test cases
    for (tItr in 1..t) {
        // Read the amount of money and the number of ice cream flavors for each test case
        val money = readLine()!!.trim().toInt()
        val n = readLine()!!.trim().toInt()
        // Read the cost array for each test case
        val cost = readLine()!!.trimEnd().split(" ").map { it.toInt() }.toTypedArray()
        // Call the whatFlavors function to find the two ice cream flavors
        whatFlavors(cost, money)
    }
}
