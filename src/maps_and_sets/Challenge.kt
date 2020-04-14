package maps_and_sets


fun main(args:Array<String>){
    val nameTitleLookup: MutableMap<String, String?> = mutableMapOf("Mary" to "Engineer", "Patrick" to "Intern", "Ray" to "Hacker")
    nameTitleLookup["Patrick"] = null
    nameTitleLookup.remove("Ray")
    println(nameTitleLookup)

}

fun nameMoreThanNineCharacters(regions:Map<String,String>){
    for((key,value) in regions){
        if (value.length>=8){
            println(value)
        }
    }
}

//Если индекс существует, то значение вставится или вернет null
fun mergeMaps(map1: Map<String, String>, map2: Map<String, String>): Map<String, String>{
    val resultMap = mutableMapOf<String,String>()
    if (map1.isNotEmpty()) {
        for ((key,value) in map1) {
            resultMap.put(key,value)
        }
    }

    if (map2.isNotEmpty()) {
        for ((key,value) in map2) {
            resultMap.put(key,value)
        }
    }

    return resultMap
}

fun occurrencesOfCharacters(text: String): Map<Char, Int>{
    val resultMap:MutableMap<Char,Int> = mutableMapOf()

    for (i in text){
        var charTmp = i
        var charCounter = 0

        for (j in text){
            if(j==i){
                charCounter++
            }
        }
        resultMap[i] = charCounter
    }
    return resultMap
}

fun isInvertible(map: Map<String, Int>): Boolean{
    var uniqueValues:MutableSet<Int> = mutableSetOf()

    for ((key,value) in map){
        uniqueValues.add(value)
    }

    return uniqueValues.size == map.size
}