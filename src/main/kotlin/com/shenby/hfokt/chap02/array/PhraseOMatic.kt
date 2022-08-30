package phrase.o.matic

import java.util.Arrays

/**
 * 一个自定义的扩展函数
 */
fun Array<Byte>.sum(): Int {
    var result = 0
    for (b in this) {
        result = result.plus(b)
    }
    return result
}

/*扩展函数应该是生成一个静态方法:如下
fun sum(array: Array<Byte>):Int{
    var result = 0
    for (b in array) {
        result = result.plus(b)
    }
    return result
}
 */


fun main(args: Array<String>) {
    val wordArray1 = arrayOf("24/7", "multi-tier", "B-to-B", "dynamic", "pervasive")
    val wordArray2 = arrayOf("empowered", "leveraged", "aligned", "targeted")
    val wordArray3 = arrayOf("process", "paradigm", "solution", "portal", "vision")

    val arraySize1 = wordArray1.size
    val arraySize2 = wordArray2.size
    val arraySize3 = wordArray3.size

    val rand1 = (Math.random() * arraySize1).toInt()
    val rand2 = (Math.random() * arraySize2).toInt()
    val rand3 = (Math.random() * arraySize3).toInt()

    val phrase = "${wordArray1[rand1]} ${wordArray2[rand2]} ${wordArray3[rand3]}"
    println(phrase)

    val byteArray: Array<Byte> = arrayOf(1, 2, 3)
    println(Arrays.toString(byteArray))
    //扩展函数
    println(byteArray.contentToString())

    println("sum = ${byteArray.sum()}")

}