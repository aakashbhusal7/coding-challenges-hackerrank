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
import kotlin.math.abs
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
    // Write your code here
    val firstWordArray = a.map { it.toString() }.toTypedArray()
    val secondWordArray = b.map { it.toString() }.toTypedArray()
    val firstWordWithCount = firstWordArray.groupBy { it }.mapValues { it.value.count() }
    val secondWordWithCount = secondWordArray.groupBy { it }.mapValues { it.value.count() }
    var deleteLength: Int = 0
    val commonStringArr = ArrayList<String>()
    firstWordWithCount.forEach { (key, value) ->
        if (value != secondWordWithCount.getOrDefault(key, -1)) {
            if (secondWordWithCount.containsKey(key)) {
                deleteLength +=
                    abs(secondWordWithCount.getOrDefault(key, 0) - firstWordWithCount.getOrDefault(key, 0))
                commonStringArr.add(key)
            } else {
                deleteLength += firstWordWithCount.getOrDefault(key, 0)
            }
        }
    }
    secondWordWithCount.forEach { (key, value) ->
        if (value != firstWordWithCount.getOrDefault(key, -1)) {
            if (firstWordWithCount.containsKey(key)) {
                if (!commonStringArr.contains(key)) {
                    deleteLength += abs(
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
    return deleteLength;
}

fun main(args: Array<String>) {
    val a = readLine()!!

    val b = readLine()!!

    val res = makeAnagram(a, b)

    println(res)
}
