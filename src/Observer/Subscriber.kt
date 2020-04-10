package Observer

import java.util.*

class Subscriber : Observer {
    override fun update(o: Observable?, arg: Any?) {
        println("New article is been created \" + $arg")
    }
}