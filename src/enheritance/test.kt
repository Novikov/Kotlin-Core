package enheritance

fun main(){
    val a:A = B()
    println(a.foo(a=1))
}

open class A{
    open fun foo(a:Int=1,b:Int=2):String = "$a$b"
}

class B : A(){
    override fun foo(a: Int, b: Int): String {
        return super.foo(a, b)
    }
}

