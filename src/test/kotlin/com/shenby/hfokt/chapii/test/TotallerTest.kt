package com.shenby.hfokt.chapii.test

import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class TotallerTest {

    private lateinit var mSubject: Totaller

    @BeforeAll
    fun start() {
        println("start")
        mSubject = Totaller()
    }


    @Test
    fun shouldBeAbleToAdd3And4() {

        println("shouldBeAbleToAdd3And4")

        //0+3 == 3
        assertEquals(3, mSubject.add(3))

        //3+4 == 7
        assertEquals(7, mSubject.add(4))

        // 7+7 !=15
        assertNotEquals(15, mSubject.add(7))

        //14
        assertEquals(14, mSubject.total)

    }
}