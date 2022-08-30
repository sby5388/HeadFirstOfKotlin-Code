package com.shenby.hfokt.chap03.functions

fun main() {
    forLoop()
}

fun forLoop() {
    //包括了首末2个元素
    for (i in 0..10) {
        println("i=$i")
    }

    //不包括最后一个元素
    for (j in 0 until 10) {
        println("j=$j")
    }

    //逆循环 数据递减:包括首末2个元素
    for (k in 10 downTo 0) {
        println("k=$k")
    }

    //step设置步长,相当于java-for :i=i+5
    for (i in 0..50 step 5) {
        println("i=$i")
    }
    //不包括最后一个元素 j+=2
    for (j in 0 until 10 step 2) {
        println("j=$j")
    }

    //逆循环 数据递减:包括首末2个元素;k=k-10
    for (k in 50 downTo 0 step 10) {
        println("k=$k")
    }
}