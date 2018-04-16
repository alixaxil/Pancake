package pancake;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ClientList {
    List<ClientThread> list = new ArrayList();

    public synchronized void sendAll(Object uzenet) {
        for(ClientThread client: list) {
            client.send(uzenet);
        }
       for(int i = 20; i >= 0; i--) {
            System.out.println(i + " seconds remaining");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(ClientList.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
    public synchronized void newClient(ClientThread client) {
        list.add(client);
        client.start();
    }
    
    public synchronized void clientSignedOff(ClientThread client) {
        list.remove(client);
    }

    int size() {
        return list.size();
    }

    void waitForAnswers() {
        
    }
}
