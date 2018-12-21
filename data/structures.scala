import java.io._
import java.util.HashMap
// Messing around with classes and objects in Scala.
class Account(var username: String, var password: String) {
    def printUser = {
        println(username)
    }
    def printPassword = {
        println(password)
    }
}

@SerialVersionUID(1234L)
class Pokemon(var name: String, var ptype: String, var level: Int) 
extends Serializable {
    // Convert the object into a JSON string.
    def toJSON : String = {
        "\'{\"Name\":\""+name+"\",\"Type\":\""+ptype+"\",\"Level\":\""+level+"\"}\'"
    }
    // Convert the object into a HashMap.
    def toHashMap : HashMap[String, String] = {
        val hash : HashMap[String,String] = new HashMap[String,String]()
        hash.put("Name", name)
        hash.put("Type", ptype)
        hash.put("Level", level.toString)
        return hash
    }
}

object PokeSerializer {
    // Serialize a Pokemon to disk.
    def seralizePokemon(obj: Pokemon) = {
        val objOutput = new ObjectOutputStream(new FileOutputStream(f"./data/pokemon/${obj.name}%s"))
        objOutput.writeObject(obj)
        objOutput.close
    }
    // Deserialize a Pokemon from disk.
    def deseralizePokemon(name: String) : Pokemon = {
        val objInput = new ObjectInputStream(new FileInputStream(f"./data/pokemon/$name%s"))
        val pokemon = objInput.readObject.asInstanceOf[Pokemon]
        objInput.close
        return pokemon
    }
}

object StructureTest extends App {
    val pikachu : Pokemon = new Pokemon("Pikachu", "Electric", 5)
    PokeSerializer.seralizePokemon(pikachu)
    val pokemon = PokeSerializer.deseralizePokemon("pikachu")
    val json = pokemon.toJSON
    val hash = pokemon.toHashMap
    println(hash)
    println(json)
}