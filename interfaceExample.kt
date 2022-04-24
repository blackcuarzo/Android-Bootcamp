interface PersonInfoProvider{
    fun printInfo(person:Person){} // This solves the error
}

class BasicInfoProvider: PersonInfoProvider{
    //Now there is an implementation of the printInfo method, even if those are empty brackets. That is called "a default implementation" provided by the interface itself.
}

fun main(){
    val provider = BasicInfoProvider()
}