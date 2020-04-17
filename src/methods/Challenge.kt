package methods

import java.lang.Math.PI
import kotlin.math.sqrt
import kotlin.properties.Delegates

fun main(args:Array<String>){

}

class Circle(var radius: Double = 0.0) {
    var area:Double
        get() {
            return kotlin.math.PI * radius * radius
        }
        set(value) {
            radius = sqrt(value / kotlin.math.PI)
        }

    fun grow(factor: Double) {
        area *= 3
    }
}


