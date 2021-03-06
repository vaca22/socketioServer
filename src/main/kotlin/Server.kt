import com.corundumstudio.socketio.Configuration
import com.corundumstudio.socketio.SocketIOServer
import com.mongodb.BasicDBObject
import com.mongodb.DBObject
import com.mongodb.MongoClient
import com.mongodb.MongoClientURI
import sun.rmi.runtime.Log
import java.util.*


fun main(args:Array<String>){
    val config = Configuration()

    config.hostname = "192.168.5.101"
    val mongoClient = MongoClient(MongoClientURI("mongodb://localhost:27017"))
    config.port = 6666
    val server = SocketIOServer(config)

    server.addConnectListener { client ->
        println(client.sessionId.toString() + "已连接")
    }
    server.start();


    val books = Arrays.asList(27464, 747854)
    val person: DBObject = BasicDBObject("_id", "j56o")
        .append("name", "Jo jhgoggs")
        .append(
            "address", BasicDBObject("street", "123 Fake St")
                .append("city", "Faketon")
                .append("state", "MA")
                .append("zip", 12345)
        )
        .append("books", books)


    val database = mongoClient.getDB("Examples");
    val collection = database.getCollection("people");
//    collection.insert(person);


    val query: DBObject = BasicDBObject("_id", "jo")
    val cursor = collection.find(query)
    val name=cursor.one()["name"] as String
    println("sdfsdf  "+name)
}