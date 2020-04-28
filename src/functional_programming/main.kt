package functional_programming

fun main(args:Array<String>){
    val firstRobot = Robot("Experimental Space Navigation Droid")
    val secondRobot = Robot("Extra-Terrestrial Air Safety Droid")
    val onBattleEnded = {winner:Robot->winner.report("${winner.name} Won!")}

    //Battlefield.beginBattle(firstRobot, secondRobot){it.report("${it.name} won!")}
    //После того, как мы написали функцию расширения к лямбде - можно обращаться к ней без it
    //Мы пишем функцию расширения через лямбду к объекту Robot, а значит имеем доступ ко всем его полям. it не нужен.
    Battlefield.beginBattle(firstRobot, secondRobot){report("$name won!")}
}