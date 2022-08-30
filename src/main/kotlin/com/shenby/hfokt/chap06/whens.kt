package com.shenby.hfokt.chap06

/**
 * odd:奇数
 * 判断一个数是不是奇数
 */
fun Int.isOdd(): Boolean = (this % 2 != 1)


fun main() {
    val ints = arrayOf(40, 60, 80, 95)
    for (point in ints) {
        when (point) {
            in 90..100 -> println("优秀 $point")
            in 75 until 90 -> {
                println("良好 $point")
                println("\t继续努力")
            }
            in 60 until 75 -> println("及格 $point")
            else -> println("不及格 $point")
        }
    }

    // TODO: 2022/8/31 还不能实现
//    var a: Int = 20
//    val odd = when (a) {
//        a.isOdd() -> true
//        else -> false
//    }


}

