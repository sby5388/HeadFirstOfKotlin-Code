package com.shenby.hfokt.chap05.animals

//open:该类可以被继承，默认是不允许被继承
open class Animal {

    //子类可以覆盖的属性
    open val image = ""
    open val food = ""
    open val habitat = ""
    var hunger = 0

    //子类可以覆盖的方法
    open fun makeNoise() {
        println("makeNoise")
    }

    open fun eat() {
        println("eat")
    }

    open fun roam() {
        println("roam")
    }

    fun sleep() {
        println("The Animal is sleeping")
    }

}

/**
 * 河马
 */
class Hippo : Animal() {
    //override 重写父类的属性
    override val image = "hippo.jpg"
    override val food = "grass"
    override val habitat = "water"

//    如果某个属性在父类中被定义为val，你可以在子类中使用var属性覆盖它。只需要覆盖该属性并将其声明为var即可。
//    请注意，这只适用于这一种方式。如果尝试使用val覆盖var属性，编译器将会感到沮丧并拒绝编译你的代码。

    //一个类的方法只要被标记为open,那么子类继承父类后 覆盖这个方法，即使没有使用open修饰，该方法依然也是open(可以被继承的)，
    //除非中间被标记为final,才不可以覆盖


    override fun makeNoise() {
        println("Grunt! Grunt!")
    }

    override fun eat() {
        println("the hippo is eating $food")
    }
}

open class Canine : Animal() {
    override fun roam() {
        println("The Canine is roam")
    }
}


class Wolf : Canine() {
    override val image: String
        get() = "wolf.jpg"

    override val food: String
        get() = "meat"

    override val habitat: String
        get() = "forests"

    override fun makeNoise() {
        println("HoooooooW")
    }

    override fun eat() {
        println("The wolf is eating $food")
    }
}

class Vet {
    fun giveShot(animal: Animal) {
        animal.makeNoise()
    }
}

fun main() {
    val animals = arrayOf(Hippo(), Wolf())
    for (item in animals) {
        item.roam()
        item.eat()
    }

    val vet = Vet()
    val wolf = Wolf()
    val hippo = Hippo()

    vet.giveShot(wolf)
    vet.giveShot(hippo)

}
