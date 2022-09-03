package com.shenby.hfokt.chap12

import com.shenby.hfokt.chap11.Grocery

fun main() {
    val groceries = listOf(
        Grocery("Tomatoes", "Vegetable", "1b", 3.0, 3),
        Grocery("Mushrooms", "Vegetable", "1b", 4.0, 1),
        Grocery("Bagels", "Bakery", "Pack", 1.5, 2),
        Grocery("Olive oil", "Pantry", "Bottle", 6.0, 1),
        Grocery("Ice cream", "Frozen", "Pack", 3.0, 2),
    )


    val highestUnitPrice = groceries.maxBy { it.unitPrice * 5 }
    println("highestUnitPrice = $highestUnitPrice")
    val lowestQuantity = groceries.minBy { it.quantity }
    println("lowestQuantity = $lowestQuantity")

    val sumQuantity = groceries.sumOf { it.quantity }
    println("sumQuantity = $sumQuantity")

    val totalPrice = groceries.sumOf { it.quantity * it.unitPrice }
    println("totalPrice = $totalPrice")

    //filter:找出蔬菜
    val vegetables = groceries.filter { it.category == "Vegetable" }
    println("vegetables = $vegetables")

    //filterNot:找出不是蔬菜
    val noVegetables = groceries.filterNot { it.category == "Vegetable" }
    println("noVegetables = $noVegetables")

    val listOfOne = listOf(1, 2, 3, 4)
    //map 根据规则转换成另一个列表
    val listOfDouble = listOfOne.map { it * 2.0 }
    println("listOfOne = $listOfOne")
    println("mapDouble = $listOfDouble")
    //链式调用 : x = (x+1)*2.0
    val list3 = listOfOne.map { it + 1 }.map { it * 2.0 }
    println("list3 = $list3")

    val mutableList = listOfOne.toMutableList()
    //mapTo:把转换的结果添加到mutableList中，返回结果方便链式调用
    val result = listOfOne.mapTo(mutableList) { it * 2 }
    println("mutableList = $mutableList")
    println("result = $result")
    //true
    println("mutableList==result?${mutableList == result}")
    //true
    println("mutableList===result?${mutableList === result}")

    val listOf: List<Int?> = listOf(2, 4, 6, null, 20)
    //mapNotNull:根据规则转换，并且过滤任何空值
    val mapNotNull = listOf.mapNotNull {
        it?.times(2)
    }.filter { it < 20 }
    println("mapNotNull = $mapNotNull")

    //for each 循环:支持链式调用
    mapNotNull.forEach {
        println("forEach = $it")
    }
    //功能相同
    for (value in mapNotNull) {
        println("for = $value")
    }

    //groupBy:根据规则分组
    val listMap = groceries.groupBy { it.category }
    listMap.forEach { it ->
        println(it.key)
        it.value.forEach { i2 ->
            println("\t name = ${i2.name}")

        }

    }
    //fold:接收2个参数：初始值，以及希望对该值执行的操作，该操作由lambda定义
    //每个值添加到初始值上
    val sumOfInts = listOfOne.fold(100) { a, b -> a + b }
    println("sumOfInts = $sumOfInts")


    val names = groceries.fold("") { string, item ->
        string + " ${item.name}"
    }
    println("names = $names")

    //减法的使用：50元买下所有的物品剩余的钱
    val changeFrom50 = groceries.fold(50.0) { change, item ->
        change - item.unitPrice * item.quantity
    }
    println("changeFrom50 = $changeFrom50")


}

