package com.shenby.hfokt.chap11

import kotlin.math.pow
import kotlin.math.sqrt

fun convert(x: Int, converter: (Int) -> Int): Double {
    return converter(x).toDouble()
}

fun unless(condition: Boolean, code: () -> Unit) {
    if (!condition) {
        code()
    }
}
//使用 typealias为已存在的类型取别名:不能写在类中，要写在类外，也不能写在函数中
//相当于c语言的typedef: typedef int myInt;
typealias DoubleConversion = (Double) -> Double
//使用import **.String as MyString 也有相同的功能
typealias MyString = String


/**
 * 返回一个lambda的高阶函数
 */
fun getCalculator(string: String): DoubleConversion {
    when (string) {
        "平方" -> {
            return { it.pow(2.0) }
        }
        "立方" -> {
            return { it.pow(3.0) }
        }
        "平方根" -> {
            return { sqrt(it) }
        }
        else -> return { it }
    }
}


/**
 * 千克->磅
 */
val kgToPounds = { x: Double -> x * 2.204623 }

/**
 * 磅->美吨
 */
val poundsToUSTone = { x: Double -> x / 2000.0 }


/**
 * 传入2个lambda,返回一个lambda
 */
fun combine(lambda1: DoubleConversion, lambda2: DoubleConversion):
        DoubleConversion {
    return { x: Double -> lambda2(lambda1(x)) }
}


fun main() {
    val options = arrayOf("红", "琥珀色", "绿色")
    val crossWalk = options[(Math.random() * options.size).toInt()]
    if (crossWalk == "绿色") {
        println("Walk")
    }
    unless(crossWalk == "绿色") {
        println("stop")
    }

    val num = 4.0
    println(getCalculator("平方")(num))
    println(getCalculator("立方")(num))
    println(getCalculator("平方根")(num))
    println(getCalculator("++++")(num))

    //千克->美吨:1,kg->pounds;2,pounds->usTones
    val kgsToUsTones = combine(kgToPounds, poundsToUSTone)
    val usTones = kgsToUsTones(1000.0)
    println("1000.0 kg is $usTones usTones")


    //使用typealias
    val combine: DoubleConversion = combine(kgToPounds, poundsToUSTone)
}