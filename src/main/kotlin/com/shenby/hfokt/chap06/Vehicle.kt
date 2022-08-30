package com.shenby.hfokt.chap06

//实现接口，不需要在接口名称后面加上()
class Vehicle : Roamable {

    override fun roam() {
        println("the Vehicle is roaming")
    }
}