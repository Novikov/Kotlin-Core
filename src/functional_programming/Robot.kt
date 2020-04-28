package functional_programming
import java.util.*

class Robot(val name: String) {
    private var strength: Int = 0
    private var health: Int = 100
    var isAlive: Boolean = true

    init {
        strength = Random().randomStrength()
        report("Created (strength $strength)")
    }

    fun report(message: String) {
        println("$name: \t$message")
    }

    fun attack(robot: Robot) {
        val damage = Random().randomDamage(strength)
        robot.damage(damage)
    }

    private fun damage(damage: Int) {
        val blocked = Random().randomBlock()
        if (blocked) {
            report("Blocked attack")
            return
        }
        health -= damage
        report("Damage -$damage, health $health")
        if (health <= 0) {
            isAlive = false
        }
    }

}

