package com.shenby.hfokt.chapii.test

import io.kotlintest.data.forall
import io.kotlintest.shouldBe
import io.kotlintest.shouldNotBe
import io.kotlintest.specs.StringSpec
import io.kotlintest.tables.row

/**
 * 参照
 * @see TotallerTest 相同的测试结果，不同的过程
 * kotlin-doc的写法 https://www.kotlincn.net/docs/reference/kotlin-doc.html
 */
class AnotherTotallerTest : StringSpec({
    "加3 加4 并且不会出错" {
        val totaller = Totaller()

        totaller.add(3) shouldBe 3
        totaller.add(4) shouldBe 7
        totaller.add(7) shouldNotBe 15
        totaller.total shouldBe 14
        // 下一行会因结果不对让测试失败
        //totaller.total shouldBe 13
    }

    "测试大量的数据" {
        forall(
            row(1, 2, 3),
            row(19, 47, 66),
            row(11, 21, 32),
        ) { x, y, expectedTotal ->
            val totaller = Totaller(x)
            totaller.add(y) shouldBe expectedTotal

        }
    }

})