

fun main(args:Array<String>){
    val ref = C()
    //При приведении типов получаем доступ к уникальным методам класса
    (ref as A).aMethod()
    //Но при вызове переопределенных методов вызовется метод того класса, конструктор которого был вызван при создании первого экземпляра

    (ref as A).method()
}

open class A{
    open fun method(){
        println("Method from class - A")
    }

    open fun aMethod(){
        println("Unique method from class - A ")
    }
}

open class B :A(){
    override fun method() {
        println("Method from class - B")
    }

    open fun bMethod(){
        println("Unique method from class - B ")
    }
}

open class C : B(){
    override fun method(){
        println("Method from class - C")
    }

    open fun cMethod(){
        println("Unique method from class - C ")
    }
}