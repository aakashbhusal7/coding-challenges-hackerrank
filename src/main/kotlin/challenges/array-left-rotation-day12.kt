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
 * Complete the 'rotLeft' function below.
 *
 * The function is expected to return an INTEGER_ARRAY.
 * The function accepts following parameters:
 *  1. INTEGER_ARRAY a
 *  2. INTEGER d
 */

fun rotLeft(a: Array<Int>, d: Int): Array<Int> {
    // Declare variables to be used in the function
    var count: Int = 0
    val tempArray = Array(a.size) { 0 }
    val currentArray = a

    // Iterate through the input array
    for (i in a.indices) {
        // If i is 0, set the first element of tempArray to the element of currentArray at index d
        if (i == 0) tempArray[0] = currentArray[d]
        // For all other elements in currentArray
        if (i < currentArray.size - 1) {
            // If d + i + 1 is within the bounds of the array,
            // set the corresponding element of tempArray to the
            // corresponding element of currentArray
            if (d + i + 1 < currentArray.size) {
                tempArray[i + 1] = currentArray[d + i + 1]
            } else {
                // If d is equal to the length of the array,
                // set the corresponding element of tempArray to the
                // corresponding element of currentArray
                if (d == a.size - 1) {
                    tempArray[i + 1] = currentArray[i]
                } else {
                    // Otherwise, set the corresponding element of tempArray
                    // to the element of currentArray at index
                    // count and increment count
                    tempArray[i + 1] = currentArray[count];
                    count++
                }
            }
        }
    }
    // Return the resulting array
    return tempArray;
}

fun main(args: Array<String>) {
    val first_multiple_input = readLine()!!.trimEnd().split(" ")

    val n = first_multiple_input[0].toInt()

    val d = first_multiple_input[1].toInt()

    val a = readLine()!!.trimEnd().split(" ").map { it.toInt() }.toTypedArray()

    val result = rotLeft(a, d)

    println(result.joinToString(" "))
}
