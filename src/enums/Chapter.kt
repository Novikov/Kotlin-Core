package enums

import java.util.*

fun main (args:Array<String>){
    //проход по всем элмементам enum
    for (day in DayOfTheWeek.values()) {
        println("Day ${day.ordinal}: ${day.name}")
    }

    println()

    //получение елемента enum по индексу
    val dayAtIndex = DayOfTheWeek.values()[0]
    println("Day at 0 index - $dayAtIndex")

    //получение элемента по значению
    val tuesday = DayOfTheWeek.valueOf("Tuesday")
    println("Tuesday is day ${tuesday.ordinal}")

    //Обращение к статической функции происходит по имени класса
    val today = DayOfTheWeek.today()
    val isWeekend = "It is${if (today.isWeekend) "" else " not"} the weekend"
    println("It is $today. $isWeekend.")

    //Обращение к обычной функции происходит через ссылку на экземпляр класса
    val secondDay = DayOfTheWeek.Thursday
    val daysUntil = today.daysUntil(secondDay)
    println("It is $today. $isWeekend. There are $daysUntil days until $secondDay.")

    //Если ссылке присвоить значение класса перечисления, то он будет просто бесполезен
    //По нему можно лишь вызывать статические функции
    val test = DayOfTheWeek
    println("reference to enum instance - $test")

    //Экземпляр перечисления нужно получать по указанному элементу
    val test2 = DayOfTheWeek.Thursday
    println("reference to enum element - $test2")

    //Перечисления удобно использовать с условной конструкцией when
    when (today) {
        DayOfTheWeek.Monday -> println("I don't care if $today's blue")
        DayOfTheWeek.Tuesday -> println("$today's gray")
        DayOfTheWeek.Wednesday -> println("And $today, too")
        DayOfTheWeek.Thursday -> println("$today, I don't care 'bout you")
        DayOfTheWeek.Friday -> println("It's $today, I'm in love")
        DayOfTheWeek.Saturday -> println("$today, Wait...")
        DayOfTheWeek.Sunday -> println("$today always comes too late")
    }

    //Создание экземпляра Sealed класса
    val currency = AcceptedCurrency.Crypto()
    println("You've got some ${currency.name}!")

    currency.amount = .27541f
    println("${currency.amount} of ${currency.name} is " + "${currency.totalValueInDollars()} in Dollars")

    Downloader().downloadData("foo.com/bar",
            progress = { downloadState ->
                when (downloadState) {
                    null -> println("No download state yet")
                    DownloadState.Starting -> println("Starting download...")
                    DownloadState.InProgress -> println("Downloading data...")
                    DownloadState.Error -> println("An error occurred. Download terminated.")
                    DownloadState.Success -> println("Download completed successfully.")
                }
            },
            completion = { error, list ->
                error?.let { println("Got error: ${error.message}") }
                list?.let { println("Got list with ${list.size} items") }
            })

}

//В первичном конструкторе свойство, которое теперь есть у каждого элемента перечисления
enum class DayOfTheWeek(val isWeekend: Boolean = false){
    //перечисления запоминают порядок
    Sunday,
    Tuesday,
    Wednesday,
    Thursday,
    Friday,
    Saturday(true),
    Monday(true);

    companion object{
        fun today():DayOfTheWeek{
            val calendarDayOfWeek = Calendar.getInstance().get(Calendar.DAY_OF_WEEK)
            var adjustedDay = calendarDayOfWeek - 2
            val days = DayOfTheWeek.values()
            if (adjustedDay < 0) {
                adjustedDay += days.count()
            }
            val today = days.first { it.ordinal == adjustedDay }
            return today
        }
    }

    fun daysUntil(other: DayOfTheWeek): Int {
        if (this.ordinal < other.ordinal) { // 1
            return other.ordinal - this.ordinal // 2
        } else {
            return other.ordinal - this.ordinal +
                    DayOfTheWeek.values().count() //3
        }
    }
}


sealed class AcceptedCurrency {
    abstract val valueInDollars: Float
    var amount: Float = 0.0f

    fun totalValueInDollars(): Float {
        return amount * valueInDollars
    }

    class Dollar: AcceptedCurrency() {
        override val valueInDollars: Float = 1.0F
    }

    class Euro: AcceptedCurrency(){
        override val valueInDollars: Float = 1.25F
    }
    class Crypto: AcceptedCurrency(){
        override val valueInDollars: Float = 2534.92F
    }

    val name: String
        get() = when (this) {
            is Euro -> "Euro"
            is Dollar -> "Dollars"
            is Crypto -> "NerdCoin"
        }
}






