package com.shenby.hfokt.chap06

interface A {
    fun myFunc() {
        println("interface A myFunc ")
    }
}

interface B {
    fun myFunc() {
        println("interface B myFunc ")
    }
}

class C : A, B {

    override fun myFunc() {
        println("c myFunc start")
        super<A>.myFunc()
        super<B>.myFunc()
        println("c myFunc end")
    }
}

fun main() {
    val c = C()
    //由于是接口，所以强制装换还是会调用真正的那个实现
    (c as A).myFunc()
    (c as B).myFunc()
    c.myFunc()
}