import com.corundumstudio.socketio.Configuration
import com.corundumstudio.socketio.SocketIOServer


fun main(args:Array<String>){
    val config = Configuration()

    config.hostname = "192.168.5.101"

    config.port = 6666
    val server = SocketIOServer(config)

    server.addConnectListener { client ->
        println(client.sessionId.toString() + "已连接")
    }
    server.start();
}