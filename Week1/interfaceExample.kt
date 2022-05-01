interface PersonInfoProvider{
    fun printInfo(person:Person){
        println("printInfo default implementation inside the interface")
        person.printInfo()
    }
}

class BasicInfoProvider: PersonInfoProvider{

}

fun main(){
    val provider = BasicInfoProvider()
    provider.printInfo(Person())
}