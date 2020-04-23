package maps_and_sets

fun main(args:Array<String>){

    //Для того, чтобы узнать как вывелся тип - Ctrl + Shift + P
    var namesAndScores =
            mutableMapOf("Anna" to 2, "Brian" to 2, "Craig" to 8, "Donna" to 6)
    //Уже выделенному типу мы можем присвоить ссылку на пустцую коллекцию,
    // только в данном случае тип уже будет Unit
    namesAndScores = mutableMapOf()

    //Получение доступа по индексу
    var yearOfBirth =
            mutableMapOf("Anna" to 1990, "Brian" to 1991, "Craig" to 1992, "Donna" to 1993)
    println(yearOfBirth)
    yearOfBirth["Anna"] = 1999



    val names = setOf("Anna", "Brian", "Craig", "Anna")

    //Помнить что у коллекций есть интерфейсы, а есть реализации
    //Реализации можно использовать для создания пустых коллекций через конструктор
    val hashSet = HashSet<Int>()


    //Множество можно создать с помощью массива и spread operator *
    val someArray = arrayOf(1,3,5)
    var someSet = mutableSetOf(*someArray)

}