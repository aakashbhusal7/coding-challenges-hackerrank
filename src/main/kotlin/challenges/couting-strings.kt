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
 * Complete the 'countingValleys' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts following parameters:
 *  1. INTEGER steps
 *  2. STRING path
 */
fun countingValleys(steps: Int, path: String): Int {
    // Write your code here
    var valleyCount:Int=0;
    var tempCount:Int=0;
    var mountainCount:Int=0;
    for(step in 0..steps-1){
        if(path.get(step)=='D'){
            tempCount+=1;
        }else{
            mountainCount+=1;
            if( tempCount==mountainCount){
                valleyCount+=1;
                //reset values
                tempCount=0;
                mountainCount=0;
            }
        }
    }
    return valleyCount;
}
fun main(args: Array<String>) {
    val steps = readLine()!!.trim().toInt()
    val path = readLine()!!
    val result = countingValleys(steps, path)
    println(result)
}
