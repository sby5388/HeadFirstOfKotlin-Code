package com.shenby.hfokt.chap03.functions

private const val Rock = "石头"
private const val Scissors = "剪刀"
private const val Paper = "布"

fun main() {
    //val options = arrayOf("Rock", "Scissors", "Paper")
    val options = arrayOf(Rock, Scissors, Paper)
    val machineChoice = getGameChoice(options)
    val userChoice = getUserChoice(options)

    println("gameChoice = $machineChoice")
    println("userChoice = $userChoice")

    printResult(userChoice, machineChoice)

}

/**
 * 获取机器随机选择
 */
private fun getGameChoice(optionParams: Array<String>) = optionParams[(Math.random() * optionParams.size).toInt()]


/**
 * 获取用户在终端的输入
 */
private fun getUserChoice(optionParams: Array<String>): String {
    //合法输入
    var isValidChoice = false
    var userChoice = ""

    while (!isValidChoice) {
        println("请选择其中一个")
        optionParams.forEach {
            print("$it ")
        }
        println(".")
        //获取终端的输入Scanner(System.in),这里还可以指定输入字符
        val line = readLine()
        //line in optionParams 作用同 optionParams.contains(line)
        if (line != null && line in optionParams) {
            userChoice = line
            isValidChoice = true
        }
        if (!isValidChoice) {
            println("你必须输入一个合法的选项")
        }
    }

    return userChoice
}

/**
 * 打印游戏结果
 *
 * @param userChoice 玩家的输入结果
 * @param machineChoice 电脑随机的结果
 */
private fun printResult(userChoice: String, machineChoice: String): Unit {
    val result: String = if (machineChoice == userChoice) {
        "平局"
    } else if (userChoice == Rock && machineChoice == Scissors
        || userChoice == Scissors && machineChoice == Paper
        || userChoice == Paper && machineChoice == Rock
    ) {
        "你赢了"
    } else {
        "你输了"
    }
    println(result)
}