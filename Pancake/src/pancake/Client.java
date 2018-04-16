package pancake;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Client {
    
   public static void main(String[] args) {
       try(Socket client = new Socket("localhost", 1337);
           ObjectOutputStream output = new ObjectOutputStream(client.getOutputStream());
           ObjectInputStream input = new ObjectInputStream(client.getInputStream());) {         
           
           ClientInput clientInput = new ClientInput(output);
           clientInput.start();
           
           Object readObject;
           try {
               while(true) {
                   readObject = input.readObject();
                   System.out.println(readObject.toString());
                   
               }
           } catch (ClassNotFoundException ex) {
               Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
           }
           
           
          
           System.in.close();
       } catch(IOException e) {
           
       }
   }
    
}
