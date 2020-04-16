package properties

import kotlin.properties.Delegates

fun main(args:Array<String>){
    val light = LightBulb()
    light.current = 39
    println(LightBulb.maxCurrent)

//    var current = light.current // 0
//    light.current = 40
//    current = light.current // 40

}

class LightBulb {
    companion object {
        const val maxCurrent = 40
    }
    var current by Delegates.vetoable(0) {
        _, _, new ->
        if (new > maxCurrent) {
            println("Current too high, falling back to previous setting.")
                    false
        } else {
            true
        }
    }
}

class Lamp {
    lateinit var bulb: LightBulb
}