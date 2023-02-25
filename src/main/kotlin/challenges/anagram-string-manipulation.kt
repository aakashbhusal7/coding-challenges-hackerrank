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
 * Complete the 'makeAnagram' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts following parameters:
 *  1. STRING a
 *  2. STRING b
 */

fun makeAnagram(a: String, b: String): Int {
    // Convert each string to an array of strings, where each element of the array is a single character
    var firstWordArray = a.map { it.toString() }.toTypedArray()
    var secondWordArray = b.map { it.toString() }.toTypedArray()

// Group each array of strings by character and count the number of occurrences of each character
    var firstWordWithCount = firstWordArray.groupBy { it }.mapValues { it.value.count() }
    var secondWordWithCount = secondWordArray.groupBy { it }.mapValues { it.value.count() }

// Initialize variables for the number of deletions needed and for keeping track of characters that are common to both strings
    var deleteLength: Int = 0
    var commonStringArr = ArrayList<String>()

// Loop through each character in the first string and check if it is in the second string
// If it is, calculate the difference in counts and add it to the deletion count
// If it is not, add the count to the deletion count
// Add the character to the commonStringArr if it is present in both strings
    firstWordWithCount.forEach { (key, value) ->
        if (value != secondWordWithCount.getOrDefault(key, -1)) {
            if (secondWordWithCount.containsKey(key)) {
                deleteLength +=
                    Math.abs(secondWordWithCount.getOrDefault(key, 0) - firstWordWithCount.getOrDefault(key, 0))
                commonStringArr.add(key)
            } else {
                deleteLength += firstWordWithCount.getOrDefault(key, 0)
            }
        }
    }

// Loop through each character in the second string and check if it is in the first string
// If it is and has not already been added to commonStringArr, calculate the difference in counts and add it to the deletion count
// If it is not, add the count to the deletion count
    secondWordWithCount.forEach { (key, value) ->
        if (value != firstWordWithCount.getOrDefault(key, -1)) {
            if (firstWordWithCount.containsKey(key)) {
                if (!commonStringArr.contains(key)) {
                    deleteLength += Math.abs(
                        firstWordWithCount.getOrDefault(key, 0) - secondWordWithCount.getOrDefault(
                            key,
                            0
                        )
                    )
                }
            } else {
                deleteLength += secondWordWithCount.getOrDefault(key, 0)
            }
        }
    }

// Return the deletion count
    return deleteLength;

}

fun main(args: Array<String>) {
    val a = readLine()!!

    val b = readLine()!!

    val res = makeAnagram(a, b)

    println(res)
}
