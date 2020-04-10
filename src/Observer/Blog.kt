package Observer

import java.util.*

class Blog : Observable() {
    var article: String = ""
        set(value) {
            field = value
            setChanged()
        }
}