package abstraction

fun main(args:Array<String>){

}

interface Animal{
    fun fed()
}

interface WalkAnimal{
    fun walk()
}

interface Dog:Animal,WalkAnimal{
    fun setATask()
}

interface Cat:Animal,WalkAnimal{

}

interface Fish:Animal{
    fun putInATank()
    fun letOutOfTheCage()
    fun cleanTank()
}

interface Bird:Animal{
    fun putInACage()
    fun letOutOfTheCage()
    fun cleanCage()
}

class ConcreteDog:Dog{
    override fun setATask() {
        println("new task for a dog")
    }

    override fun fed() {
        println("dog i eating")
    }

    override fun walk() {
        println("dog is walking")
    }
}

class ConcreteFish:Fish{
    override fun putInATank() {
        println("fish ib a tank")
    }

    override fun letOutOfTheCage() {
       println("fish in a pocket")
    }

    override fun cleanTank() {
        println("tank is cleaned")
    }

    override fun fed() {
        println("fish is eating")
    }

}

class ConcreteCat :Cat{
    override fun fed() {
        println("Cat is eating")
    }

    override fun walk() {
        println("cat is walking")
    }
}

class ConcreteBird:Bird{
    override fun putInACage() {
        println("bird in a cage")
    }

    override fun letOutOfTheCage() {
        println("bird is flying")
    }

    override fun cleanCage() {
        println("cage is clean")
    }

    override fun fed() {
        println("bird is eating")
    }

}




