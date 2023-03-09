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
 * Complete the 'isBalanced' function below.
 *
 * The function is expected to return a STRING.
 * The function accepts STRING s as parameter.
 */

fun isBalanced(s: String): String {
    // Write your code here
    val stack = Stack<Char>()
    for (item in s) {
        if (!item.isBracket()) {
            continue
        }
        if (stack.isNotEmpty() && checkBrackets(stack.peek(), item)) {
            stack.pop()
        } else {
            stack.push(item)
        }
    }
    if (stack.isEmpty()) {
        return "YES"
    } else return "NO"
}

fun Char.isBracket(): Boolean {
    return this == '(' || this == ')' || this == '[' || this == ']' || this == '{' || this == '}'
}

fun checkBrackets(bracket1: Char, bracket2: Char): Boolean {
    return if (bracket1 == '[' && bracket2 == ']') {
        true;
    } else if (bracket1 == '{' && bracket2 == '}') {
        true;
    } else bracket1 == '(' && bracket2 == ')'
}

fun main(args: Array<String>) {
    val t = readLine()!!.trim().toInt()

    for (tItr in 1..t) {
        val s = readLine()!!

        val result = isBalanced(s)

        println(result)
    }
}
