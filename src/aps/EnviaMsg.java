/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aps;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 *
 * @author lsfo
 */
public class EnviaMsg {

    private final int serverPort;
    private final String serverIP;
    private final Socket s;

    public EnviaMsg() throws IOException {

        serverPort = 8000;
        serverIP = "localhost";
        s = new Socket(serverIP, serverPort);
    }

    public void enviar(Mensagem mensagem) throws IOException, ClassNotFoundException {

        ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());
        out.writeObject("enviar");
        
        out.writeObject(mensagem);
    }

}
