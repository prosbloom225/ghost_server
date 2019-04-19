package main.java.rengine.network;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Net;
import com.badlogic.gdx.net.Socket;
import com.badlogic.gdx.net.SocketHints;

import java.io.IOException;

public class NetworkManager {
    public void sendPacket(IPacket packet) {
        SocketHints socketHints = new SocketHints();
        // Socket will time our in 4 seconds
        socketHints.connectTimeout = 4000;
        //create the socket and connect to the server entered in the text box ( x.x.x.x format ) on port 9021
        Socket socket = Gdx.net.newClientSocket(Net.Protocol.TCP, "localhost", 9021, socketHints);
        try {
            // write our entered message to the stream
            //socket.getOutputStream().write(packet.getBytes());
            socket.getOutputStream().write("getmap".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
