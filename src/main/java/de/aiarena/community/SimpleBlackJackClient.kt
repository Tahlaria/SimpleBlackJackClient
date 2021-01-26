package de.aiarena.community

fun main(args: Array<String>){
    SimpleBlackJackClient("ai-arena.de",1805,"YOUR KEY",true)

    while(true){
        Thread.sleep(5000)
    }
}

class SimpleBlackJackClient(host: String, port: Int, secret: String,debug: Boolean = false){
    private val client: AMTPClient

    init{
        client = AMTPClient(host,port,secret,this::onMessage,debug=debug)
    }

    private fun onMessage(msg: MessageFromServer, myTurn: Boolean){
        if(myTurn){
            client.send(
                    MessageToServer("GAME","AMTP/0.0",
                    hashMapOf(
                            "Action" to "Hit"
                    ))
            )
        }
    }
}