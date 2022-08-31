package com.shenby.hfokt.chap07.datas

class TextTools() {
    //这种方法 java无法使用默认参数，只能使用带参数的
    fun test(text: String = "kotlin") {
        println("testForJava test = $text")
    }

    /**
     * @JvmOverloads 会自动生成重载函数，方便JAVA调用，如果不考虑JAVA调用，则不需要使用该注解
     */
    @JvmOverloads
    fun testForJava(text: String = "java") {
        println("testForJava text = $text")
    }
}