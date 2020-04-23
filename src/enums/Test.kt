package enums

fun main(){
    val a = A()
    a
}

class A{
    init {
        println(this::class)
        println(this::class.java)
        println(this::toString)
    }
}