package com.shenby.hfokt.chap10

class PetOwner<T : Pet>(t: T) {
    private val pets = mutableListOf(t)

    fun add(t: T) {
        pets.add(t)
    }

    fun remove(t: T) {
        pets.remove(t)
    }
}

fun main() {
    val cat = Cat("蓝猫")
    val cat1 = Cat("家猫")
    val petOwner = PetOwner(cat)
    petOwner.add(cat1)
    petOwner.remove(cat1)

}