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
 * Complete the 'isValid' function below.
 *
 * The function is expected to return a STRING.
 * The function accepts STRING s as parameter.
 */

fun isValid(s: String): String {
    // Write your code here
    val sCount = s.groupBy { it }.mapValues { it.value.count() }
    val commonCount: Int = sCount.iterator().next().value
    var singleValueCount: Int = 0
    sCount.forEach { (_, value) ->
        if (value != commonCount) {
            if (value == 1) singleValueCount++
            if (!(singleValueCount <= 1 && value == 1)) {
                if (value - 1 != commonCount) {
                    return "NO"
                }
            }
        }
    }
    return "YES"
}

fun main(args: Array<String>) {
    val s = readLine()!!

    val result = isValid(s)

    println(result)
}
