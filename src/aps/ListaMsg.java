/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aps;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

/**
 *
 * @author lsfo
 */
public class ListaMsg {

    private final int serverPort;
    private final String serverIP;
    private final Socket s;

    public ListaMsg() throws IOException {

        serverPort = 8000;
        serverIP = "localhost";
        s = new Socket(serverIP, serverPort);
    }

    public ArrayList<Mensagem> listar(String usuario) throws IOException, ClassNotFoundException {
        
        ObjectOutputStream outCommand = new ObjectOutputStream(s.getOutputStream());
        outCommand.writeObject("listar");

        ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());
        out.writeObject(usuario);
        
        ObjectInputStream inObj = new ObjectInputStream(s.getInputStream());
        ArrayList<Mensagem> lista = (ArrayList<Mensagem>) inObj.readObject();
        
        return lista;
    }

}
