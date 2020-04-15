package lambdas

fun main(args:Array<String>){
    //1
    val task:()->Unit = { println("Kotlin Apprentice is a great book!")}
    repeatTask(5,task)

    //3
    val appRatings = mapOf(
            "Calendar Pro" to arrayOf(1, 5, 5, 4, 2, 1, 5, 4),
            "The Messenger" to arrayOf(5, 4, 2, 5, 4, 1, 1, 2),
            "Socialise" to arrayOf(2, 1, 2, 2, 1, 2, 4, 2)
    )

    val appAverageRating: MutableMap<String,Int> = mutableMapOf()
    appRatings.forEach{
        (key, value) ->
        appAverageRating[key] = value.sum()/value.size
    }

   val filteredAppAverageRating =  appAverageRating.filter {
       (key,value)->value>2
    }

    println(filteredAppAverageRating)


}

fun repeatTask(times: Int, task: () -> Unit){
    for (i in 1..times){
        task()
    }
}


