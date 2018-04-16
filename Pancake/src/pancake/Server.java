package pancake 
        ;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Server {

    public static void main(String[] args) {
        
        ClientList clients = new ClientList();
        
        try (
            ServerSocket server = new ServerSocket(1337);
            ) {
            while(clients.size()<4) {
                clients.newClient(new ClientThread(server.accept(), clients));
            }
            // All clients connected at this point
            
            /* Now we'll sennd 10 questions to everyone and wait for everyone's
            answer */
            for(int i=0; i<10; i++) {
                String question = "Server: Is this a question?" + i;
                System.out.println(question);
                clients.sendAll(question);
 
            }
            
        } catch (IOException e) {
        }
    }
    
}
