package com.shenby.hfokt.chapi.coroutine

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.io.File
import javax.sound.sampled.AudioSystem

suspend fun playBeats(beats: String, file: String) {
    println("playBeats beats = $beats ,file = $file")
    val parts = beats.split("x")
    var count = 0
    for (part in parts) {
        count += part.length + 1
        if (part == "") {
            playSound(file)
        } else {
            //delay:将代码挂起指定的时长，只能在协程或者suspend的函数中使用
            delay(100 * (part.length + 1L))
            if (count < beats.length) {
                playSound(file)
            }
        }
    }
}

fun playSound(file: String) {
    println("playSound file = $file")
    val clip = AudioSystem.getClip()
    val audioInputStream = AudioSystem.getAudioInputStream(File(file))
    clip.open(audioInputStream)
    clip.start()
}

/**
 * suspend:挂起函数声明，表明这是一个耗时操作
 */
suspend fun main() {
    val folder = "./src/main/resources/"

    //运行一个阻塞代码块
    runBlocking {
        //启动一个协程
        launch {
            //鼓
            playBeats("x-x-x-x-x-x-", "${folder}toms.aiff")
        }
        //铜钹 tong2bo2
        playBeats("x----x----", "${folder}crash_cymbal.aiff")
    }

    delay(1000)
}