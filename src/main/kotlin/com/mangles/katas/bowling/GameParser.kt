package com.mangles.katas.bowling

class GameParser {
    fun parse(gameLine: String): ArrayList<Frame> {
        val frames = gameLine.split(" ")
       return setTypeOfFrame(frames)
    }

    fun setTypeOfFrame(frames: List<String>): ArrayList<Frame> {

        val listOfFrames:ArrayList<Frame> = ArrayList()
        for (frame in frames) {
            when {
                frame.contains("X") -> {
                    listOfFrames.add(Frame(frame, "STRIKE"))
                }
                frame.contains("/") -> {
                    listOfFrames.add(Frame(frame, "SPARE"))
                }
                else -> {
                    listOfFrames.add(Frame(frame, "NOT_ALL_PINS_DOWN"))
                }
            }
        }
        return listOfFrames
    }
}
