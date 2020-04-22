package advanced_classes

fun main(args:Array<String>){
    val c = C()
    val a = A()
    val d = c as A
    val e = a as C



}

open class A(){
    init {
        println("I'm A class")
    }
}

open class B:A(){
    init {
        println("I'm B class")
    }
}

open class C:B(){
    init {
        println("I'm C class")
    }
}