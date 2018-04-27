package com.mangles.katas.bowling

import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import kotlin.test.assertEquals


class ScoreSpek : Spek({
    describe("a scoring per frame") {
        it("should return 10 when frame is a Strike") {
            val score = Score().scorePerFrame(Frame("X", "STRIKE"))
            assertEquals(10, score)
        }
        it("should return 10 when frame is a Spare") {
            val score = Score().scorePerFrame(Frame("1/", "SPARE"))
            assertEquals(10, score)
        }
        it("should return 0 when zero pins are down") {
            val score = Score().scorePerFrame(Frame("--", "NOT_ALL_PINS_DOWN"))
            assertEquals(0, score)
        }
        it("should return 5 when 5 pins are down in two tries") {
            val score = Score().scorePerFrame(Frame("32", "NOT_ALL_PINS_DOWN"))
            assertEquals(5, score)
        }
        it("should return 5 when 5 pins are down in first try") {
            val score = Score().scorePerFrame(Frame("5-", "NOT_ALL_PINS_DOWN"))
            assertEquals(5, score)
        }
        it("should return 5 when 5 pins are down in second try") {
            val score = Score().scorePerFrame(Frame("-5", "NOT_ALL_PINS_DOWN"))
            assertEquals(5, score)
        }

    }

})