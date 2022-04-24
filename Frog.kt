interface IJumpAble{
    fun jump()
}

interface ISwimAble{
    fun swim()
}

class Frog:IJumpAble, ISwimAble{
    override fun jump() {
        println("Frog jumps")
    }

    override fun swim() {
        println("Frog swims")
    }
}

class Fish: ISwimAble{
    override fun swim() {
        println("Fish swims")
    }
}

class Rabbit: IJumpAble{
    override fun jump() {
        println("Rabbit jumps")
    }
}

fun main(){
    val frog = Frog()
    val fish = Fish()
    val bunny = Rabbit()
    fish.swim()
    bunny.jump()
    frog.jump()
    frog.swim()
}