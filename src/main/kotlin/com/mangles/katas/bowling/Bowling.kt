package com.mangles.katas.bowling

class Bowling {
    fun calculateScore(gameLine: String): Int {
        val game: ArrayList<Frame> = GameParser().parse(gameLine)

        return Score().score(game)
    }

}