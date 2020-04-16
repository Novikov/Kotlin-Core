package objects

fun main(args:Array<String>){

    val ref = object:ThresholdChecker{
        override val lower: Int
            get() = 5
        override val upper: Int
            get() = 7

        override fun isLit(value: Int): Boolean {
           return value > upper
        }

        override fun tooQuiet(value: Int): Boolean {
            return value <= upper
        }

    }
}

object Threshold{
   fun isAboveThreshold(value: Int):Boolean{
       return value>Int.MAX_VALUE
   }
}

class Student private constructor(val firstName: String, val lastName: String) {

    companion object {
        fun loadStudent(studentMap: Map<String, String>): Student {
            val firstName: String = studentMap["first_name"] ?: "First"
            val lastName: String = studentMap["last_name"] ?: "Last"
            return Student(firstName, lastName)
        }
    }
}

interface ThresholdChecker {
    val lower: Int
    val upper: Int
    fun isLit(value: Int): Boolean
    fun tooQuiet(value: Int): Boolean
}
