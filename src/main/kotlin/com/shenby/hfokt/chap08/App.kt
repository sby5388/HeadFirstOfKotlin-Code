package com.shenby.hfokt.chap08

class Wolf {
    var hunger = 10
    val food = "meat"

    fun eat() {
        println("The wolf is eating $food")
    }
}

class MyWolf {
    var wolf: Wolf? = getAlphaWolf()
    fun myFunction() {
        wolf?.eat()
    }
}


fun getAlphaWolf(): Wolf? {
    return Wolf()
}

fun main() {
    var w: Wolf? = Wolf()
    if (w != null) {
        w.eat()
    }

    val hunger = w?.hunger
    println("the value of hunger is $hunger")

    val wolf = MyWolf()
    wolf?.wolf?.hunger = 20

    println("the value of wolf?.wolf?.hunger is  ${wolf?.wolf?.hunger}")

    val array = arrayOf("Hi", "Hello", null)
    for (item in array) {
        item?.let {
            println(it)
        }
    }
    getAlphaWolf()?.let { it.eat() }
    if (true) {
        w = null
    }
    //这里会抛出  NullPointerException
    //!!是一个判空断言
    val x = w!!.hunger


}