package com.shenby.hfokt.chap12

import com.shenby.hfokt.chap07.datas.Person
import com.shenby.hfokt.chap10.Cat

private val s = ""

fun main() {
    val cats = listOf(Cat("蓝猫", 10), Cat("大橘", 20), Cat("家猫", 8))
    //maxBy:找到最大
    //minBy:找到最小
    val catMaxName = cats.maxBy { it.name }
    val catMaxWeight = cats.maxBy { it.weight }
    val catMinWeight = cats.minBy { it.weight }

    val sumOfWight = cats.sumOf { it.weight }
    val sumOfDouble = cats.sumOf { it.weight * 2.0 }

    println("catMaxName = $catMaxName")
    println("catMaxWeight = $catMaxWeight")
    println("catMinWeight = $catMinWeight")
    println("sumOfWight = $sumOfWight")
    println("sumOfDouble = $sumOfDouble")

    val zhangSan = Person("张三", 20)
    val liSi = Person("李四", 25)
    val personMap = mapOf("zhangSan" to zhangSan, "liSi" to liSi)
    val sumOfAge = personMap.values.sumOf { it.age }
    println("sumOfAge = $sumOfAge")

}