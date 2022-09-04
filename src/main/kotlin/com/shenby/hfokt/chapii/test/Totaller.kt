package com.shenby.hfokt.chapii.test

class Totaller(var total: Int = 0) {
    fun add(number: Int): Int {
        total += number
        return total
    }
}