package properties

import kotlin.properties.Delegates

fun main(args:Array<String>){
 val mark2 = Car("Mark2","Silver")
    mark2.fuelTank.level = 0.09
    println(mark2.fuelTank.lowFuel)
}

class IceCream(val name: String = "Empty Name") {
    val ingredients: ArrayList<String> by lazy { arrayListOf<String>() }
}

class Car(val make: String, val color: String, val fuelTank: FuelTank = FuelTank()){

}

class FuelTank(){
    var level:Double by Delegates.observable(0.0) {
        _,_,new->
        lowFuel = new < 0.1
    }
    var lowFuel: Boolean = true
}

