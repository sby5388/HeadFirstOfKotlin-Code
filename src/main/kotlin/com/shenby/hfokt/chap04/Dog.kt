package com.shenby.hfokt.chap04

import java.util.*

/**
 * @param weight 重量，单位磅
 *
 */
class Dog(val name: String, var weight_param: Int, val breed_param: String) {

    init {
        print("Dog $name has been created. ")
    }

    var activities = arrayOf("Walks")
    val breed = breed_param.uppercase(Locale.getDefault())

    init {
        println("The breed is $breed.")
    }

    /**
     * 自定义一个mutator
     */
    var weight = weight_param
        set(value) {
            if (value > 0) {
                // 2022/8/30 如果使用了weight=value:会进入无限的循环
                field = value
            } else {
                println("体重值 $value 不正确")
            }
        }

    /**
     * 重量，单位kg
     * 自定义了一个 accessor
     */
    val weightInKgs: Double
        get() = weight / 2.2


    fun bark() {
        println(if (weight < 20) "Yip" else "Woof!")
    }
}

fun main() {
    val dog = Dog("小狗", 30, "田园犬")
    dog.bark()
    println("dog.name = ${dog.name}")
    println("dog.weightKg = ${dog.weightInKgs}")
    println("dog.weightKg = ${dog.weight}")
    dog.weight = -20
    println("dog.weightKg = ${dog.weight}")

    val myDog = Dog("Fido", 70, "Mixed")
    myDog.bark()
    myDog.weight = 75
    println("Weight in Kgs is ${myDog.weightInKgs}")
    myDog.weight = -2
    println("Weight is ${myDog.weight}")
    myDog.activities = arrayOf("Walks", "Fetching balls", "Frisbee")
    for (item in myDog.activities) {
        println("My dog enjoys $item")
    }
    val dogs = arrayOf(
        Dog("Kelpie", 20, "Westie"),
        Dog("Ripper", 10, "Poodle")
    )
    dogs[1].bark()
    dogs[1].weight = 15
    println("Weight for ${dogs[1].name} is ${dogs[1].weight}")
}