package com.mangles.katas.bowling

import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import kotlin.test.assertEquals


class BowlingSpek : Spek({
    describe("a bowling game") {
        it("should return the score of all missing game") {
            val score = Bowling().calculateScore("-- -- -- -- -- -- -- -- -- --")
            assertEquals(0, score)
        }
        it("should return the score of some pins down in one throw") {
            val score = Bowling().calculateScore("5- -- -- -- -- -- -- -- -- --")
            assertEquals(5, score)
        }
        it("should return the score of some pins down in several throws") {
            val score = Bowling().calculateScore("5- 14 -- -9 -- -- -- -- -- --")
            assertEquals(19, score)
        }
        it("should return the score of some pins down and a spare") {
            val score = Bowling().calculateScore("5/ 1- -- -- -- -- -- -- -- --")
            assertEquals(12, score)
        }
        it("should return the score of some pins down and a spare with pins thrown in the next 2 tries") {
            val score = Bowling().calculateScore("5/ 25 -- -- -- -- -- -- -- --")
            assertEquals(19, score)
        }
        it("should return the result of scoring all strikes") {
            val score = Bowling().calculateScore("X X X X X X X X X X X X")
            assertEquals(300, score)
        }
        it("should calculate the score with 10 pairs of 9 and miss") {
            val score = Bowling().calculateScore("9- 9- 9- 9- 9- 9- 9- 9- 9- 9-")
            assertEquals(90, score)
        }
        it("should calculate the score with all spares except the last one") {
            val score = Bowling().calculateScore("5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/ 54")
            assertEquals(144, score)
        }
        it("should calculate the score with 10 pairs of 5 and spare, with a final 5") {
            val score = Bowling().calculateScore("5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/5")
            assertEquals(150, score)
        }
        it("should calculate the score with 10 pairs of 5 and spare, with a final 0") {
            val score = Bowling().calculateScore("5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/-")
            assertEquals(145, score)
        }

    }

})