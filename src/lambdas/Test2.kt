package lambdas

fun main(args:Array<String>){
    //Область видимости
    var counter = 0
    val incrementCounter = {
        counter += 1
    }
    incrementCounter()
    incrementCounter()
    incrementCounter()
    println(counter)

    val values = listOf(1, 2, 3, 4, 5, 6)
    values.forEach({
        println("$it: ${it * it}")
    })
}