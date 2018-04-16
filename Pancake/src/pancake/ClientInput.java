package pancake;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClientInput extends Thread {
    
    ObjectOutputStream output;

    public ClientInput(ObjectOutputStream output) {
        this.output = output;
    }
    
    @Override
    public void run() {
        Scanner in = new Scanner(System.in);
        while(in.hasNextLine()) {
            try {
                output.writeObject(in.nextLine());
                output.flush();
            } catch (IOException ex) {
                Logger.getLogger(ClientInput.class.getName()).log(Level.SEVERE, null, ex);
            }
         
        }
    }
}
