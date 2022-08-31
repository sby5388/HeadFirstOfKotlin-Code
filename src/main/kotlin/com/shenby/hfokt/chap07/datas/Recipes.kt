package com.shenby.hfokt.chap07.datas

data class Recipe(
    val title: String,
    //成分
    val mainIngredient: String,
    //构造函数中使用默认值,主要是为了避免编写辅助构造函数
    //默认参数只能连续放到最后
    val isVegetarian: Boolean = false,
    val difficulty: String = "Easy"
) {
    var other: String = ""
}

class MushRoom(val size: Int, val isMagic: Boolean) {
    //构造方法
    constructor(isMagic_param: Boolean) : this(0, isMagic_param) {
        println("MushRoom constructor")
    }

    init {
        println("MushRoom--")
    }

    override fun toString(): String {
        return "MushRoom(size=$size, isMagic=$isMagic)"
    }

}

//函数的重载
private fun add(a: Int, b: Int): Int = a + b
private fun add(a: Double, b: Double): Double = a + b


fun main() {
    //Thai Curry 泰国咖喱，使用了1个默认参数
    val r1 = Recipe("Thai Curry", "a", false)
    //使用了2个默认参数
    val r2 = Recipe(title = "Thai Curry", "a")
    val r3 = r1.copy(title = "Chicken", difficulty = "hard")

    println("r1 hash code = ${r1.hashCode()}")
    println("r2 hash code = ${r2.hashCode()}")
    println("r3 hash code = ${r3.hashCode()}")

    //var other值不同 不影响 == 操作符
    r1.other = "123"
    r2.other = "456"

    println("r1 toString = $r1")

    println("r1==r2 ? ${r1 == r2}")
    println("r1===r2 ? ${r1 === r2}")
    println("r1==r3 ? ${r1 == r3}")

    val (title, mainIngredient, isVegetarian, difficulty) = r1
    println("title is $title ，mainIngredient is $mainIngredient , vegetarian is $isVegetarian ,difficulty = $difficulty ")


    val recipes = arrayOf(r1, r2, r3)

    for ((title_, mainIngredient_, isVegetarian_, difficulty_) in recipes) {
        println(" loop title is $title_ ，mainIngredient is $mainIngredient_ , vegetarian is $isVegetarian_ ,difficulty = $difficulty_ ")
    }

    val mushRoom1 = MushRoom(10, true)
    val mushRoom2 = MushRoom(true)
    println("mushRoom1 = $mushRoom1")
    println("mushRoom2 = $mushRoom2")


    val a = 10
    val b = 900
    val c = 0.6
    val d = 10.4

    println("$a + $b = ${add(a, b)}")
    println("$c + $d = ${add(c, d)}")


}
