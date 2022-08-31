package com.shenby.hfokt.chap07.datas;

// TODO: 2022/8/31 把.java文件放在了src/main/kotlin目录中 会提示找不到该类
public class Chap07 {
    public static void main(String[] args) {
        final TextTools textTools = new TextTools();
        //无法直接调用kotlin中带默认参数的函数
        //textTools.test();
        textTools.test("come from java");
        //可以直接调用kotlin中带默认参数的函数，因为@JvmOverloads会自动生成重载函数
        textTools.testForJava();
    }
}
