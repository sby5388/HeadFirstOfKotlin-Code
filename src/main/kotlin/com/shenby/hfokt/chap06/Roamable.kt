package com.shenby.hfokt.chap06

import com.shenby.hfokt.chap05.animals.Animal
import com.shenby.hfokt.chap05.animals.Hippo
import com.shenby.hfokt.chap05.animals.Wolf

interface Roamable {
    /**
     * 接口的默认实现,类似于java8的interface-default-method
     */
    fun roam() {
        println("The Roamable is roaming")
    }

    var velocity: Int
        get() = 20
        set(value) {
            //接口中没有field,所以无法field=value
            println("设置值")
        }
}

fun main() {
    val animalsArray: Array<Animal> = arrayOf(Hippo(), Wolf())
    val roamableArray: Array<Roamable> = arrayOf(Hippo(), Wolf(), Vehicle())

    for (able in roamableArray) {
        able.roam()
    }

    for (animal in animalsArray) {
        animal.makeNoise()
        //is:作用等同于java中的instanceof关键字，只不过判断成功后，不需要强制类型装换为子类，而是可以直接调用该子类的方法
        if (animal is Hippo) {
            animal.hippoAble()
        }

        when (animal) {
            is Hippo -> println("this is Hippo")
            is Wolf -> println("this is wolf")
            else -> println("this is another animal")
        }

    }
}