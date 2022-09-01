package com.shenby.hfokt.chap09

import com.shenby.hfokt.chap07.datas.Person as Man

data class Person(val name: String, var age: Int = 20)


fun main() {
    //有序，可重复；可变
    val listOf = mutableListOf("茶", "鸡蛋", "牛奶")
    println("listOf original:$listOf")
    //不可变
    val extraList = listOf("曲奇饼干", "糖", "鸡蛋")
    listOf.addAll(extraList)
    println("listOf added :$listOf")

    if (listOf.contains("茶")) {
        //对list可以使用数组的操作符 listOf[listOf.indexOf("茶")] = "咖啡"
        listOf.set(listOf.indexOf("茶"), "咖啡")
    }

    listOf.sort()
    println("listOf 顺序 sort :$listOf")
    listOf.reverse()
    println("listOf 逆序 reverse :$listOf")
    listOf.shuffle()
    println("listOf 随机 shuffle :$listOf")

    //set:无序，不重复
    val set = setOf("abc", "abc", "cd", "cd")
    println("set = $set")
    //mutableSet:可修改
    val mutableSet = mutableSetOf("abc")
    mutableSet.addAll(set)
    //生成一个不可变的set
    val toSet: Set<String> = mutableSet.toSet()

    mutableSet.clear()


    val zhang = Person("张三")
    val wang = Person("王五")
    val li = Person("李四")
    val mutableMap = mutableMapOf("zhang" to zhang, "wang" to wang, "li" to li)
    println("mutableMap original = $mutableMap")

    val unKnow = Person("匿名")
    val map = mapOf("unKnow" to unKnow, "wang" to wang)

    println("map before = $map")
    //不可以修改map，但可以修改map中元素的内容
    map["wang"]?.age = 30
    println("map after = $map")

    mutableMap.putAll(map)

    println("mutableMap update = $mutableMap")

    if (mutableMap.containsKey("wang")) {
        println("wang is ${mutableMap.get("wang")}")
        println("wang is ${mutableMap["wang"]?.name}")
    }

    val man = Man("ling", 30)
    println("man = $man")
    //打印出来的依然是原来的类名
    println(man::class.java.name)

}
