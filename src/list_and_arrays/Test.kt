package list_and_arrays

fun main(args:Array<String>){

    //Nullable ператор за скобками определения типа разрешает создавать ссылку на колекцию и присваивать ей Null
    var nullableList: List<Int>? = listOf(1, 2, 3, 4)
    nullableList = null

    //Nullable оператор рядом с типом разрешает создавать null элементы
    var listOfNullables: List<Int?> = listOf(1, 2, null, 4)

    //Для того, чтобы получать доступ к элементам - коллекция должна быть изменяемой
    var simpleList = mutableListOf(1,2,3,4,5,6,7,8,9)
    simpleList[2] = 6
}

