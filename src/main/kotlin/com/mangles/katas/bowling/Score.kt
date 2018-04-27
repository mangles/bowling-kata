package com.mangles.katas.bowling

import java.util.*

class Score {

    val TEN_POINTS = 10
    val ZERO_POINTS = 0
    val LAST_TURN = 9
    val FIRST_BONUS_TURN = 10

    fun score(game: ArrayList<Frame>): Int {
        var score = 0
        for (frame in game.indices) {
            score += if (frame >= LAST_TURN && game[frame].isStrike()) {
                scorePerFrame(game[frame])
            } else {
                scorePerFrame(game[frame]) + bonusScore(game, frame)
            }
        }
        return score
    }

    fun scorePerFrame(frame: Frame): Int {
        return when {
            frame.isStrike() -> TEN_POINTS
            frame.isSpare() -> TEN_POINTS
            else -> (numberPinsDown(frame))
        }
    }

    private fun bonusScore(game: ArrayList<Frame>, frame: Int): Int {
        return when {

            game[frame].isStrike() && frame == FIRST_BONUS_TURN -> scorePerFrame(game[frame + 1])
            game[frame].isStrike() && game[frame + 1].isStrike() -> scorePerFrame(game[frame + 1]) + scorePerFrame(game[frame + 2])
            game[frame].isStrike() -> scorePerFrame(game[frame + 1])
            game[frame].isSpare() && frame == LAST_TURN -> score(GameParser().parse(game[frame].sequence[2].toString()))
            game[frame].isSpare() -> score(GameParser().parse(game[frame + 1].sequence[0].toString()))
            else -> ZERO_POINTS
        }
    }

    private fun numberPinsDown(frame: Frame): Int {
        var pins = 0
        for (turn in frame.sequence.indices) {
            if (frame.sequence[turn].isDigit()) {
                pins += Integer.parseInt(frame.sequence[turn].toString())
            }
        }
        return pins
    }
}
