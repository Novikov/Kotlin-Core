package functional_programming

fun main(args:Array<String>){
    (0..4).forEach{
        if (it%3==0) {
            println(it)
            return@forEach
        }
    }
}

