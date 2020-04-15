package lambdas

fun main (args:Array<String>){
val addLambda = {a:Int,b:Int->a+b}
    //передача в функцию лямбды
    println(operateOnNumbers(4,2,addLambda))
    //передача в функцию реальную функцию через reference operator
    println(operateOnNumbers(4, 4, operation = ::addFunction))
    //Определение лямбды внутри параметров функции
    println(operateOnNumbers(4,8,operation = {a:Int,b:Int -> a + b}))
    //Можно сократить синтаксис предыдущей операции
    println(operateOnNumbers(4,1,operation = {a,b -> a + b}))
    //Если лямбда передается как final то можно еще больше сократить
    println(operateOnNumbers(4,1) {a,b -> a + b})

    //лямбда которая ничего не возвращает. Мы обязательно должны указать тип Unit чтобы компилятор распознал лямбду
    var unitLambda:()->Unit = {
        println("Simple lambda")
    }
    unitLambda()

}
fun addFunction(a: Int, b:Int) = a + b

//Lambda as function parametr
fun operateOnNumbers(a:Int, b:Int, operation:(Int,Int)->Int):Int{
    val result = operation(a,b)
    return result
}