package generics

fun main(args:Array<String>){
    //cheap things
    val cheapThings = listOf(
            CheapThing("Cinder Block table"),
            CheapThing("Box of old books"),
            CheapThing("Ugly old couch")
    )
    val cheapMover = Mover(cheapThings)
    cheapMover.moveEverythingToTruck()
    cheapMover.moveEverythingIntoNewPlace()
    cheapMover.finishMove()

    //breakable things
    val television = BreakableThing("Flat-Screen Television")
    television.smash()
    val breakableThings = listOf(
            television,
            BreakableThing("Mirror"),
            BreakableThing("Guitar")
    )
    val expensiveMover = Mover(breakableThings)
    expensiveMover.moveEverythingToTruck()
    expensiveMover.moveEverythingIntoNewPlace()
    expensiveMover.finishMove()


}

fun <T> List<T>.toBulletedList(): String {
    val separator = "\n - "
    return this.map { "$it" }.joinToString(separator, prefix =
    separator, postfix = "\n")
}

interface Checkable {
    fun checkIsOK(): Boolean
}

class CheapThing(val name: String) :Checkable{
    override fun checkIsOK(): Boolean = true

    override fun toString(): String {
        return name
    }
}

class BreakableThing(val name: String, var isBroken: Boolean = false):Checkable{
    override fun checkIsOK(): Boolean {
        return !isBroken
    }

    fun smash() {
        isBroken = true
    }

    override fun toString(): String {
        return name
    }
}

class Mover<T:Checkable>(thingsToMove: List<T>, val truckHeightInInches: Int = (12 * 12)) {

    private var thingsLeftInOldPlace = mutableListOf<T>()
    private var thingsInTruck = mutableListOf<T>()
    private var thingsInNewPlace = mutableListOf<T>()

    private var thingsWhichFailedCheck = mutableListOf<T>()

    // 4
    init {
        thingsLeftInOldPlace.addAll(thingsToMove)
    }

    // 5
    fun moveEverythingToTruck() {
        while (thingsLeftInOldPlace.count() > 0) {
            val item = thingsLeftInOldPlace.removeAt(0)

            if (item.checkIsOK()) {
                thingsInTruck.add(item)
                println("Moved your $item to the truck!")
            } else {
                thingsInTruck.add(item)
                println("Moved your $item to the truck!")
            }
        }
    }

    // 6
    fun moveEverythingIntoNewPlace() {
        while (thingsInTruck.count() > 0) {
            val item = thingsInTruck.removeAt(0)
            if (item.checkIsOK()) {
                thingsInNewPlace.add(item)
                println("Moved your $item into your new place!")
            } else {
                thingsWhichFailedCheck.add(item)
                println("Could not move your $item into your new place :[")
            }
        }
    }

    // 7
    fun finishMove() {
        println("OK, we finished! We were able to move your:${thingsInNewPlace.toBulletedList()}")
        if (thingsWhichFailedCheck.isNotEmpty()) {
            println("But we need to talk about your:${thingsWhichFailedCheck
                    .toBulletedList()}")
        }
    }
}

