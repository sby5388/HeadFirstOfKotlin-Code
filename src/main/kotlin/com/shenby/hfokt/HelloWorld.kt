package com.shenby.hfokt

fun main() {
    println("hello kotlin")
    //正数的补码=原码=反码
    //负数的原码：相反数的原码第一位改为1
    //负数的反码：原码的每一位取反，第一位改为1
    //负数的补码：反码+1,第一位为1
    val a: Int = 128
    println("a=$a")
    //shl:l->left:向左移动三位，相当于乘以2^3
    val shl = a.shl(3)
    println("a=${a.toString(2)}")
    //shr:r->right:向右移动三位，相当于除以2^3后取整
    val shr = a.shr(3)

    println("shl=$shl")
    println("shl=${shl.toString(2)}")
    println("shr=$shr")
    println("shr=${shr.toString(2)}")
    val b = a.toByte()
    println("b=$b")
    println("b=${b.toString(2)}")
}