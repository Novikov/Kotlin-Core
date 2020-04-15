package lambdas

fun main(args:Array<String>){
}

data class TShirt(val size:Int, val color:Int, val price:Double)

data class User(val name:String, var email:String, var shoppingCart: ShoppingCart)

data class Address(val name:String, val street:String, val city:String, val zipCOde:String)

class ShoppingCart(val clothesList:List<TShirt>, val address: Address)