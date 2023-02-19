fun sockMerchant(n: Int, ar: Array<Int>): Int {
//create hashmap to get count of each sock
    val valueWithCount = HashMap<Int, Int>()
    for (iteratedValues in ar) {
        var count = valueWithCount[iteratedValues];
        if (count == null) count = 0;
        valueWithCount[iteratedValues] = count + 1;
    }
    var doubleCount = 0;
    for (finalList in valueWithCount) {
        if (finalList.value >= 2) {
            doubleCount += finalList.value / 2;
        }
    }
    return doubleCount;
}

fun main(args: Array<String>) {
    val n = readLine()!!.trim().toInt()
    val ar = readLine()!!.trimEnd().split(" ").map { it.toInt() }.toTypedArray()
    val result = sockMerchant(n, ar)
    println(result)
}