package com.mangles.katas.bowling

class Frame constructor(var sequence:String, private var type:String) {

    fun isStrike(): Boolean {
        return this.type == "STRIKE"
    }

    fun isSpare(): Boolean {
        return this.type == "SPARE"
    }

}
