package com.shenby.hfokt.chap07.datas

//data:这是一个数据类
//equals:是比较属性的值，而不是对比内存地址
//data类不可以是abstract和open的，但可以继承其他类或者实现接口
data class Person(val name: String, val age: Int) {
    //data类可以添加var,但属性的值不会影响到equals(==)的结果,该属性会被忽略
    var text = ""
}

fun main() {
    val zhangSan = Person("张三", 20)
    val liSi = Person("张三", 20)

    //==只会比较属性是否相等，而===会比较是不是 同一个(内存中的地址相同)
    //==:等价性
    //===:同一性
    //差别如同java重写了equals方法后equals与==的
    println("liSi==zhangSan? ${zhangSan == liSi}")
    println("liSi===zhangSan? ${zhangSan === liSi}")
    println("liSi=$liSi")

    //使用copy方法复制一个数据类，并可以选择修改某些属性，其他值保持不变
    //可以更加简单地根据一个对象创建新的对象
    val wangWu = zhangSan.copy(name = "王五")
    println("wangWu=$wangWu")
    //使用component1：获取第一个属性,component2:第二个属性
    val name: String = wangWu.component1()
    val age = wangWu.component2()

    println("name= $name ,age = $age")
    temp(zhangSan)


}

private fun temp(person: Person) {
    //ide 提示 "创建析构声明"
    val (name, age) = person
    println("temp name=$name")
    println("temp age=$age")
}