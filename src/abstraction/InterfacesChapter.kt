package abstraction

fun main(args:Array<String>){
    //параметры по умолчанию
    val car = OptionalDirection()
    car.turn() // > LEFT
    car.turn(Direction.RIGHT) // > RIGHT

    //реализация по умолчанию
    val falcon = LightFreighter()
    falcon.accelerate() // > Proceed to hyperspace!
    falcon.stop() // > "Whoa, slow down!

    //абстрактные свойства
    val a:Car = Car()
    println(a.name)
}

interface Vehicle {
    fun accelerate()
    fun stop()
}

class Unicycle: Vehicle {
    var peddling = false

    override fun accelerate() {
        peddling = true
    }

    override fun stop() {
        peddling = false
    }
}

enum class Direction {
    LEFT, RIGHT
}
interface DirectionalVehicle {
    fun accelerate()
    fun stop()
    fun turn(direction: Direction)
    fun description(): String
}

//методы в интерфейсах имеют параметры по умолчанию
interface OptionalDirectionalVehicle {
    fun turn(direction: Direction = Direction.LEFT)
}

//при реализации интерфеса значение по умолчанию пробросится самостоятельно
class OptionalDirection: OptionalDirectionalVehicle {
    override fun turn(direction: Direction) {
        println(direction)
    }
}
//интерфейсы могут содержать реализацию методов по умолчанию
interface SpaceVehicle {
    fun accelerate()
    fun stop() {
        println("Whoa, slow down!")
    }
}
//с реализацией или без - любые методы можно переопределять
class LightFreighter: SpaceVehicle {
    override fun accelerate() {
        println("Proceed to hyperspace!")
    }
}

//Интерфейс может хранить только абстрактные свойства
//но для каждого такого свойства можно прописать getter
//Свойства можно переопределять так же как и методы
//то что не переопределим пронаследуется
interface VehicleProperties {
    val weight: Int // abstract
    val name: String
        get() = "Vehicle"
}

class Car: VehicleProperties {
    override val weight: Int = 1000
}

class Tank: VehicleProperties {
    override val weight: Int
        get() = 10000
    override val name: String
        get() = "Tank"
}

//Интерфесы можно наследовать от других интерфейсов
//В наследованных можно переопределять члены родителя
interface WheeledVehicle: Vehicle {
    val numberOfWheels: Int
    var wheelSize: Double
}

//любой класс может реализовывать большое количество интерфейсов
interface Wheeled {
    val numberOfWheels: Int
    val wheelSize: Double
}

class Tricycle: Wheeled, Vehicle {
    override fun accelerate() {
        TODO("Not yet implemented")
    }

    override fun stop() {
        TODO("Not yet implemented")
    }

    override val numberOfWheels: Int
        get() = TODO("Not yet implemented")
    override val wheelSize: Double
        get() = TODO("Not yet implemented")
// Implement both Vehicle and Wheeled
}




