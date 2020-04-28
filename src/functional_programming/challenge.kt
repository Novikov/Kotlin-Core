package functional_programming

import java.util.*

fun main(args:Array<String>){
    val factorial = generateSequence(1 to 1) {
        it.first + 1 to it.second * (it.first + 1)}
    println(factorial.take(3).map { it.second }.last())
}

fun getNElementsOfFibonacci(n: Int): Sequence<Int> {
    val sequence = generateSequence(1 to 1) {
        it.second to it.first + it.second
    }.map { it.first }

    return sequence.take(n)
}

