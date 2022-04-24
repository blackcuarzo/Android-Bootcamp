interface PersonInfoProvider{
    fun printInfo(person:Person) // This creates an error
}

class BasicInfoProvider: PersonInfoProvider{
    //The error is because there is no implementation of the printInfo method
}

fun main(){
    val provider = BasicInfoProvider()
}