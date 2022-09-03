package com.shenby.hfokt

//todo 函数是有名称的，但lambda是没有名称的，除非显式声明而不是匿名
//val functionAdd:lambda(函数)的名称
//(Int, Int) -> Int:lambda(函数)的签名，包括输入和输出: 签名可以省略，编译器会自动推断该类型
//{ x: Int, y: Int -> x + y }:lambda(函数)的实现(定义)
val functionAdd: (Int, Int) -> Int = { x: Int, y: Int -> x + y }

//对于只有一个参数的，在使用了签名之后 可以使用it替代
val functionAddFile1: (Int) -> Int = { x: Int -> x + 5 }
val functionAddFile2: (Int) -> Int = { it + 5 }

//这里无法推断类型，所以不能使用it替代
val functionAddFile3 = { x: Int -> x + 5 }

//无返回值
val functionUnit: (Int, Int) -> Unit = { x: Int, y: Int ->
    val result = x + y
    println("result = $result")
}

val functionInt: () -> Int = { 123 }

/**
 * 接收lambda表达式作为参数
 * kotlin高阶函数：一个使用lambda作为参数或者返回值的函数
 */
fun run(x: Int, y: Int, converter: (Int, Int) -> Int) {
    val result = converter(x, y)
    println("result = $result")
}

fun convert(x: Double, converter: (Double) -> Double): Double {
    val result = converter(x)
    println("$x is converter to $result")
    return result
}

fun convert(x: Int, converter: (Int) -> Int): Double {
    return converter(x).toDouble()
}


fun add(a: Int, b: Int): Int = a + b
fun addDouble(a: Int, b: Int): Double = (a + b).toDouble()

fun main() {
    val addInts = { x: Int, y: Int -> x + y }
    val addInts2Double = { x: Int, y: Int -> addDouble(x, y) }
    val reduceInts = { x: Int, y: Int -> x - y }

    val invoke: Int = addInts.invoke(10, 30)
    println(invoke)

    //com.shenby.hfokt.LambdasKt$main$addInts$1
    println(addInts::class.java.name)

    println(addInts(20, 40))

    val calculation: (Int, Int) -> Int = addInts
    println(calculation.invoke(20, 30))
    println(calculation(20, 30))

    run(100, 50, reduceInts)
    run(100, 50, addInts)




    println(functionAdd(200, 300))

    functionUnit.invoke(30, 40)
    println(functionInt())
    println(functionInt.invoke())

    functionAddFile1.invoke(20)


    val convert: Double = convert(20, { it + 30 })
    //lambda只有一个参数时,可以把lambda移出()
    val convert2: Double = convert(20) { it + 30 }
    println("convert = $convert")


}


