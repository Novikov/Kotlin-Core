package lambdas

fun main(args:Array<String>){
    val b = ::a
    b()
}

fun a(){
    println("a function")
}