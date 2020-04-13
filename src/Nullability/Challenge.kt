package Nullability

fun main(args:Array<String>){
    val a : Int? = divideIfWhole(50,5)
    print("It divides ${a?:0} times")
}

fun divideIfWhole(value: Int, divisor: Int):Int? {
    var result : Int = 0

    if (value % divisor != 0){
        return null
    }

    val iter  = value
    var tmpValue = value

    for (i:Int in 1..iter){
        if (tmpValue % divisor == 0){
            result++
            tmpValue = tmpValue/divisor
        }
    }
    return result
}