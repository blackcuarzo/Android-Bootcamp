interface IJumpAble{
    fun jump()
    fun jumpHigger()
}

class JumpAbleImp:IJumpAble{
    override fun jump() {
        println("Jump")
    }

    override fun jumpHigger() {
        println("High jump")
    }
}

interface ISwimAble{
    fun swim()
    fun swimFaster()
}

class SwimAbleImp:ISwimAble{
    override fun swim() {
        println("Swim")
    }

    override fun swimFaster() {
        println("Swim velocity augmented")
    }
}

class Frog(jumpable:IJumpAble = JumpAbleImp(), swimable:ISwimAble = SwimAbleImp()) : IJumpAble by jumpable, ISwimAble by swimable{
    override fun jump() {
        println("Frog jumps")
    }
    override fun jumpHigger() {
        println("Frog jumps higher")
    }

    override fun swim() {
        println("Frog swims")
    }
}
class Fish(swimable: ISwimAble = SwimAbleImp()): ISwimAble by swimable{
    override fun swim() {
        println("Fish swims")
    }
}
class Rabbit(jumpable: IJumpAble = JumpAbleImp()): IJumpAble by jumpable{
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
    frog.jumpHigger()
    frog.swimFaster()
}