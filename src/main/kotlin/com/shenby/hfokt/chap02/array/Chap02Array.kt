package com.shenby.hfokt.chap02.array

fun main() {
    val ints = arrayOf(10, 20, 30)
    for (i in ints) {
        println("ints[${ints.indexOf(i)}]=$i")
    }
    println("ints.size = ${ints.size}")
}