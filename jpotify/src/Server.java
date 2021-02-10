import java.io.IOException;
import java.net.*;
import java.util.ArrayList;

public class Server implements Runnable {
    private ServerSocket serverSocket;
    private ArrayList<Socket> sockets;
    static final int PORT = 1337;
    @Override
    public void run() {
        while (true){
            try{
             Socket socket = serverSocket.accept();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
