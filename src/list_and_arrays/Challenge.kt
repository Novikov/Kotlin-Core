package list_and_arrays

import java.util.*

fun main(str:Array<String>){
    val arr:Array<Int> = arrayOf(1,2,3)
    println(arr.joinToString())
    println(randomized(arr)?.joinToString())
}

fun removeOne(item: Int, list: List<Int>): List<Int>{
    val mutList = list.toMutableList()
        mutList.remove(item)
    return mutList
}

fun remove(item: Int, list: List<Int>): List<Int> {
    val tpmList = list.toMutableList()
    val resultList : MutableList<Int> = mutableListOf()

    //Поиск индексов подходящих элементов
    for(tmpItem in tpmList){
        if (tmpItem != item){
            resultList.add(tmpItem)
        }
    }
    return resultList
}

fun reverse(array: Array<Int>): Array<Int>{
    val tmpArray = array.clone()

   for(iter in array.lastIndex downTo 0 ){
       val tmpValue = array[iter]
       val tmpArrayIndex = tmpArray.size-(iter+1)
       tmpArray[tmpArrayIndex] = tmpValue
   }

return  tmpArray
}

fun randomized(array: Array<Int>): Array<Int>?{
    val tmpArray = array.clone()

    if(array.isEmpty())
        return null

    val random = Random()

    for(i in 1..10){
        val firstIndex = random.nextInt(array.size-1)
        val lastIndex = random.nextInt(array.size-1)
        val tmpValue:Int
        tmpValue = tmpArray[firstIndex]
        tmpArray[firstIndex] = tmpArray[lastIndex]
        tmpArray[lastIndex] = tmpValue
    }
    return tmpArray
}

fun minMax(numbers: Array<Int>): Pair<Int, Int>?{
   val result : Pair<Int,Int>

    if(numbers.isEmpty())
        return null

    var tmpMin:Int = 0
    var tmpMax:Int = 0

    for(i in numbers){
        if(i < tmpMin){
            tmpMin = i
        }

        if(i>tmpMax){
            tmpMax = i
        }

    }

    return Pair(tmpMin,tmpMax)

}