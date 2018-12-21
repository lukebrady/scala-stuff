// Messing around with classes and objects in Scala.
class Account(var username: String, var password: String) {
    def printUser = {
        println(username)
    }
    def printPassword = {
        println(password)
    }
}

object StructureTest {
    def main(args : Array[String])  ={
        val s = new Account("ltbrady","testpass")
        s.printUser
        s.printPassword
    }
}