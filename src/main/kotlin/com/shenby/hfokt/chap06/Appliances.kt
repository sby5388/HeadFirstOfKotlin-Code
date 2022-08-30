package com.shenby.hfokt.chap06

abstract class Appliance {
    var pluggedIn = true
    abstract val color: String
    abstract fun consumePower();
}

class CoffeeMaker : Appliance() {

    override val color: String = ""
    var coffeeLeft = false

    override fun consumePower() {
        println("Consuming power")
    }

    fun fillWithWater() {
        println("fill with water")
    }

    fun makeCoffee() {
        println("make coffee")
    }
}