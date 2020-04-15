package classes

fun main (args:Array<String>){
    val Jane:User = User()
    val John:User = User()

    val listOne:MovieList = MovieList(name = "list one")
    val listTwo:MovieList = MovieList(name ="list two")

    Jane.addList(listOne)
    John.addList(listTwo)

    Jane.mapOfMovies["list one"]?.listOfMovies?.add("Rambo")
}

class User(){
 var mapOfMovies:MutableMap<String,MovieList?> = mutableMapOf()

    fun addList(movieList:MovieList){
        mapOfMovies.put(movieList.name,movieList)
    }

    fun list(name:String):MovieList?{
        return mapOfMovies[name]
    }

}

class MovieList(val name: String, val listOfMovies: MutableList<String> = mutableListOf()){

    fun print(){
        listOfMovies.forEach {
            println(it)
        }
    }
}