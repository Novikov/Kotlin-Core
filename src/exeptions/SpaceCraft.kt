package exeptions

import exeptions.customexceptions.BrokenEngineException
import exeptions.customexceptions.OutOfFuelException
import exeptions.customexceptions.SpaceToEarthConnectionFailedException

class SpaceCraft {
    private var isConnectionAvailable: Boolean = false
    private var isEngineInOrder: Boolean = false
    private var fuel: Int = 0

    var isInSpace: Boolean = false

    fun overhaul() {
        if (fuel < 5) {
            refuel()
        }

        if (!isEngineInOrder) {
            repairEngine()
        }

        if (!isConnectionAvailable) {
            fixConnection()
        }
    }

    fun launch() {
        if (fuel < 5) {
            throw OutOfFuelException()
            return
        }
        if (!isEngineInOrder) {
            throw BrokenEngineException()
            return
        }
        if (!isConnectionAvailable) {
            throw SpaceToEarthConnectionFailedException()
            return
        }

        sendMessageToEarth("Trying to launch...")
        fuel -= 5
        sendMessageToEarth("I'm in space!")
        sendMessageToEarth("I've found some extraterrestrials")
        isInSpace = true
    }

    fun refuel() {
        fuel += 5
        sendMessageToEarth("The fuel tank is filled.")
    }
    fun repairEngine() {
        isEngineInOrder = true
        sendMessageToEarth("The engine is in order.")
    }
    fun fixConnection() {
        isConnectionAvailable = true
        sendMessageToEarth("Hello Earth! Can you hear me?")
        sendMessageToEarth("Connection is established.")
    }

    fun land() {
        sendMessageToEarth("Landing...")
        isInSpace = false
    }

    fun sendMessageToEarth(message: String) {
        println("Spacecraft to Earth: $message")
    }
}

