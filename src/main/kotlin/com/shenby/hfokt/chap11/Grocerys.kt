package com.shenby.hfokt.chap11

/**
 * data 类至少有一个var/val属性
 * Grocery:杂货店
 * category:类别
 * unit:
 * unitPrice:单价
 */
data class Grocery(
    val name: String,
    val category: String,
    val unit: String,
    val unitPrice: Double,
    val quantity: Int = 0
)


fun search(list: List<Grocery>, criteria: (g: Grocery) -> Boolean) {
    for (l in list) {
        if (criteria(l)) {
            println(l.name)
        }
    }
}


fun main() {
    val groceries = listOf(
        Grocery("Tomatoes", "Vegetable", "1b", 3.0),
        Grocery("Mushrooms", "Vegetable", "1b", 4.0),
        Grocery("Bagels", "Bakery", "Pack", 1.5),
        Grocery("Olive oil", "Pantry", "Bottle", 6.0),
        Grocery("Ice cream", "Frozen", "Pack", 3.0),
    )

    println("Expensive ingredients")
    search(groceries) {
        it.unitPrice > 5.0
    }

    println("all vegetables")
    search(groceries) {
        it.category == "Vegetable"
    }
    println("all packs")
    search(groceries) {
        it.unit == "Pack"
    }

}

