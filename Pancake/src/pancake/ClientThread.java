package pancake;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ClientThread extends Thread {
    
    Socket kliens;
    ClientList clients;

    public ClientThread(Socket kliens, ClientList clients) {
        this.kliens = kliens;
        this.clients = clients;
    }

    @Override
    public void run() {
        try(Scanner in = new Scanner(kliens.getInputStream())){
            while(in.hasNextLine()){
                String line = in.nextLine();
                //clients.sendAll(line);
            }
        } catch(IOException e) {
        } finally {
            clients.clientSignedOff(this);
        }
    }

    void send(Object answer) {
        ObjectOutputStream output;
        try {
            output = new ObjectOutputStream(kliens.getOutputStream());
            output.writeObject(answer);
            output.flush();
        } catch (IOException ex) {
            Logger.getLogger(ClientThread.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }

}
