package classes

fun main(args:Array<String>){
    val john = Person(firstName = "Johnny", lastName = "Appleseed")
    var john2 = Person(firstName = "Johnny", lastName = "Appleseed")
    val bob = Person (firstName = "Bob", lastName = "Dilan")
//    john2 = john

    println(john2 == john)
}

class Person(var firstName: String, var lastName: String) {
    val fullName
        get() = "$firstName $lastName"

    companion object{
        var x = 1
    }
}