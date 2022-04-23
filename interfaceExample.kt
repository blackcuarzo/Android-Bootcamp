interface PersonInfoProvider{
    fun printInfo(person:Person)
}

abstract class BasicInfoProvider: PersonInfoProvider

fun main{
    val provider = BasicInfoProvider() // Error, you cannot instantiate an abstract class
}