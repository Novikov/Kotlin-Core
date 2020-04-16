package properties

import kotlin.math.roundToInt

fun main (args:Array<String>){
    val sonyTV = TV(1.4,5.6)
    sonyTV.diagonal = 80
    println(sonyTV.height)
    println(sonyTV.width)
}

class TV(var height: Double, var width: Double) {
    var diagonal: Int
        get() {
        val result = Math.sqrt(height * height + width * width)
        return result.roundToInt()
    }
        set(value) {
            val ratioWidth = 16.0
            val ratioHeight = 9.0
            val ratioDiagonal = Math.sqrt(ratioWidth * ratioWidth +
                    ratioHeight * ratioHeight)
            height = value.toDouble() * ratioHeight / ratioDiagonal
            width = height * ratioWidth / ratioHeight
        }
}