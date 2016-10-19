/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apsclientdad;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 *
 * @author lsfo
 */
public class ApsClientDAD {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        int serverPort = 8000;
        String serverIP = "localhost";
        Socket s = new Socket(serverIP, serverPort);

        ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());
        out.writeObject("Olá");
        DataInputStream in = new DataInputStream(s.getInputStream());
        String data = in.readUTF();
        System.out.println(data);
    }

}
