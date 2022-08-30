package com.shenby.hfokt.chap04

class Song(val title: String, val artist: String) {
    init {
        println("构造方法-代码块1")
    }

    init {
        println("构造方法-代码块2")
    }

    fun play() {
        println("开始播放${artist}的歌曲《${title}》")
    }

    fun stop() {
        println("停止播放歌曲《${title}》")
    }

}

fun main() {
    val song = Song("将爱", "王菲")
    song.play()
    song.stop()
}